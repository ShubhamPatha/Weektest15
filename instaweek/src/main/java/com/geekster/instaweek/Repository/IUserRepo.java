package com.geekster.instaweek.Repository;

import com.geekster.instaweek.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,String> {
    User findFirstByUserEmail(String newEmail);
}