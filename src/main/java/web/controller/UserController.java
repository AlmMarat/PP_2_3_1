package web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/users";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String newUser (@ModelAttribute ("user") User user) {
        return "users/new";
    }

    @DeleteMapping(value = "/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String updateUserForm(Model model, @PathVariable ("id") long id) {
        model.addAttribute("user", userService.getUserId(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUserFrom(@ModelAttribute ("user") User user, @PathVariable("id") long id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/show/{id}")
    public String showUser(Model model, @PathVariable ("id") long id) {
        model.addAttribute("user", userService.getUserId(id));
        return "users/show";
    }
}