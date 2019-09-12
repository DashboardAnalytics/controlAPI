package com.cencosud.controlAPI.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/controlTables/create").permitAll()
                .antMatchers(HttpMethod.POST, "/controlTables/updateStatus").permitAll()
                .antMatchers(HttpMethod.GET,"/controlTables/*").permitAll()
                .anyRequest().authenticated();
    }
}
