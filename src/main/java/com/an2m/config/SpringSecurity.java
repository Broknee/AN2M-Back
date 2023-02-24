package com.an2m.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     
    	 http.cors().and().csrf().disable();
     
//        
//         authorizeHttpRequests((authorize) ->{
//                        
//							try {
//								authorize
//								      
//								        .requestMatchers("/**").permitAll();
////								       // .requestMatchers("/**").permitAll();
////
////								      //  .requestMatchers("/prospectsList","/error403","/addProspect","/delete_prospect/**","updateprospect/**","/").hasAnyRole("USER","ADMIN");
////
////								  
////								
////								//authorize.requestMatchers("/delete_user/**","api/users","api/basicauth/**").hasRole("ADMIN");
////								
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							
//         }
//                               
//              );
//        
        
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
