package com.capgemini.java_dev.framework.hibernate_jpa.many_to_one.main;

import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.many_to_one.entity.Project;
import com.capgemini.java_dev.framework.hibernate_jpa.many_to_one.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {

	public static void execute() {

		Scanner sc = new Scanner(System.in);

		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("Student-ManyToOne-Project");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		// ---------------- CREATE ----------------

//		System.out.print("Enter Project ID: ");
//		int pid = sc.nextInt();
//		sc.nextLine();
//
//		System.out.print("Enter Project Name: ");
//		String pname = sc.nextLine();
//
//		System.out.print("Enter Project Description: ");
//		String desc = sc.nextLine();
//
//		Project project = new Project(pid, pname, desc);
//
//		em.persist(project);
//
//
//		System.out.print("How many students?: ");
//		int n = sc.nextInt();
//
//		for(int i = 0; i < n; i++) {
//
//			System.out.println("\nEnter Student " + (i+1) + " details");
//
//			Student student = new Student();
//
//			System.out.print("Student ID: ");
//			student.setId(sc.nextInt());
//			sc.nextLine();
//
//			System.out.print("Student Name: ");
//			student.setName(sc.nextLine());
//
//			System.out.print("Email: ");
//			student.setEmailId(sc.nextLine());
//
//			System.out.print("Contact: ");
//			student.setContactNumber(sc.nextLong());
//
//			student.setProject(project);
//
//			em.persist(student);
//		}
//
//		System.out.println("Project and Students Added Successfully");



		// ---------------- READ ----------------

//		System.out.print("Enter Student ID: ");
//		int sid = sc.nextInt();
//
//		Student student = em.find(Student.class, sid);
//
//		if(student != null) {
//
//			System.out.println("Student ID: " + student.getId());
//			System.out.println("Name: " + student.getName());
//			System.out.println("Email: " + student.getEmailId());
//
//			Project p = student.getProject();
//
//			if(p != null) {
//				System.out.println("Project: " + p.getName());
//				System.out.println("Description: " + p.getDescription());
//			}
//
//		}
//		else {
//			System.out.println("Student Not Found");
//		}



		// ---------------- UPDATE ----------------

//		System.out.print("Enter Student ID to update project: ");
//		int sid = sc.nextInt();
//
//		Student student = em.find(Student.class, sid);
//
//		if(student != null) {
//
//			System.out.print("Enter New Project ID: ");
//			int pid = sc.nextInt();
//
//			Project project = em.find(Project.class, pid);
//
//			if(project != null) {
//
//				student.setProject(project);
//
//				em.merge(student);
//
//				System.out.println("Student Project Updated");
//
//			}else {
//				System.out.println("Project Not Found");
//			}
//
//		}else {
//			System.out.println("Student Not Found");
//		}



		// ---------------- DELETE ----------------

		System.out.print("Enter Student ID to delete: ");
		int sid = sc.nextInt();

		Student student = em.find(Student.class, sid);

		if(student != null) {

			em.remove(student);

			System.out.println("Student Deleted Successfully");

		}else {
			System.out.println("Student Not Found");
		}



		tx.commit();

		em.close();
		emf.close();
		sc.close();

		System.out.println("Operation Completed");
	}
}