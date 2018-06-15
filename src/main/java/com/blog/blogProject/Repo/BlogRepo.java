package com.blog.blogProject.Repo;

import com.blog.blogProject.model.BlogTable;
import com.blog.blogProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<BlogTable,Long> {

    @Query(value= "select COUNT(*) FROM blog_table where user_id = ?1",nativeQuery = true)
    int findByUserId(Long userId);

    @Query(value = "select user_id FROM blog_table where id = ?1", nativeQuery = true)
    int findUserIdFromBlog(Long userId);
}

