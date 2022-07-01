package com.quranschool.domain.home.controller;

import com.quranschool.configuration.security.service.MyUserDetailsService;
import com.quranschool.configuration.security.util.JwtUtils;
import com.quranschool.domain.home.model.AuthenticationRequest;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/")
    public ResponseEntity getHome() {
        return new ResponseEntity("Hello World", HttpStatus.OK);
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName()
                , authenticationRequest.getPassword()));

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        String token = jwtUtils.generateToken1(userDetails);
        Claims userName = jwtUtils.extractMobile(token);
        HashMap hashMap = new HashMap();
        hashMap.put("token", token);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }
}
