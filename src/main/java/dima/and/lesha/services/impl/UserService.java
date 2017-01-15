package dima.and.lesha.services.impl;

import dima.and.lesha.dao.api.UserDao;
import dima.and.lesha.model.User;
import dima.and.lesha.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class UserService implements IUserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findByName(String username){
        return userDao.findByUsername(username);
    }

    public User findOne(Long id) {
        return userDao.findOne(id);
    }
}
