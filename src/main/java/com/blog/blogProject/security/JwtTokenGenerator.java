package com.blog.blogProject.security;

import com.blog.blogProject.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenGenerator {
    public String genrate(JwtUser jwtUser) {

        Claims clims= Jwts.claims()
                .setSubject(jwtUser.getUserName());
        clims.put("userId",jwtUser.getId());
        clims.put("role",jwtUser.getRole());
      return   Jwts.builder().setClaims(clims)
              .signWith(SignatureAlgorithm.HS512,"youtube").compact();
    }
}
