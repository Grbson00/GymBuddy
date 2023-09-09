package com.g.GymBuddyBE.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/")
    public ResponseEntity<String> test() {
    return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @PostMapping("/")
    public ResponseEntity<String> test1() {
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

}
