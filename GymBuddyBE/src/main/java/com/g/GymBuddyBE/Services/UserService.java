package com.g.GymBuddyBE.Services;

import com.g.GymBuddyBE.Model.Login.User;
import com.g.GymBuddyBE.dto.auth.RegisterDTO;

public interface UserService {
    User add(RegisterDTO dto);
}
