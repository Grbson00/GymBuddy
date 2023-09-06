package com.g.GymBuddyBE.Controllers;

import com.g.GymBuddyBE.CustomExceptions.EmailTakenException;
import com.g.GymBuddyBE.Model.Login.User;
import com.g.GymBuddyBE.Services.UserService;
import com.g.GymBuddyBE.dto.auth.RegisterDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.add(dto));
        } catch (EmailTakenException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already taken");
        }
    }
}
