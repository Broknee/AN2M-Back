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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.annotation.security.PermitAll;

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
       http.
      
        
        csrf().
        
        
        disable();
       
       /* 
        
                .authorizeHttpRequests((authorize) ->{
                        
							try {
								authorize
								      
								        // .requestMatchers("/register/**").permitAll()
								        .requestMatchers("/**").permitAll();

								      //  .requestMatchers("/prospectsList","/error403","/addProspect","/delete_prospect/**","updateprospect/**","/").hasAnyRole("USER","ADMIN");

								  
//								
//								authorize.requestMatchers("/delete_user/**").hasRole("ADMIN");
//								authorize.and().exceptionHandling().accessDeniedPage("/error403");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                }
                                
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                
                                .defaultSuccessUrl("/index",true) 
                                   
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
 
        */
       
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
