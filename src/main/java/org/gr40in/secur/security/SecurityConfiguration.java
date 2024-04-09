package org.gr40in.secur.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.beans.Encoder;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {
    private final AppUserDetailsService appUserDetailsService;

    @Bean
//    @Order(1)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        OAuth2AuthorizationServerAutoConfiguration
//        http.getConfigurer(OAuth2AuthorizationServerAutoConfiguration)
        return
                http.csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(auth -> auth
                                        .requestMatchers("secret*", "users*").hasAuthority("ADMIN")
                                        .requestMatchers("public*").permitAll()
//                                .requestMatchers("login*").permitAll()
                                        .requestMatchers("*images*").permitAll()
                                        .anyRequest().permitAll()
                        )

                        .formLogin(form -> form
                                .loginPage("/login")
                                .permitAll()
                                .defaultSuccessUrl("/users", true))
//                        .oauth2Login()
                        .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(appUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
