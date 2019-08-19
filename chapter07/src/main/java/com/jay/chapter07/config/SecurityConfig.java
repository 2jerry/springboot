package com.jay.chapter07.config;


// 시큐리티 설정 파일

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
    private BoardUserDetailService boardUserDetailService;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests().antMatchers("/").permitAll();
        security.authorizeRequests().antMatchers("/member/**").authenticated();
        security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
        security.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

        security.csrf().disable();
        security.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
        security.exceptionHandling().accessDeniedPage("/accessDenied");
        security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");

        security.userDetailsService(boardUserDetailService);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

   /* @Autowired
    public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
        String query1 = "select id username, concat('{noop}',password)" +
                "password, true enable from member where id=?"; // 사용자가 입력한 정보로 정보를 조회하고
        String query2 = "select id, role from member where id=?"; // 쿼리는 권한 정보를 조회한다.

        auth.jdbcAuthentication() // DB에 저장된 사용자로 인증을 처리하기 위해서
                .dataSource(dataSource)
                .usersByUsernameQuery(query1) // db 인증에 성공했는지
                .authoritiesByUsernameQuery(query2); // 권한

    }*/
}
