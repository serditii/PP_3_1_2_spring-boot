package ru.javamentor.PP_3_1_2_springboot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.javamentor.PP_3_1_2_springboot.dao.UserDao;
import ru.javamentor.PP_3_1_2_springboot.entity.User;

import java.util.Optional;

@Component
public class UserValidator implements Validator {

    private final UserDao userDao;

    @Autowired
    public UserValidator(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        Optional<User> user1 = userDao.showUser(user.getEmail());
        if (user1.isPresent() && (user1.get().getId() != user.getId())) {
            errors.rejectValue("email", "", "This email is already taken");
        }
    }
}
