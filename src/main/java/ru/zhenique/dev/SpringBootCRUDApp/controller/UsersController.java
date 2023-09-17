package ru.zhenique.dev.SpringBootCRUDApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zhenique.dev.SpringBootCRUDApp.model.User;
import ru.zhenique.dev.SpringBootCRUDApp.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/all";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/showUser";
    }


    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user); // Добавляем этого юзера в БД
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") long id ){
        model.addAttribute("user",userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute ("user") User updateUser, @PathVariable ("id") long id) {
        userService.updateUser(id, updateUser);
        return "redirect:/users";
    }


    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}