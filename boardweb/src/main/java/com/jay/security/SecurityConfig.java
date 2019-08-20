package com.jay.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.userDetailsService(userDetailsService);

        security.authorizeRequests().antMatchers("/","/system/**").permitAll(); // 인증 안된 모든 사용자 접근 가능
        security.authorizeRequests().antMatchers("/board/**").authenticated(); // 인증된 사용자만 접근 가능
        security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN"); // admin 권한 가진 사람만 접근 가능

        security.csrf().disable();
        security.formLogin().loginPage("/system/login")
                .defaultSuccessUrl("/board/getBoardList",true); // 리다이렉트
        security.exceptionHandling().accessDeniedPage("/system/accessDenied");
        security.logout().logoutUrl("/system/logout")
                .invalidateHttpSession(true).logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
