package com.geekster.instaweek.Controller;


import com.geekster.instaweek.Model.Post;
import com.geekster.instaweek.Model.User;
import com.geekster.instaweek.Model.dto.SignInInput;
import com.geekster.instaweek.Model.dto.SignUpOutput;
import com.geekster.instaweek.Service.AuthenticationService;
import com.geekster.instaweek.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


    //sign up, sign in , sign out a particular instagram user
    @PostMapping("user/signup")
    public SignUpOutput signUpInstaUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInInstaUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutInstaUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    //content on instagram

    @PostMapping("post")
    public String createInstaPost(@RequestBody Post post, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.createInstaPost(post,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @DeleteMapping("post")
    public String removeInstaPost(@RequestParam Integer postId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removeInstaPost(postId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @GetMapping("post/{postId}")
    public Post getLikeCountByPost(@PathVariable Integer postId, @RequestParam String userEmail, @RequestParam String userToken)
    {
        Post k=new Post();
        if(authenticationService.authenticate(userEmail,userToken)) {
            k= userService.getPostdetail(postId,userEmail);
        }
      return k;
    }









}


