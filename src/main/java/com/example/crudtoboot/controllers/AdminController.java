package com.example.crudtoboot.controllers;

import com.example.crudtoboot.models.User;
import com.example.crudtoboot.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    // Вывод всех пользователей на 1-ой странице + получаем модель для сохранения пользователя
    @GetMapping
    public String index(Model model) {
//        model.addAttribute("admin", userService.findUserByEmail(user.getUsername()));
        model.addAttribute("addUser", new User());
        model.addAttribute("users", userService.index());
        return "admin/show";
    }

    @PostMapping //после создания пользователя сохраняем его в БД и отправляем на страницу пользователей
    public String create(@ModelAttribute("addUser") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    // Следующие 2-а метода для редактирования (первый выводит страницу, второй получает данные и сохраняет).
//    @GetMapping("/{id}")
//    public String edit(@PathVariable("id") Long id,Model model) {
//        model.addAttribute("user", userService.show(id));
//        return "admin/edit";
//    }
    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}