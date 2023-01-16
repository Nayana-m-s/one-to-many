package onetomany_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetomany_student.dto.School;
import onetomany_student.dto.Student;

public class StudentDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		 return entityManagerFactory.createEntityManager();
		  
	}
	public void saveStudent(Student student)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	
	public void updateStudent(int id,Student student)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student recievescholl=entityManager.find(Student.class, id);
		if(recievescholl != null) {
			     recievescholl.setId(id);
			     
			   entityTransaction.begin();
			   entityManager.merge(recievescholl);
			    entityTransaction.commit();
			   
		}
	}
	
	public void deleteStudent(int id, Student student) {
		EntityManager entityManager=getEntityManager();
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 Student recievescholl=entityManager.find(Student.class, id);
		    entityTransaction.begin();
		    entityManager.remove(recievescholl);
		    entityTransaction.commit();
		
	}
	
	public Student getSchollById(int id) {
		EntityManager entityManager=getEntityManager();

	    Student recievescholl=entityManager.find(Student.class, id);
	    return recievescholl;
	}
	
	public List<Student> getAllStudent(){
		EntityManager entityManager=getEntityManager();
        Query query= entityManager.createQuery("select s from Student s");
          
		  List<Student> list=query.getResultList();
		   return list;
	}
      
}
