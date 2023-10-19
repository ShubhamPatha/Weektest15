package com.geekster.instaweek.Service.hashingUtility;

import com.geekster.instaweek.Model.Post;
import com.geekster.instaweek.Model.User;
import com.geekster.instaweek.Repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    public String createInstaPost(Post post) {
        post.setCreatedDate(LocalDateTime.now());
        postRepo.save(post);
        return "Post uploaded!!!!";
    }

    public String removeInstaPost(Integer postId, User user) {

        Post post  = postRepo.findById(postId).orElse(null);
        if(post != null && post.getUser().equals(user))
        {
            postRepo.deleteById(postId);
            return "Removed successfully";
        }
        else if (post == null)
        {
            return "Post to be deleted does not exist";
        }
        else{
            return "Un-Authorized delete detected....Not allowed";
        }
    }

    public boolean validatePost(Post instaPost) {
        return (instaPost!=null && postRepo.existsById(instaPost.getPostId()));
    }


    public Post getPostById(Integer id) {
        return postRepo.findById(id).orElse(null);
    }


}
