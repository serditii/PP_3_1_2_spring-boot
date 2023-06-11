package ru.javamentor.PP_3_1_2_springboot.dao;

import ru.javamentor.PP_3_1_2_springboot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    void deleteUser(int id);

    User showUser(int id);

    Optional<User> showUser(String email);

    void updateUser(User updateUser);

    @SuppressWarnings("unchecked")
    List<User> getListUsers();
}
