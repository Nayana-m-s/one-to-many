package onetomany_student.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentMain {

	public static void main(String[] args) {
	 EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("vinod");

	}

}
