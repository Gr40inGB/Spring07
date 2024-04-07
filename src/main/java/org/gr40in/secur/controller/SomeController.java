package org.gr40in.secur.controller;

import lombok.RequiredArgsConstructor;
import org.gr40in.secur.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SomeController {

    private final UserService userService;

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
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
