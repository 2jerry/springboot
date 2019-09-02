package com.jay.project1.controller;

import com.jay.project1.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public ResponseEntity<String> loginAccess(@RequestBody User user) {
        // user 정보 확인
        if (user.getUid().equals("") || user.getPassword().equals("")) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST ) // 400
                    .body("Enter the User ID and password");
        }
        if (user.getUid().equals("admin") && user.getPassword().equals("123")) {
            return  ResponseEntity
                    .status(HttpStatus.OK) // 200
                    .body("Login Success");
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED) // 401
                    .body("Login Failed (Incorrect userId or password) ");
        }

    }
}

