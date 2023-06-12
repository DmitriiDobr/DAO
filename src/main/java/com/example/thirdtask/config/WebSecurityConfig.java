package com.example.thirdtask.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    DataSource dataSource;


    @Bean
    public UserDetailsManager authenticateUsers(){
        UserDetails user = User.withUsername("username").
        password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password")).build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setAuthoritiesByUsernameQuery("select username, password, enabled from users where username=?");
        users.setUsersByUsernameQuery("select username, role from users where username=?");
        users.createUser(user);
        return users;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.formLogin(httpSecurityFormLoginConfigurer ->
                httpSecurityFormLoginConfigurer.loginPage("/login").permitAll()).authorizeHttpRequests(
                        authorizationManagerRequestMatcherRegistry ->authorizationManagerRequestMatcherRegistry.
                                requestMatchers("/products/fetch-product").hasRole("write").
                                anyRequest().authenticated() );

        return http.build();
    }


}
