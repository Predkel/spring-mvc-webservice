package dima.and.lesha.web.controllers;

import dima.and.lesha.model.User;
import dima.and.lesha.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id) {
        return userService.findOne(id);
    }
}
