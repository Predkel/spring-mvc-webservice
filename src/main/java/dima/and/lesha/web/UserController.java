package dima.and.lesha.web;

import dima.and.lesha.dao.UserDao;
import dima.and.lesha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id) {
        return userDao.findOne(id);
    }
}
