package com.peaksoft.controller;

import com.peaksoft.model.Role;
import com.peaksoft.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.peaksoft.service.RoleService;
import com.peaksoft.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "home-page";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("admin")
    public String listUser(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("list", users);
        return "adminPage";
    }

    @GetMapping("user")
    public String infoUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "userPage";
    }

    @GetMapping(value = "user/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "createNew";
    }

    @PostMapping(value = "user/new")
    public String newUser(@ModelAttribute User user,
                          @RequestParam(value = "rolez") String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(roleService.getByName(roles));
        }
        user.setRoles(roleSet);
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "user/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "editUser";
    }

    @PostMapping(value = "user/edit/{id}")
    public String editUser(@ModelAttribute User user, @RequestParam(value = "rolez") String[] role) {

        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(roleService.getByName(roles));
        }
        user.setRoles(roleSet);
        userService.edit(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/admin";
    }
}
