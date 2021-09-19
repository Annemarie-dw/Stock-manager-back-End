package com.UDM.StockManager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {

        System.out.println( "Security start" );
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser( "user" )
                .password( encoder.encode( "password" ) )
                .roles( "USER", "ACTUATOR" )
                .and()
                .withUser( "admin" )
                .password( encoder.encode( "password" ) )
                .roles( "USER", "ADMIN", "ACTUATOR" );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {

        http.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS );
        http.headers().frameOptions().disable();
        http.csrf().disable();

        http.authorizeRequests( ( requests ) -> {
            requests.antMatchers( "/api/openapi.json" ).permitAll()
                    .antMatchers( "/api/*/admin/*" ).hasRole( "ADMIN" );

            requests.anyRequest().fullyAuthenticated();
        } );

        http.httpBasic(); // API uses basic authentication
        http.cors(); // Enable CORS support.
    }

}
