package com.example.repository;

import com.example.entity.Person;
import jakarta.persistence.*;

import java.util.List;

public class PersonRepository {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("personPU");

    public void addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(person);
            transaction.commit();
            System.out.println("Объект добавлен: " + person);
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();

        try {
            return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        } finally {
            em.close();
        }
    }

    public static void close() {
        emf.close();
    }
}
