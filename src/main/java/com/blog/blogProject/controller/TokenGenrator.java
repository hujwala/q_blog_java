package com.blog.blogProject.controller;

import com.blog.blogProject.model.JwtUser;
import com.blog.blogProject.model.LoginSucessMsg;
import com.blog.blogProject.model.User;
import com.blog.blogProject.security.JwtTokenGenerator;
import com.blog.blogProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/loginUser")
public class TokenGenrator {

    private JwtTokenGenerator JwtGenrator;
    @Autowired
    UserService userService;
    private static final String loginSucessStatusMsg="Login sucessfull";
    private static final String loginFailStatusMsg="Login Fail";



    public TokenGenrator(JwtTokenGenerator jwtGenrator) {
        this.JwtGenrator = jwtGenrator;
    }

    @PostMapping
    @CrossOrigin(origins = {"*"})
    public LoginSucessMsg genrate(@RequestBody final JwtUser jwtUser){
        LoginSucessMsg loginStatus=new LoginSucessMsg();
        if(userService.getExistUser(jwtUser.getUserName(),jwtUser.getRole())) {
            //imp Note jwtUser.getUserName(),jwtUser.getRole() this means get email as userName and Password as Role
            JwtTokenGenerator jwtTokenGenerator=new JwtTokenGenerator();
             loginStatus.setAuthToken(jwtTokenGenerator.genrate(jwtUser));
             loginStatus.setMessage(loginSucessStatusMsg);
             loginStatus.setStatusCode("200");
        }else{

            loginStatus.setAuthToken(null);
            loginStatus.setMessage(loginFailStatusMsg);
            loginStatus.setStatusCode("400");

        }
      return   loginStatus;
    }


}
