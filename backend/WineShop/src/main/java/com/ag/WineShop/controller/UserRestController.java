package com.ag.WineShop.controller;


import com.ag.WineShop.dto.LoginDTO;
import com.ag.WineShop.dto.RegisteredUserDTO;
import com.ag.WineShop.dto.ResetPasswordDTO;
import com.ag.WineShop.dto.UserDTO;
import com.ag.WineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")

public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<UserDTO> list() {
        return userService.getUsers();
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody RegisteredUserDTO userDto) {
        return userService.register(userDto);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

    @PostMapping("/changePassword")
    public UserDTO changePassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        return userService.changePassword(resetPasswordDTO);
    }

}
