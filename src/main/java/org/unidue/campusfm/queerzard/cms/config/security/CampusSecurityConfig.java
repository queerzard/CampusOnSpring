package org.unidue.campusfm.queerzard.cms.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetailsService;

@Order(value = -1)
@Configuration
@EnableWebSecurity
public class CampusSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CampusUserDetailsService userDetailsService;

    private final CampusAuthenticationProvider authenticationProvider;
    @Autowired
    public CampusSecurityConfig(CampusAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //TODO: MAKE. AUTHENTICATION. WORK?!

        http
                /*.csrf().disable()*/
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/search").permitAll()
                .antMatchers("/article").permitAll()
                .antMatchers("/about").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/listen").permitAll()
                .antMatchers("/imprint").permitAll()
                .antMatchers("/program").permitAll()
                .antMatchers("/contribute").permitAll()
                .antMatchers("/failLol").permitAll()
                .antMatchers("/assets/**").permitAll()

                .antMatchers("/login").permitAll()
                .antMatchers("/myprofile").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/failLol").permitAll()
                .defaultSuccessUrl("/", true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());*/
        auth.authenticationProvider(authenticationProvider/*()*/);
    }

/*    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
        return daoAuthenticationProvider;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();};

}
