package com.portafolio.facturacion.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(
                csrf->csrf.disable()
        ).authorizeHttpRequests(
                auth->{
                    auth.anyRequest().authenticated(); // todas las rutas o endpoints de la aplicación requieren que el usuario esté autenticado.
                }
        ).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

}
