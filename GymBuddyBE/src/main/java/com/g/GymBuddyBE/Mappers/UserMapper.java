package com.g.GymBuddyBE.Mappers;

import com.g.GymBuddyBE.Enums.UserRoles;
import com.g.GymBuddyBE.Model.Login.User;
import com.g.GymBuddyBE.dto.auth.AuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    public User DTOtoEntity(AuthDTO dto) {
        final var newUser = User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(UserRoles.USER)
                .build();
        return newUser;
    }
}
