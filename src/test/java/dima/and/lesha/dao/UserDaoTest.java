package dima.and.lesha.dao;

import dima.and.lesha.dao.api.UserDao;
import dima.and.lesha.dao.config.PersistenceConfig;
import dima.and.lesha.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void name() throws Exception {

        List<User> result = userDao.findByUsername("Dima");
        assertSame(2, result.size());
    }
}