package com.ashish.SpringBootAdvanceMapping;

import com.ashish.SpringBootAdvanceMapping.Entity.Instructor;
import com.ashish.SpringBootAdvanceMapping.Entity.instructor_details;
import com.ashish.SpringBootAdvanceMapping.Repository.appDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAdvanceMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdvanceMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(appDao dao){
		return runner-> {
			System.out.println("Inside Command line runner");
			//createUser(dao);
			findbyId(dao);
			//delete(dao);
		};
	}

	private void createUser(appDao dao){
		Instructor instructor1= new Instructor("Ashish","Shenoy","ashishshenoy81@gmail.com");

		instructor_details instructorDetails= new instructor_details("https://www.youtube.com/watch?v=LVol5HIOAUY","https://www.linkedin.com/in/ashish-shenoy-0874b9248/");

		instructor1.setInstructor_details(instructorDetails);
		System.out.println("Temp Instructor:"+instructor1);
		dao.save(instructor1);
	}

	private Instructor findbyId(appDao dao){
		long id=1;

		Instructor instructor= dao.find(id);
		System.out.println("Instructor By ID:"+instructor);
		return instructor;
	}

	private void delete(appDao dao){
		long id=1;

		dao.deleteByID(id);

		System.out.println(id+" removed from the data base");

	}

}
