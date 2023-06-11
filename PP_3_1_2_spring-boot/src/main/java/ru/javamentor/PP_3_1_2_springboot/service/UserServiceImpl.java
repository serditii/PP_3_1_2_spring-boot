package ru.javamentor.PP_3_1_2_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.PP_3_1_2_springboot.dao.UserDao;
import ru.javamentor.PP_3_1_2_springboot.dao.UserDaoImpl;
import ru.javamentor.PP_3_1_2_springboot.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User showUser(int id) {
        return userDao.showUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User updateUser) {
        userDao.updateUser(updateUser);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }
}
