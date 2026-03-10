package com.capgemini.java_dev.framework.hibernate_jpa.one_to_many_finite.main;

import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.one_to_many_finite.entity.Project;
import com.capgemini.java_dev.framework.hibernate_jpa.one_to_many_finite.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student-Array-Project");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		// ---------------- CREATE ----------------

//		System.out.print("Enter Student ID: ");
//		int sid = sc.nextInt();
//		sc.nextLine();
//
//		System.out.print("Enter Student Name: ");
//		String sname = sc.nextLine();
//
//		System.out.print("Enter Email: ");
//		String email = sc.nextLine();
//
//		System.out.print("Enter Contact: ");
//		long contact = sc.nextLong();
//
//		System.out.print("How many projects?: ");
//		int n = sc.nextInt();
//
//		Project project[] = new Project[n];
//
//		for (int i = 0; i < n; i++) {
//
//			System.out.println("\nEnter details for Project " + (i + 1));
//
//			Project p = new Project();
//
//			System.out.print("Project ID: ");
//			p.setId(sc.nextInt());
//			sc.nextLine();
//
//			System.out.print("Project Name: ");
//			p.setName(sc.nextLine());
//
//			System.out.print("Project Description: ");
//			p.setDescription(sc.nextLine());
//
//			entityManager.persist(p);
//
//			project[i] = p;
//		}
//
//		Student student = new Student();
//		student.setId(sid);
//		student.setName(sname);
//		student.setEmailId(email);
//		student.setContactNumber(contact);
//		student.setProject(project);
//
//		entityManager.persist(student);
//
//		System.out.println("Student Added Successfully");

		// ---------------- READ ----------------

//		System.out.print("Enter Student ID to fetch: ");
//		int id = sc.nextInt();
//
//		Student student = entityManager.find(Student.class, id);
//
//		if (student != null) {
//
//			System.out.println("Student ID: " + student.getId());
//			System.out.println("Name: " + student.getName());
//			System.out.println("Email: " + student.getEmailId());
//
//			Project projects[] = student.getProject();
//
//			for (Project p : projects) {
//				System.out.println("\nProject ID: " + p.getId());
//				System.out.println("Project Name: " + p.getName());
//				System.out.println("Description: " + p.getDescription());
//			}
//
//		} else {
//			System.out.println("Student Not Found");
//		}

		// ---------------- UPDATE ----------------

//		System.out.print("Enter Project ID to update: ");
//		int pid = sc.nextInt();
//		sc.nextLine();
//
//		Project project = entityManager.find(Project.class, pid);
//
//		if (project != null) {
//
//			System.out.print("Enter new Project Name: ");
//			project.setName(sc.nextLine());
//
//			System.out.print("Enter new Description: ");
//			project.setDescription(sc.nextLine());
//
//			entityManager.merge(project);
//
//			System.out.println("Project Updated Successfully");
//
//		} else {
//			System.out.println("Project Not Found");
//		}

		System.out.print("Enter Student ID: ");
		int sid = sc.nextInt();

		Student student = entityManager.find(Student.class, sid);

		if (student != null) {

		    Project[] projects = student.getProject();

		    System.out.println("\nProjects of this Student:");

		    for (Project p : projects) {
		        System.out.println("Project ID: " + p.getId() + " | Name: " + p.getName());
		    }

		    System.out.print("\nEnter Project ID to delete: ");
		    int pid = sc.nextInt();

		    Project project = entityManager.find(Project.class, pid);

		    if (project != null) {

		        entityManager.remove(project);

		        System.out.println("Project Deleted Successfully");

		    } else {
		        System.out.println("Project Not Found");
		    }

		} else {
		    System.out.println("Student Not Found");
		}
				
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("Hello World!");
	}
}
