package com.g.GymBuddyBE.Controllers;

import com.g.GymBuddyBE.CustomExceptions.EmailTakenException;
import com.g.GymBuddyBE.Services.UserService;
import com.g.GymBuddyBE.dto.auth.AuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.add(dto));
        } catch (EmailTakenException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already taken");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.authenticate(dto));
        } catch (EmailTakenException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
        }
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getEmail());
//        if (userDetails != null) return ResponseEntity.ok("jwtUtil.generateToken(userDetails)");
//        return ResponseEntity.status(400).body("Invalid credentials");
    }
}
