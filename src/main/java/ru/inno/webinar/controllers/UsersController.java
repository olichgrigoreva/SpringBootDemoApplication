package ru.inno.webinar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inno.webinar.models.User;
import ru.inno.webinar.repositories.UsersRepository;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository; //интерфейс

    @GetMapping("/users") //get запрос
    public String getUsersPage(Model model){
        List<User> users = usersRepository.findAll(); //используют вместо CRUDrepository, т.к. этот на уровень выше и явл-ся потомком - больше методов
        model.addAttribute("users", users);
        //имя страницы, которую мы хотим показать пользователю при запросе на /users
        return "users_page";
    }
}
