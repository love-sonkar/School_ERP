//package com.School_ERP.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
//         http
//                .authorizeHttpRequests(g->g.requestMatchers("/","/ws/**").permitAll()
//
//                        .anyRequest().authenticated()
//
//                ).formLogin(form->form
//                         .loginPage("/login").permitAll());
//
//                        http .logout( logout -> logout.logoutSuccessUrl("/"));
//
//        return http.build();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("test")
//                .password("test")
//                .roles("USER")
//                .build();
//
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("rahul")
//                .password("rahul")
//                .roles("USER")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user,user1);
//    }
//
//}
