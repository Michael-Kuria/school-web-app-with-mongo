package com.michael.schoolWebAppwithmongo.security;

import com.michael.schoolWebAppwithmongo.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdministratorRepository repository;

    @Bean
    public  LoginSuccessHandler getLoginSuccessHandler(){
        return new LoginSuccessHandler("/students");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(new AdministratorSecurityDetails(repository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .permitAll()
                .antMatchers("/**")
                .hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                //.defaultSuccessUrl("/students",true)
                .successHandler(getLoginSuccessHandler())
                .permitAll();

    }
}
