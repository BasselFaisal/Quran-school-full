package com.quranschool.configuration.security.service;

import com.quranschool.coreModule.enums.LocalizationLabels;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("root"))
        return new User("root", "root", new ArrayList<>());
        else
            throw new BadCredentialsException(LocalizationLabels.INVALID_LOGIN_DETAILS.toString());
    }
}
