package com.g.GymBuddyBE.Services;

import com.g.GymBuddyBE.Model.Login.User;
import com.g.GymBuddyBE.dto.auth.AuthDTO;

public interface UserService {
    User add(AuthDTO dto);
    String authenticate(AuthDTO dto);
}
