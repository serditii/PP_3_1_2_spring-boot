package ru.javamentor.PP_3_1_2_springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.javamentor.PP_3_1_2_springboot.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("delete from User where Id=:id").setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Optional<User> showUser(String email) {
        Query<User> query = (Query<User>) entityManager
                .createQuery("from User where email = :name ")
                .setParameter("name", email);
        List<User> list = query.getResultList();
        if (list == null) {
            return null;
        }
        return list.stream().findAny();
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        return entityManager.createQuery("from User").getResultList();
    }
}

