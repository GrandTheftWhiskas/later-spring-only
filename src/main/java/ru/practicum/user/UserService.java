package ru.practicum.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User post(User user);

    User update(Long userId, User user);

    User get(Long userId);

    User delete(Long userId);
}
