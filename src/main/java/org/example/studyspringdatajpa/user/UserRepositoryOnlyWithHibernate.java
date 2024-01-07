package org.example.studyspringdatajpa.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryOnlyWithHibernate {

    @PersistenceUnit
    EntityManagerFactory emf;

    void createUser(String name, String email) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User user = new User(name, email);
            em.persist(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    Optional<User> findUser(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            User user = em.find(User.class, id);
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
