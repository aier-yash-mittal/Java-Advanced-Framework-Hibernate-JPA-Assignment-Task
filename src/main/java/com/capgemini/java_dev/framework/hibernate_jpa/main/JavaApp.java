package com.capgemini.java_dev.framework.hibernate_jpa.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.capgemini.java_dev.framework.hibernate_jpa.entity.Student;

public class JavaApp {

    public static void execution() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Student");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student s1 = new Student(1,"Raja","raja@gmail.com","9876543210");
        Student s2 = new Student(2,"Rani","rani@gmail.com","9876543211");
        Student s3 = new Student(3,"Rocky","rocky@gmail.com","9876543212");
        Student s4 = new Student(4,"Reena","reena@gmail.com","9876543213");

        em.persist(s1);
        em.persist(s2);
        em.persist(s3);
        em.persist(s4);

        em.getTransaction().commit();

        System.out.println("4 Students Inserted Successfully");

        em.close();
        emf.close();
    }
}