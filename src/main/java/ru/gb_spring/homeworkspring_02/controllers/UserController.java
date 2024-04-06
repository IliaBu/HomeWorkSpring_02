package ru.gb_spring.homeworkspring_02.controllers;

import ru.gb_spring.homeworkspring_02.model.User;
import ru.gb_spring.homeworkspring_02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** Перенаправление c корня сайта на главную страницу "/" на "/html"
     * @return страницу
     */
    @GetMapping("/")
    public String homepage() {
        return "redirect:/home.html";
    }

    /** Страница вывода списка пользователей
     * @param model
     * @return список пользователей
     */
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    /** Страница с вводом данных нового пользователя
     * @param user
     * @return страницу
     */
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    /** Сохранение нового пользователя
     * @param user
     * @return страницу со списком пользователей
     */
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /** Удаление пользователя по id
     * @param id
     * @return страницу со списком пользователей
     */
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    /** Редактирование пользователя по id
     * @param model
     * @param id
     * @return страницу изменения пользователя
     */
    @GetMapping("/user-update/{id}")
    public String editUserForm(Model model, @PathVariable int id) {
        User user = userService.getUserByID(id);
        if (user == null) return "redirect:/users";
        System.out.println(user);
        model.addAttribute("user", user);
        return "user-update";
    }

    /** Изменение пользователя по id
     * @param user
     * @return страницу со списком пользователей
     */
    @PostMapping("/user-update/{id}")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
