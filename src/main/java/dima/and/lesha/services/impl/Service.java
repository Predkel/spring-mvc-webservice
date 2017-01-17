package dima.and.lesha.services.impl;

import dima.and.lesha.services.api.IService;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public class Service<T, S extends CrudRepository<T, Long>> implements IService<T> {
    protected S dao;

    protected Service (S s){
        this.dao = s;
    }

    @Override
    public T findOne(Long id) {
        return dao.findOne(id);
    }

    @Override
    public T save(T obj) {
        return dao.save(obj);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public void delete(T obj){
        dao.delete(obj);
    }
}
