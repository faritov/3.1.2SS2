package com.example.CRUD.controller;

import com.example.CRUD.model.User;
import com.example.CRUD.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping()
public class AdminController {

    public final UserService service;

    public AdminController(UserService service) {
        this.service = service;
    }

    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("listOfUsers", service.getAllUsers());
        return "/allUsers";
    }

    @GetMapping("/admin/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", service.showUser(id));
        return "/showUser";
    }

    @GetMapping("/admin/new")
    public String getViewForNewUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/admin")
    public String addUser(@ModelAttribute("user") User user) {
        service.createUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String getViewForUpdateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", service.showUser(id));
        return "/edit";
    }

    @PatchMapping("/admin/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        service.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        service.deleteUser(id);
        return "redirect:/admin";
    }
}
