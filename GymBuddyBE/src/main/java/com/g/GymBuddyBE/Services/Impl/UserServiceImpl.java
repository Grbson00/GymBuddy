package com.g.GymBuddyBE.Services.Impl;

import com.g.GymBuddyBE.CustomExceptions.EmailTakenException;
import com.g.GymBuddyBE.Mappers.UserMapper;
import com.g.GymBuddyBE.Model.Login.User;
import com.g.GymBuddyBE.Repositories.UserRepo;
import com.g.GymBuddyBE.Security.JwtUtil;
import com.g.GymBuddyBE.Services.UserService;
import com.g.GymBuddyBE.dto.auth.AuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public User add(AuthDTO dto) {
        if(userRepo.findByEmail(dto.getEmail()).isPresent())
            throw new EmailTakenException("An account with this email already exists");
        User newUser = userMapper.DTOtoEntity(dto);
        userRepo.save(newUser);
        return newUser;
    }

    @Override
    public String authenticate(AuthDTO dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        var user = userRepo.findByEmail(dto.getEmail()).orElseThrow();
        return jwtUtil.generateToken(user);
    }
}
