package dima.and.lesha.services.api;

import dima.and.lesha.model.User;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User> findByUsername(String username);
}
