package com.g.GymBuddyBE.Mappers;

import com.g.GymBuddyBE.Model.Login.User;
import com.g.GymBuddyBE.dto.auth.RegisterDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static User DTOtoEntity(RegisterDTO dto) {
        //TODO: has passwords later
        final var newUser = User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        return newUser;
    }
}
