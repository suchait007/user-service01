package com.user.service.userservice.controller;


import com.user.service.userservice.dto.UserDTO;
import com.user.service.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/users")
    public List<UserDTO> getUsers(@RequestParam("ids") List<String> ids) {

        log.info("Insider getUser API");
        return userService.getUsers(ids);
    }

}
