package com.example.crudtoboot.controller;

import com.example.crudtoboot.dto.UserDto;
import com.example.crudtoboot.entity.UserEntity;
import com.example.crudtoboot.service.RoleService;
import com.example.crudtoboot.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    // Вывод всех пользователей на 1-ой странице + получаем модель для сохранения пользователя
    @GetMapping
    public String index(Model model, Principal principal, Authentication authentication) {
        model.addAttribute("principal", principal.getName());
        model.addAttribute("authentication", authentication.getAuthorities());
        model.addAttribute("addUser", new UserDto());
        model.addAttribute("listRoles", roleService.indexRoles());
        model.addAttribute("users", userService.index());
        return "admin/show";
    }

    @PostMapping //после создания пользователя сохраняем его в БД и отправляем на страницу пользователей
    public String create(@ModelAttribute("addUser") UserDto userDto) {
        userService.addUser(userDto);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") UserDto userDto) {
        userService.update(userDto);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}