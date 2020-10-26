package ru.inno.webinar.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    //сервис, котрый отвечает за загрузку пользователей
    @Qualifier("CustomUserDetails") //помогает найти именно наш (а не Spring) класс userDetailsService для правильного autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder; //хеширование паролей

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/users").authenticated() //страница доступна только для авторизированных
                .antMatchers("/signUp").permitAll() //для всех
                .and()
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("email") //параметр отвечающий за username - email, т.е. со страницы входа будет отправляться email вместо username
                .passwordParameter("password")
                .defaultSuccessUrl("/users") //если пользователь авторизовался, то отправляем на стр users
                .failureUrl("/signIn")
                .permitAll(); //signIn Доступна всем

    }

    @Override //подключение userDetailService
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //настройка Spring Security на использование нашего userDetailsService и passwordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
