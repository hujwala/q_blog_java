package com.blog.blogProject.security;

import com.blog.blogProject.model.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokeFilter extends AbstractAuthenticationProcessingFilter {

private AuthenticationManager auenticationManager;
private JwtSucessHandler jwtSucessHandler;

    public JwtAuthenticationTokeFilter() {
        super("/rest/**");
    }

/*
    protected JwtAuthenticationTokeFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }


    public void setAuenticationManager(AuthenticationManager auenticationManager){
    this.auenticationManager=auenticationManager;
}

    public void setAuthenticationSucessHandler(JwtSucessHandler jwtSucessHandler) {
    this.jwtSucessHandler=jwtSucessHandler;
    }
    */

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

       String header= request.getHeader("Authorisation");
       System.out.println(header);

       if(header==null || !header.startsWith("Token ")){

           throw  new RuntimeException("Jwt token is missing");
       }

       String authenticationToken=header.substring(6);
        JwtAuthenticationToken token=new JwtAuthenticationToken(authenticationToken);
       return getAuthenticationManager().authenticate(token);
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request,response);
    }
}
