package com.g.GymBuddyBE.Services.Impl;

import com.g.GymBuddyBE.CustomExceptions.EmailTakenException;
import com.g.GymBuddyBE.Mappers.UserMapper;
import com.g.GymBuddyBE.Model.Login.User;
import com.g.GymBuddyBE.Repositories.UserRepo;
import com.g.GymBuddyBE.Services.UserService;
import com.g.GymBuddyBE.dto.auth.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public User add(RegisterDTO dto) {
        if( userRepo.findByEmail(dto.getEmail()) != null)
            throw new EmailTakenException("An account with this email already exists");

        User newUser = UserMapper.DTOtoEntity(dto);
        userRepo.save(newUser);

        return newUser;
    }
}
