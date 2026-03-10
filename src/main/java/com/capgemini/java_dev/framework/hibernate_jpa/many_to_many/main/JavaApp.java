package com.capgemini.java_dev.framework.hibernate_jpa.many_to_many.main;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.java_dev.framework.hibernate_jpa.many_to_many.entity.Project;
import com.capgemini.java_dev.framework.hibernate_jpa.many_to_many.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {

    public static void execute() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Student-Project");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Project p1 = new Project(1, "Java", "Backend Project");
        Project p2 = new Project(2, "Spring", "Spring Boot Project");

        List<Project> projectList = new ArrayList<>();
        projectList.add(p1);
        projectList.add(p2);

        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Raja");
        s1.setEmailId("raja@gmail.com");
        s1.setContactNumber(9876543210L);
        s1.setProjects(projectList);

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Aman");
        s2.setEmailId("aman@gmail.com");
        s2.setContactNumber(9876543211L);
        s2.setProjects(projectList);

        em.persist(s1);
        em.persist(s2);

        tx.commit();

        em.close();
        emf.close();

        System.out.println("Many-to-Many Data Inserted Successfully");
    }
}