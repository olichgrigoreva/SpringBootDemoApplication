package ru.inno.webinar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @GetMapping("/users") //get запрос
    public String getUsersPage(){
        //имя страницы, которую мы хотим показать пользователю при запросе на /users
        return "users_page";
    }
}
