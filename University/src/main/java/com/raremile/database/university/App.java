package com.raremile.database.university;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.raremile.database.dao.CourseDao;
import com.raremile.database.dao.CourseDaoImpl;
import com.raremile.database.dao.StudentDao;
import com.raremile.database.dao.StudentDaoImpl;
import com.raremile.database.dao.UniversityDao;
import com.raremile.database.dao.UniversityDaoImpl;
import com.raremile.database.entities.Course;
import com.raremile.database.entities.Student;
import com.raremile.database.entities.University;
import com.raremile.database.entities.exceptions.NonFatalException;

public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		University university = new University();
		Student student = new Student();
		Course course = new Course();
		try {
			UniversityDao dsi = new UniversityDaoImpl();
			university.setUnivId(4);
			university.setUnivName("MSRIT");
			dsi.addUniv(university);
			dsi.fetchUniv();
			
			StudentDao abhi = new StudentDaoImpl();
			student.setStudId(104);
			student.setStudname("Vicky");
			student.setUnivId(3);
			abhi.addStudent(student);
			abhi.fetchStudent();
			
			CourseDao aero = new CourseDaoImpl();
			course.setCourseId(7);
			course.setCourseName("CHEM");
			aero.addCourse(course);
			aero.fetchCourse();
		} catch (NonFatalException e) {
			LOG.error("Exception caught", e);
		}

	}

}
