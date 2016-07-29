package com.raremile.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.raremile.database.entities.Course;
import com.raremile.database.entities.exceptions.NonFatalException;
import com.raremile.database.entities.utils.ConnectDB;

public class CourseDaoImpl implements CourseDao {
	private static final Logger LOG = LoggerFactory.getLogger(CourseDaoImpl.class);

	public boolean addCourse(Course course) throws NonFatalException {
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		boolean status = false;
		if (course == null) {
			throw new NonFatalException("Course passed is null");
		}
		try {
			pstmt = con.prepareStatement("insert into courses (C_ID,COURSE_NAME) values(?,?)");
			pstmt.setInt(1, course.getCourseId());
			pstmt.setString(2, course.getCourseName());
			status = pstmt.execute();
		} catch (SQLException e) {
			LOG.error("Exception while inserting course", e);
		} finally {
			ConnectDB.closeDb(pstmt);
		}

		return status;
	}

	public void fetchCourse() throws NonFatalException {
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("Select * from courses");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cId = rs.getInt(1);
				String cName = rs.getString(2);
				LOG.info("Course Id is " + cId + " Course Name: " + cName );
			}
		} catch (SQLException e) {
			LOG.error("Exception while fetching courses", e);
		} finally {
			ConnectDB.closeDb(pstmt);
		}

	}

}
