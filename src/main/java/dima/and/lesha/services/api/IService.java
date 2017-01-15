package dima.and.lesha.services.api;

import java.util.List;

public interface IService <T> {

    List<T> findByName(String name);

    T findOne(Long id);
}
