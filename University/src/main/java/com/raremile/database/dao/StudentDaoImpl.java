package com.raremile.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.raremile.database.entities.Student;
import com.raremile.database.entities.exceptions.NonFatalException;
import com.raremile.database.entities.utils.ConnectDB;

public class StudentDaoImpl implements StudentDao {
	private static final Logger LOG = LoggerFactory.getLogger(UniversityDaoImpl.class);

	public boolean addStudent(Student student) throws NonFatalException {
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		boolean status = false;
		if (student == null) {
			throw new NonFatalException("Student passed is null");
		}
		try {
			pstmt = con.prepareStatement("insert into student (S_ID,S_NAME,U_ID) values(?,?,?)");
			pstmt.setInt(1, student.getStudId());
			pstmt.setString(2, student.getStudName());
			pstmt.setInt(3, student.getUnivId());
			status = pstmt.execute();
		} catch (SQLException e) {
			LOG.error("Exception while inserting student", e);
		} finally {
			ConnectDB.closeDb(pstmt);
		}
		return status;
	}

	public void fetchStudent() throws NonFatalException {
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("Select * from student");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int univId = rs.getInt(3);
				LOG.info("Student Id is " + id + " Name: " + name + " University : "+univId);
			}
		} catch (SQLException e) {
			LOG.error("Exception while fetching student", e);
		} finally {
			ConnectDB.closeDb(pstmt);
		}
	}

}
