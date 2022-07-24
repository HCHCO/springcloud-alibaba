package com.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import javax.annotation.Resource;

@Configuration
public class ResourceConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()
                .anyRequest().access("#oauth2.hasScope('hello')");
    }

}
