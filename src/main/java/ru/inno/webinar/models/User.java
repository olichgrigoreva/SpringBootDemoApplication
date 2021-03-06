package ru.inno.webinar.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //генерация id самой БД
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
    @Transient //чтобы обычный пароль не попал в БД
    private String password; //для хеширования пароля с формы
}
