package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// forma antiga de implementar o security

// o @WebEnableWebSecurity desativa todas condigurações padrões do security
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // esse método pertence ao webSecurityConfigurerAdapter
    // para customizar a configuração do http security
    // que eh justamente onde iremos receber essas solicitações http
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // inicio o http, defino que vamos utilizar o httpBasic
        // o metodo and eh para unir configurações
        // e aí estamos permitindo acesso para quaisquer requisições
        // ou seja, ta de forma generica para todas requisições dessa aplicação
//        http
//                .httpBasic()
//                .and()
//                .authorizeHttpRequests()
//                .anyRequest().permitAll();

        // agora vamos fazer com restrição de acesso
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
