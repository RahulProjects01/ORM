package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.example.entities.Student;
import org.example.entities.Laptop;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");
        EntityManager em = emf.createEntityManager();

        // Create a new student and laptop
        Student student = new Student();
        student.setStudentName("John Doe");
        student.setAbout("A computer science student");

        Laptop laptop = new Laptop();
        laptop.setModelNumber("XPS 15");
        laptop.setBrand("Dell");

        // Set the relationship
        student.setLaptop(laptop);
        laptop.setStudent(student);

        // Persist entities
        em.getTransaction().begin();
        em.persist(student);  // Will cascade and persist the associated laptop due to CascadeType.ALL
        em.getTransaction().commit();

        // Close EntityManager
        em.close();
        emf.close();
    }
}