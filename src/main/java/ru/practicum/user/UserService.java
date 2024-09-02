package ru.practicum.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User post(User user);

    User update(Long userId, User user);

    User get(Long userId);

    User delete(Long userId);
}
