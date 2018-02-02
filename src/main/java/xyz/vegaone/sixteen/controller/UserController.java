package xyz.vegaone.sixteen.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import xyz.vegaone.sixteen.dto.User;
import xyz.vegaone.sixteen.service.UserService;

@RestController
@RequestMapping(value = "/sixteen/user")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public User getUser(@PathVariable(value = "id") Long id) {
        User user = userService.getUser(id);

        return user;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        User createUser = userService.createUser(user);

        return createUser;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User updatedUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);

        return updatedUser;
    }

}
