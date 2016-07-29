package com.raremile.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.raremile.database.entities.University;
import com.raremile.database.entities.exceptions.NonFatalException;
import com.raremile.database.entities.utils.ConnectDB;

public class UniversityDaoImpl implements UniversityDao {
	private static final Logger LOG = LoggerFactory.getLogger(UniversityDaoImpl.class);

	public boolean addUniv(University university) throws NonFatalException {
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		boolean status = false;
		if (university == null) {
			throw new NonFatalException("University passed is null");
		}
		try {
			pstmt = con.prepareStatement("insert into universities (U_ID,U_NAME) values(?,?)");
			pstmt.setInt(1, university.getUnivId());
			pstmt.setString(2, university.getUnivName());
			status = pstmt.execute();
		} catch (SQLException e) {
			LOG.error("Exception while inserting university", e);
		} finally {
			ConnectDB.closeDb(pstmt);
		}

		return status;
	}

	public void fetchUniv() throws NonFatalException {
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("Select * from universities");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				LOG.info("University Id is " + id + " Name: " + name );
			}
		} catch (SQLException e) {
			LOG.error("Exception while fetching university", e);
		} finally {
			ConnectDB.closeDb(pstmt);
		}
		
	}

}
