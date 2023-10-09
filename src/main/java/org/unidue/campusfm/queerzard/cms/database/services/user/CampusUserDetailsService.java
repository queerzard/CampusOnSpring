package org.unidue.campusfm.queerzard.cms.database.services.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;
import org.unidue.campusfm.queerzard.cms.database.repositories.UserRepository;

@Service
public class CampusUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CampusUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Bean
    public PasswordEncoder getpasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("Attempting login for username: " + s);

        UserEntity userEntity;
        if((userEntity = userRepository.findUserEntityByUsername(s)) == null || (userEntity = userRepository.findUserEntityByEmail(s)) == null)
            throw new UsernameNotFoundException("User not found with username/email: " +  s);

        return new CampusUserDetails(userEntity);
    }

/*    public void registerUser(String username, String firstName, String lastName, String email, String password){

        UserEntity user = new UserEntity();


    }*/

}
