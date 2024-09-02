package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private long id = 1;
    private final Map<Long, User> users = new HashMap();
    private List<String> email = new ArrayList<>();

    @Override
        public User post(User user) {
            System.out.println("Добавление пользователя");
            if (user.getId() == null) {
                user.setId(id);
                users.put(id, user);
                email.add(user.getEmail());
                id++;
            } else {
                users.put(id, user);
                email.add(user.getEmail());
            }
            return user;
        }

    @Override
    public User update(Long userId, User user) {
        System.out.println("Обновление пользователя");
        User user1 = get(userId);
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        return post(user1);
    }

    @Override
    public User get(Long userId) {
        System.out.println("Получение пользователя");
        return users.get(userId);
    }

    @Override
    public User delete(Long userId) {
        return users.remove(userId);
    }

    @Override
    public List<String> getEmail() {
        return email;
    }
}
