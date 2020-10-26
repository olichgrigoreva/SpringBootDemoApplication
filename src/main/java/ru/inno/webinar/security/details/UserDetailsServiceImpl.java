package ru.inno.webinar.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.inno.webinar.models.User;
import ru.inno.webinar.repositories.UsersRepository;

@Component(value = "CustomUserDetails") //чтобы autowired прошло нормально (component), value т.к. 2 класса UserDetailsService (Spring и наш)
//достать пользователя из базы
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository; //чтобы найти пользователя по email

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(email);
        if (user != null) {
            return new UserDetailsImpl(user);
        } else throw new UsernameNotFoundException("User not found");
    }
}
