package dima.and.lesha.dao;

import dima.and.lesha.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {
    List<User> findByUsername(String username);
}
