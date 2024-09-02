package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
interface UserRepository {

    User post(User user);

    User update(Long userId, User user);

    User get(Long userId);

    User delete(Long userId);

    List<String> getEmail();
}
