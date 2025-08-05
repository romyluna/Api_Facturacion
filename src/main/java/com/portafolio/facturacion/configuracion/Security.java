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
                    //todas las uris que comiencen con esta ruta /api/V1/productos no necesitan autorizacion de acceso
                    auth.requestMatchers("/api/V1/productos/**","/swagger-ui/**","/swagger-ui.html",
                                    "/v3/api-docs/**",
                                    "/swagger-resources/**",
                                    "/webjars/**").permitAll()
                            .anyRequest().authenticated();//el resto tiene que estar autenticado
                    //auth.anyRequest().authenticated(); // todas las rutas o endpoints de la aplicación requieren que el usuario esté autenticado.
                }
        ).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

}
