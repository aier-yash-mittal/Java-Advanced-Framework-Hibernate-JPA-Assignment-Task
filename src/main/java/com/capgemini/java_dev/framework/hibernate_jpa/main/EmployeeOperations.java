package com.capgemini.java_dev.framework.hibernate_jpa.main;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import com.capgemini.java_dev.framework.hibernate_jpa.entity.Employee;

public class EmployeeOperations {

    public static void executeEmployee() {

        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Student");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        System.out.println("How many employees do you want to create?");
        int n = sc.nextInt();

        tx.begin();

        for(int i=0;i<n;i++) {

            Employee emp = new Employee();

            System.out.println("Enter ID:");
            emp.setId(sc.nextInt());

            System.out.println("Enter Name:");
            emp.setName(sc.next());

            System.out.println("Enter Salary:");
            emp.setSalary(sc.nextDouble());

            System.out.println("Enter Department:");
            emp.setDepartment(sc.next());

            em.persist(emp);
        }

        tx.commit();

        System.out.println("Employees inserted successfully");


        // READ
        System.out.println("Enter Employee ID to display:");
        int id = sc.nextInt();

        Employee e = em.find(Employee.class,id);

        if(e!=null) {

            System.out.println("ID: "+e.getId());
            System.out.println("Name: "+e.getName());
            System.out.println("Salary: "+e.getSalary());
            System.out.println("Department: "+e.getDepartment());

        }
        else {
            System.out.println("Employee not found");
        }

    }
}