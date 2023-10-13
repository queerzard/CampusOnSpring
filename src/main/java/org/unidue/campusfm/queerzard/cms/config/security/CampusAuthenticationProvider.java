package org.unidue.campusfm.queerzard.cms.config.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;

@Component
public class CampusAuthenticationProvider implements AuthenticationProvider {


    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public CampusAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (authentication.getCredentials().toString());
        System.out.println(password);

        CampusUserDetails userDetails = (CampusUserDetails) userDetailsService.loadUserByUsername(username);
        if (userDetails == null)
            throw new UsernameNotFoundException("User not found");

        if (!passwordEncoder.matches(password, userDetails.getPassword()))
            throw new AuthenticationException("Invalid credentials") {};

        // Create a fully authenticated Authentication object
        Authentication authenticated = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        return authenticated;
    }
    @Override
    public boolean supports(Class<?> authentication) {
        // Return true if this AuthenticationProvider supports the provided authentication class
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
