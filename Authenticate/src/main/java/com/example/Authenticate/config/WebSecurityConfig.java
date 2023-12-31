package com.example.Authenticate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/img/**", "/js/**", "/scss/**", "/vendor/**").permitAll()
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/users/**").hasRole("MANAGER")
                        .anyRequest().authenticated()
                ).formLogin(form ->
                form.loginPage("/login")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll())
                .logout(LogoutConfigurer::permitAll)
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
