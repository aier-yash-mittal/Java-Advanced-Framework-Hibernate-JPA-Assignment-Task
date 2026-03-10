package com.capgemini.java_dev.framework.hibernate_jpa.one_to_one.main;

import com.capgemini.java_dev.framework.hibernate_jpa.one_to_one.entity.Project;
import com.capgemini.java_dev.framework.hibernate_jpa.one_to_one.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {
	public static void execute() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student-Project");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
//		
//		Project project1 = new Project();
//		project1.setId(1);
//		project1.setName("JAva");
//		project1.setDescription("Java testing obj");
//		entityManager.persist(project1);
//		
//		Student student1 = new Student();
//		student1.setId(1);
//		student1.setName("Raja");
//		student1.setEmailId("raja@gmail.com");
//		student1.setContactNumber(9876543210L);
//		student1.setProject(project1);
//		
//		entityManager.persist(student1);
//		
//		Project project2 = new Project();
//		project2.setId(2);
//		project2.setName("JAva2");
//		project2.setDescription("Java testing obj2");
//		entityManager.persist(project2);
//		
//		Student student2 = new Student();
//		student2.setId(2);
//		student2.setName("Rani");
//		student2.setEmailId("rani@gmail.com");
//		student2.setContactNumber(9876543210L);
//		student2.setProject(project2);
//		
//		entityManager.persist(student2);
//		
//		Project project3 = new Project();
//		project3.setId(3);
//		project3.setName("JAva3");
//		project3.setDescription("Java testing obj3");
//		entityManager.persist(project3);
//		
//		Student student3 = new Student();
//		student3.setId(3);
//		student3.setName("Rocky");
//		student3.setEmailId("rocky@gmail.com");
//		student3.setContactNumber(9876543210L);
//		student3.setProject(project3);
//		
//		entityManager.persist(student3);
		
//		Student student = entityManager.find(Student.class, 1);
//		
//		if(student != null) {
//			System.out.println(student);
//			Project project = student.getProject();
//			if(project != null) {
//				System.out.println(project);
//			}else {
//				System.out.println("Project Data Not Found!");
//			}
//		}
//		else {
//			System.out.println("Student Data Not Found!");
//		}
		
//		Student student = entityManager.find(Student.class, 1);
//		
//		if(student != null) {
//			System.out.println(student);
//			Project project = student.getProject();
//			if(project != null) {
//				System.out.println(project);
//				project.setName("Student Management tool");
//				entityManager.merge(project);
//			}else {
//				System.out.println("Project Data Not Found!");
//			}
//		}
//		else {
//			System.out.println("Student Data Not Found!");
//		}
		
		Student student = entityManager.find(Student.class, 3);
		entityManager.remove(student);
		
				
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("Hello World!");
	}
}
