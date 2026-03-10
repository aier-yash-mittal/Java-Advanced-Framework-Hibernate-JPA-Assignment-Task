package com.capgemini.java_dev.framework.hibernate_jpa.one_to_many_infinite.main;

import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.one_to_many_infinite.entity.Project;
import com.capgemini.java_dev.framework.hibernate_jpa.one_to_many_infinite.entity.Student;

import java.util.List;
import java.util.ArrayList;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {

	public static void execute() {

		Scanner sc = new Scanner(System.in);

		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("Student-List-Project");

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
//		List<Project> projects = new ArrayList<>();
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
//			projects.add(p);
//		}
//
//		Student student = new Student();
//		student.setId(sid);
//		student.setName(sname);
//		student.setEmailId(email);
//		student.setContactNumber(contact);
//		student.setProjects(projects);
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
//			List<Project> projects = student.getProjects();
//
//			for (Project p : projects) {
//
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


		// ---------------- DELETE PROJECT ----------------

		System.out.print("Enter Student ID: ");
		int sid = sc.nextInt();

		Student student = entityManager.find(Student.class, sid);

		if (student != null) {

			List<Project> projects = student.getProjects();

			

			

			System.out.print("\nEnter Project ID to delete: ");
			int pid = sc.nextInt();

			Project projectToDelete = null;

			for (Project p : projects) {
				if (p.getId() == pid) {
					projectToDelete = p;
					break;
				}
			}

			if (projectToDelete != null) {

				projects.remove(projectToDelete);

				entityManager.remove(projectToDelete);

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
		sc.close();

		System.out.println("Operation Completed");
	}
}