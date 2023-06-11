package ru.javamentor.PP_3_1_2_springboot.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javamentor.PP_3_1_2_springboot.entity.User;
import ru.javamentor.PP_3_1_2_springboot.service.UserService;
import ru.javamentor.PP_3_1_2_springboot.util.UserValidator;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userServise, UserValidator userValidator) {
        this.userService = userServise;
        this.userValidator = userValidator;
    }

    @GetMapping
    public String showAll(ModelMap model) {
        List<User> list = userService.getListUsers();
        model.addAttribute("users", list);
        return "users";
    }

    @PostMapping
    public String create(@ModelAttribute() @Valid User user,
                         BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute() User user) {
        return "new";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable() int id, ModelMap model) {
        model.addAttribute("user", userService.showUser(id));
        return "show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable() int id, ModelMap model) {
        model.addAttribute("user", userService.showUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute() @Valid User user,
                         BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable() int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
