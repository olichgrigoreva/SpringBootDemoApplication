package ru.inno.webinar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.inno.webinar.models.User;
import ru.inno.webinar.repositories.UsersRepository;

import javax.jws.soap.SOAPBinding;

@Controller
public class SignUpController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp_page";
    }

    @PostMapping("/signUp")
    public String signUpUser(User user){
        user.setHashPassword(passwordEncoder.encode(user.getPassword())); //отправили обычный пароль, а он захеширован
        usersRepository.save(user);
        //браузер сам перейдет на страницу signUp_page,
        // пошлет getMapping Запрос на этот URL
        return "redirect:/signUp";
    }
}
