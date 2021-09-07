package com.hibernate.demo.entity;



import org.hibernate.cfg.Configuration;

import com.jdbc.Instructor;
import com.jdbc.InstructorDetail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //we use hibernate here to create sessions objects 
		// these session objects would create only once when app will run 
		
		
		//ceate session Factory 
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Instructor.class)
				                  .addAnnotatedClass(InstructorDetail.class)
				                  .buildSessionFactory();
		
		//create sessoin
		
		Session session =  factory.getCurrentSession();
		
				try {
					
					
					//Start a trasaction
					
				
					session.beginTransaction(); 
				//get instructor by primary key /id 
					
					int theid= 1;
					Instructor  tempInstructor = session.get(Instructor.class, theid);
					System.out.println("Found instructor " + tempInstructor  ); 
					
					
					//delete the instrutors
					if(tempInstructor!=null)
					{
						System.out.println(":deleting " +  tempInstructor);
						
						
						//Note:will also delete the associated details object
						
						//because of cascadetype.All
						session.delete(tempInstructor);
					}
						
					session.getTransaction().commit();
					
					System.out.println("done ");
					
					
				}
				
				finally {
					//
					factory.close();
				}
	}
	
	 

}
