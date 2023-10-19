package com.geekster.instaweek.Repository;


import com.geekster.instaweek.Model.AuthenticationToken;
import com.geekster.instaweek.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
