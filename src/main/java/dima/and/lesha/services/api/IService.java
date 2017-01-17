package dima.and.lesha.services.api;

public interface IService <T> {

    T findOne(Long id);

    T save(T obj);

    void delete(Long id);

    void delete(T obj);
}
