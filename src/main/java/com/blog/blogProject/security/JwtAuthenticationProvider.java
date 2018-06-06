package com.blog.blogProject.security;

import com.blog.blogProject.model.JwtAuthenticationToken;
import com.blog.blogProject.model.JwtUser;
import com.blog.blogProject.model.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator JwtValidator;
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken=(JwtAuthenticationToken) usernamePasswordAuthenticationToken;
       String token=jwtAuthenticationToken.getToken();

       JwtUser jwtUser=JwtValidator.validate(token);
       if(jwtUser==null){
           throw new RuntimeException("JWT Token is Not valid");
       }

        List<GrantedAuthority> grantedAuthorities=
                AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());


      return new JwtUserDetails(jwtUser.getUserName(),jwtUser.getId(),token,grantedAuthorities);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
