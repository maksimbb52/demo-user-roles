//package com.example.crudtoboot.controllers;
//
//import com.example.crudtoboot.entity.Role;
//import com.example.crudtoboot.entity.User;
//import com.example.crudtoboot.service.RoleService;
//import com.example.crudtoboot.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.Set;
//
//@Controller
//@RequiredArgsConstructor
//public class NewUser {
//
//    private final UserService userService;
//    private final RoleService roleService;
//
//    // Разрабатываю методы для создания нового пользователя.
//    @GetMapping("/new") //при вызове этого URL нам вернется форма для создания нового человека
//    public String newUser(Model model) {
//        Set<Role> roles = roleService.indexRoles();
//        model.addAttribute("user", new User());
//        model.addAttribute("roles", roles);
//        return "new";
//    }
//
//    @PostMapping //после создания пользователя сохраняем его в БД и отправляем на страницу пользователей
//    public String create(@ModelAttribute("user") User user, @ModelAttribute("roles") Set<Role> roles) {
//        user.setRoles(roles);
//        userService.addUser(user);
//        return "redirect:/admin";
//    }
//}
