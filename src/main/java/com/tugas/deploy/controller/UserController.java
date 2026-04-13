package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private User userData;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        if (username.equals("admin") && password.equals("20230140122")) {
            model.addAttribute("userData", userData);
            model.addAttribute("nimWebsite", "2023014122");
            model.addAttribute("namaPemilik", "Imron Satrio Purnomo");
            return "home";
        }

        model.addAttribute("error", "Username atau password salah");
        return "login";
    }

    @GetMapping("/form")
    public String formPage(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String saveData(@ModelAttribute User user, Model model) {
        this.userData = user;
        model.addAttribute("userData", userData);
        model.addAttribute("nimWebsite", "20230140122");
        model.addAttribute("namaPemilik", "Imron Satrio Purnomo");
        return "home";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("userData", userData);
        model.addAttribute("nimWebsite", "NIM_KAMU");
        model.addAttribute("namaPemilik", "NAMA KAMU");
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}