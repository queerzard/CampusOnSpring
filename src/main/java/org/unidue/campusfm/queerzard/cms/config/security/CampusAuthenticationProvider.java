
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.config.security;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;

@Component @Slf4j
public class CampusAuthenticationProvider implements AuthenticationProvider {



    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    public CampusAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (authentication.getCredentials().toString());
        System.out.println(password);

        log.info("Incoming login attempt: {}", username);

        CampusUserDetails userDetails = (CampusUserDetails) userDetailsService.loadUserByUsername(username);
        if (userDetails == null){
            log.warn("Someone attempted to log on with the username {} but that account does not exist.", username);
            throw new UsernameNotFoundException("User not found");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())){
            log.warn("Someone attempted to log on with the username {} but the password mismatched.", username);
            throw new AuthenticationException("Invalid credentials") {};
        }

        if(!userDetails.isEnabled()){
            log.warn("Someone attempted to log on to a disabled account with the username {}", username);
            throw new AuthenticationException("Account Disabled!") {};
        }

        userDetails.getUserEntity().updateLastLogin();
        userService.update(userDetails.getUserEntity());
        // Create a fully authenticated Authentication object
        Authentication authenticated = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        log.info("{} logged on.", username);

        return authenticated;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        // Return true if this AuthenticationProvider supports the provided authentication class
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
