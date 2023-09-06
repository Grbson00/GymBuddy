package com.g.GymBuddyBE.Repositories;

import com.g.GymBuddyBE.Model.Login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
