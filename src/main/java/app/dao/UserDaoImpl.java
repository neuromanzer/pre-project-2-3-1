package app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import app.model.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.openSession().get(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from User u where u.login = :login");
            query.setParameter("login", login);
            return (User) query.setMaxResults(1).getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (NoResultException nre) {
            return null;
        }
        return null;
    }

    @Override
    public boolean validateUser(String login) {
        User user = getUserByLogin(login);
        return user != null;
    }

    @Override
    public void addUser(User user) {    //addUser
        sessionFactory.openSession().save(user);
    }

    @Override
    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.delete(user);
    }
}
