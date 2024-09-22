package com.ashish.SpringBootAdvanceMapping;

import com.ashish.SpringBootAdvanceMapping.Entity.Instructor;
import com.ashish.SpringBootAdvanceMapping.Entity.courses;
import com.ashish.SpringBootAdvanceMapping.Entity.instructor_details;
import com.ashish.SpringBootAdvanceMapping.Entity.student;
import com.ashish.SpringBootAdvanceMapping.Repository.appDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAdvanceMappingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(SpringBootAdvanceMappingApplication.class, args);
		//System.out.println(configurableApplicationContext.getBean("appDaoImpl"));
	}

	@Bean
	public CommandLineRunner commandLineRunner(appDao dao){
		return runner-> {
			System.out.println("Inside Command line runner");
			//createUser(dao);
			//findbyId(dao);
			//delete(dao);
			//findById(dao);
			//deleteinsd(dao);
			//getCourse(dao);
			//addCourse(dao);
			//getCourseWithStudent(dao);
			//getStudentWithCourse(dao);
			//updateCourse(dao);
			updateStudent(dao);
		};
	}

	private void createUser(appDao dao){
		Instructor instructor1= new Instructor("Chiddu","Gowda","Chidambru@gmail.com");
		instructor_details instructorDetails= new instructor_details("https://www.youtube.com/watch?v=LVol5HIOAUY","https://www.linkedin.com/in/ashish-shenoy-0874b9248/");
		instructor1.setInstructor_details(instructorDetails);

		//Create course
		courses cr1= new courses("Python");
		courses cr2= new courses("Python Core");

		//save the course using add method which will add the course into ArrayList<>
		instructor1.add(cr1);
		instructor1.add(cr2);

		//Saving instructor
		System.out.println("Saving instructor");
		System.out.println("Instructor:"+instructor1);
		dao.save(instructor1);
		System.out.println("Instructor saved..!");
		System.out.println("Course details:"+instructor1.getCourses());
	}

	private Instructor findbyId(appDao dao){
		long id=3;
		Instructor instructor= dao.find(id);
		System.out.println("Instructor By ID:"+instructor);
		System.out.println("Instructors course:"+instructor.getCourses());
		return instructor;
	}

	private void delete(appDao dao){
		long id=1;
		dao.deleteByID(id);
		System.out.println(id+" removed from the data base");

	}

	public void findById(appDao dao){
		long id=2;

		instructor_details instructorDetails= dao.findbyId(id);

		System.out.println(instructorDetails);
		System.out.println("Instructor:"+ instructorDetails.getInstructor());
	}

	private void deleteinsd(appDao dao){
		long id=2;

		System.out.println("Deleting instructor_detail:"+id);
		dao.deleteInsdByid(id);
		System.out.println("Deleted successfully..!");
	}

	//Course details
	private void getCourse(appDao dao){
		long id=8;

		courses courses = dao.getCourse(id);

		System.out.println("Course with Id:"+id+" ->"+courses);
		System.out.println("Instructor of the course:"+courses.getInstructor());
		System.out.println("Students:"+courses.getStudents());
	}

	//add course
	private void addCourse(appDao dao){
		System.out.println("Saving course");
		courses course= new courses("BCA");

		System.out.println("saving students");
		student s1 = new student("Ashish","ashishshenoy81@gmail.com",872295739);
		student s2 = new student("Ashwini","ashwini@gmail.com",872295739);

		course.addStudent(s1);
		course.addStudent(s2);

		dao.createCourse(course);
		System.out.println("Done.!");
	}

	private void getCourseWithStudent(appDao dao){
		long id = 8;

		System.out.println("Fetching courses");

		courses course = dao.getCourseWithStudent(id);

		System.out.println("Course detail:"+course);
		System.out.println("Student details:"+course.getStudents());
		System.out.println("Done");
	}

	public void getStudentWithCourse(appDao dao){
		long id = 1;
		System.out.println("Fetching student details..!");
		student s1 = dao.getStudentWithCourse(id);
		System.out.println("students:"+s1);
		System.out.println("Courses:"+s1.getCourses());
		System.out.println("done");
	}

	private void updateCourse(appDao dao){
		long id =8;
		System.out.println("Fetching course");
		courses course = dao.getCourseWithStudent(id);
		System.out.println("Course:"+course);
		student s1=new student("Anil","anil@gmail.com",885552244);
		student s2= new student("VV9","vv9@gmail.com",221144556);
		System.out.println("Adding students");
		course.addStudent(s1);
		course.addStudent(s2);

		dao.updateCourse(course);
		System.out.println("Done");
		System.out.println("Students:"+course.getStudents());
	}

	public void updateStudent(appDao dao){
		long sid=1;

		System.out.println("Finding student");
		student s1= dao.getStudentWithCourse(sid);
		System.out.println("Student with id:"+sid+"-> "+s1);

		System.out.println("Adding course to the student:"+sid);

		courses c1= new courses("Bvoc");
		courses c2=new courses("Art of begin alone");
		s1.addCourse(c1);
		s1.addCourse(c2);
		dao.updateStudent(s1);

		System.out.println("done");
	}

}
