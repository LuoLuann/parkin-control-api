package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    // vamos utilizar uma autentificação por memoria para fins de aprendizagem
    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {

        // precisa colocar pelo menos uma role, mas pode ter várias
        // o spring security olha um password encoder, não uma senha comum
        auth.inMemoryAuthentication()
                .withUser("luann")
                .password(passwordEncoder().encode("12345678"))
                .roles("ADMIN");
    }

    // essa função serve para encoder a senha, para que então o spring security
    // valide ela, eh um bean do próprio spring security
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
