package onetomany_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import onetomany_student.dto.School;
import onetomany_student.dto.Student;

public class SchoolDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		 return entityManagerFactory.createEntityManager();
		  
	}
	public void saveSchool(School school)
	{
		 EntityManager entityManager=getEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			List<Student> student= school.getStudent();
			for(Student student1: student) {
				entityManager.persist(student1);
			}
			entityManager.persist(school);
			entityTransaction.commit();
	   }
	
	public void updateSchool(int id,School school)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School recievescholl=entityManager.find(School.class, id);
		if(recievescholl != null) {
			     recievescholl.setSid(id);
			     recievescholl.setStudent(school.getStudent());
			   entityTransaction.begin();
			   entityManager.merge(recievescholl);
			    entityTransaction.commit();
			   
		}
	}
		
		public void deleteSchool(int sid,School school1)
		{
			 EntityManager entityManager=getEntityManager();
			 EntityTransaction entityTransaction=entityManager.getTransaction();
			 School recievescholl=entityManager.find(School.class, sid);
			  entityTransaction.begin();
			   entityManager.remove(recievescholl);
			  entityTransaction.commit();
			 
		}
		public School getSchollById(int sid) {
			EntityManager entityManager=getEntityManager();

		    School recievescholl=entityManager.find(School.class, sid);
		    return recievescholl;
		}
		
		public List<Student> getAllStudent(){
			EntityManager entityManager=getEntityManager();
            Query query= entityManager.createQuery("select s from School s");
              
			  List<Student> list=query.getResultList();
			   return list;
		}
		
		
	
	}


