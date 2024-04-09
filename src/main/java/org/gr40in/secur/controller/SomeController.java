package org.gr40in.secur.controller;

import lombok.RequiredArgsConstructor;
import org.gr40in.secur.dao.User;
import org.gr40in.secur.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class SomeController {

    private final UserService userService;

    @GetMapping
    public String homePage() {
        return "home";
    }

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "main_page";
    }

    @GetMapping("users/{name}")
    public String getUserById(@PathVariable String name, Model model) {
        User userByName = userService.getUserByName(name);
        ArrayList<User> user = new ArrayList<>();
        user.add(userByName);
        model.addAttribute("users", user);
        return "main_page";
    }

    @GetMapping("secret")
    public String getAdminPage() {
        return "administration";
    }

    @GetMapping("public")
    public String getPublicPage() {
        return "public_page";
    }
}
