package org.unidue.campusfm.queerzard.cms.database.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;
import org.unidue.campusfm.queerzard.cms.database.repositories.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserEntity userEntity;
        if((userEntity = userRepository.findUserEntityByUsername(s)) == null || (userEntity = userRepository.findUserEntityByEmail(s)) == null)
            throw new UsernameNotFoundException("User not found with username/email: " +  s);

        return new org.unidue.campusfm.queerzard.cms.database.services.user.UserDetails(userEntity);
    }
}
