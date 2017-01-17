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
public class UserService extends dima.and.lesha.services.impl.Service<User,UserDao> implements IUserService {

    @Autowired
    public UserService(UserDao userDao) {
        super(userDao);
    }

    @Override
    public List<User> findByUsername(String username) {
        return dao.findByUsername(username);
    }

}
