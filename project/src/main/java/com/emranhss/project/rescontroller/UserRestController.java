package com.emranhss.project.rescontroller;
import com.emranhss.project.dto.AuthenticationResponse;
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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin("*")
public class UserRestController {


    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveUser(
            @RequestPart(value = "user") String userJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        try {
            userService.saveOrUpdate(user, file);
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Message", "User save failed " + e);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);

    }


    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse>  login(@RequestBody User request){
        return ResponseEntity.ok(userService.authencate(request));

    }


    @GetMapping("/active/{id}")
    public ResponseEntity<String> activeUser(@PathVariable("id") int id){

        String response= userService.activeUser(id);
        return  ResponseEntity.ok(response);
    }


}
