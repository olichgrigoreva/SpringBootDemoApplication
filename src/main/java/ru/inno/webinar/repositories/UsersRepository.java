package ru.inno.webinar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.webinar.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); //чтобы достать пользователя по email - возможность Spring JPA
    //по названию метода генерит SQL
}
