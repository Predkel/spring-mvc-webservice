package dima.and.lesha.dao.api;

import dima.and.lesha.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {
    List<User> findByUsername(String username);
}
