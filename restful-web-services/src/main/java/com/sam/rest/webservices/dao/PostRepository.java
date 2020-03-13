package com.sam.rest.webservices.dao;

import com.sam.rest.webservices.model.Post;
import com.sam.rest.webservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{
}
