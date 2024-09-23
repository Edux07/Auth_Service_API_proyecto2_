package com.example.authservice_proyecto2.config;

import com.example.authservice_proyecto2.Service.impl.UserDetailsServiceimpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsServiceimpl userDetailsServiceimpl;

    public SecurityConfig(UserDetailsServiceimpl userDetailsServiceimpl) {
        this.userDetailsServiceimpl = userDetailsServiceimpl;
    }

    @Bean
    public securityFiltreChain securityFiltreChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults()).
                authorizeHttpRequests(request -> request.requestMatchers("v1/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()).sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsServiceimpl);
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
}
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthAutenticationManager authAutenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return new AuthAutenticationManager(authenticationConfiguration.getAuthenticationManager());
    }


}
