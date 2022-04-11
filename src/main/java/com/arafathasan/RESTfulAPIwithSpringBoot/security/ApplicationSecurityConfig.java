package com.arafathasan.RESTfulAPIwithSpringBoot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.arafathasan.RESTfulAPIwithSpringBoot.security.ApplicationUserRole.ADMIN;
import static com.arafathasan.RESTfulAPIwithSpringBoot.security.ApplicationUserRole.STUDENT;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
              .antMatchers("/","index", "/css/*", "/js/*").permitAll()
              .antMatchers("/api/**").hasRole(STUDENT.name())
              .anyRequest()
              .authenticated()
              .and()
              .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails annaSmithUser = User.builder()
                .username("AnnaSmith")
                .password(passwordEncoder.encode("password"))
                .roles(STUDENT.name())
                .build();
        UserDetails lindaUser = User.builder()
                .username("Linda")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name())
                .build();


        return new InMemoryUserDetailsManager(
                annaSmithUser,
                lindaUser
        );
    }
}
