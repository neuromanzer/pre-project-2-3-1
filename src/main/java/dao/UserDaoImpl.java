package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = sessionFactory.openSession().createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(User.class, id);
    }

    @Override
    public void add(User user) {
        sessionFactory.openSession().save(user);
    }

    @Override
    public void edit(User user) {
        sessionFactory.openSession().update(user);
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.delete(user);
    }
}
