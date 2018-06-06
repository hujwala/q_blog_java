package com.blog.blogProject.Repo;

import com.blog.blogProject.model.BlogTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepo extends JpaRepository<BlogTable,Long> {



}

