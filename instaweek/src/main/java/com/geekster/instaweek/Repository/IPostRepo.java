package com.geekster.instaweek.Repository;

import com.geekster.instaweek.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {
}
