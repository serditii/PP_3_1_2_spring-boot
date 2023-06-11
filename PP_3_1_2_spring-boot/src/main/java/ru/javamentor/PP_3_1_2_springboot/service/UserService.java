package ru.javamentor.PP_3_1_2_springboot.service;

import ru.javamentor.PP_3_1_2_springboot.entity.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(int id);

    User showUser(int id);

    void updateUser(User updateUser);

    List<User> getListUsers();
}
