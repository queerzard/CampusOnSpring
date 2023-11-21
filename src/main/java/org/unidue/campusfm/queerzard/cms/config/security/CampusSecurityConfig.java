package org.unidue.campusfm.queerzard.cms.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
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
                .csrf().ignoringAntMatchers("/api/v1/**", "/register").and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/home").permitAll()
                    .antMatchers("/search").permitAll()
                    .antMatchers("/article").permitAll()
                    .antMatchers("/about").permitAll()
                    .antMatchers("/author/**").permitAll()
                    .antMatchers("/contact").permitAll()
                    .antMatchers("/listen").permitAll()
                    .antMatchers("/imprint").permitAll()
                    .antMatchers("/program").permitAll()
                    .antMatchers("/contribute").permitAll()
                    .antMatchers("/assets/**").permitAll()
                    .antMatchers("/assets/dashboard/**").permitAll()

                    .antMatchers("/api/v1/**").permitAll()

                    .antMatchers("/login").permitAll()
                    .antMatchers("/logout").permitAll()

                    .antMatchers("/myprofile").authenticated()
                    .antMatchers("/compose").authenticated()
                    .antMatchers("/register").authenticated()

                .anyRequest().authenticated()

                .and()
                    .formLogin()
                        .loginPage("/login")
                        .failureUrl("/login?error").permitAll()
                        .defaultSuccessUrl("/myprofile", true)

                .and()
                    .logout().logoutUrl("/logout")
                        .invalidateHttpSession(true) // Invalidate the user's session
                        .clearAuthentication(true)    // Clear authentication information
                        .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                        .permitAll()

/*                .and()
                    .rememberMe()
                        .key("v3ry23cr3tk3y")
                        .rememberMeParameter("remember")
                        .tokenValiditySeconds(86400)

                .and()
                    .sessionManagement()
                        .maximumSessions(1)
                        .expiredUrl("/login?expired")
                        .sessionRegistry(sessionRegistry())*/;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider/*()*/);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();};

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }


}
