package com.emranhss.project.rescontroller;


import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.User;
import com.emranhss.project.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jobseeker")
@CrossOrigin("*")
public class JobSeekerRestController {


    @Autowired
    private UserService userService;


    @PostMapping("")
    public ResponseEntity<Map<String, String>> registerJobSeeker(
            @RequestPart(value = "user") String userJson,
            @RequestPart(value = "jobseeker") String jobSeekerJson,
            @RequestParam(value = "photo")MultipartFile file
            ) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);
        JobSeeker jobSeeker = objectMapper.readValue(jobSeekerJson, JobSeeker.class);
        try {
            userService.registerJobSeeker(user,file,jobSeeker);
            Map<String, String> response = new HashMap<>();

            response.put("Message", "User registered successfully");

            return new ResponseEntity<>(response, HttpStatus.OK);
        }  catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();

            errorResponse.put("Message","User Registration Failed");

            return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }
}
