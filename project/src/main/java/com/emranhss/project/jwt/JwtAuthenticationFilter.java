package com.emranhss.project.jwt;


import com.emranhss.project.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component  // Marking this class as a Spring Bean Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // Injecting JwtService to handle token operations (extract username, validate token)
    private final JwtService jwtService;

    // Injecting UserService to load user details from the database

    private final UserService userService;

    public JwtAuthenticationFilter(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    // This method will be executed once per HTTP request
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        System.out.println("JwtAuthenticationFilter: Incoming request to " + request.getRequestURI());
        // Extracting the Authorization header from the HTTP request
        String authHeader = request.getHeader("Authorization");
        System.out.println("Authorization header: " + authHeader);


        if (authHeader == null || !authHeader.startsWith("Bearer ")) {

            // If no token found or token format is incorrect, proceed with the filter chain
            System.out.println("No JWT token found, skipping filter.");
            filterChain.doFilter(request, response);
            return;  // Exit current filter as no JWT is provided
        }


        // Extracting the JWT token from the Authorization header (removing "Bearer " prefix)
        String token = authHeader.substring(7);

        // Extracting the username from the token using JwtService
        String username = jwtService.extractUserName(token);
        System.out.println("Extracted Username from Token: " + username);


        // Proceed only if username is extracted and user is not already authenticated
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Loading user details (from DB) using UserService based on extracted username
            UserDetails userDetails = userService.loadUserByUsername(username);
            boolean valid = jwtService.isValid(token, userDetails);
            System.out.println("Token validation result: " + valid);


            // Validating the token against the loaded user details
            if (jwtService.isValid(token, userDetails)) {

                // If token is valid, create an Authentication token (Spring Security standard)
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,    // Credentials (password) — null since already authenticated
                        userDetails.getAuthorities()
                );


                // Building web authentication details (like remote IP, session ID) from the request

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );


                // Setting the authentication object in Spring Security's SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        }

        // Continue with the remaining filter chain (other filters, controllers, etc.)
        filterChain.doFilter(request, response);
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        System.out.println("Incoming Request Path: " + path);  // Add this log
        boolean skip = path.equals("/api/user/login") || path.startsWith("/images/") || path.startsWith("/api/user/active/") || path.startsWith("/auth/login");
        System.out.println("Should Skip Filter: " + skip);  // Add this log
        return skip;
    }
}
