package ru.inno.webinar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.webinar.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
