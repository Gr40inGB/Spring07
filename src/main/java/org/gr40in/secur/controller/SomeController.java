package org.gr40in.secur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SomeController {

    @GetMapping("secret")
    public String getAdminPage() {
        return "administration";
    }

    @GetMapping("public")
    public String getPublicPage() {
        return "public_page";
    }
}
