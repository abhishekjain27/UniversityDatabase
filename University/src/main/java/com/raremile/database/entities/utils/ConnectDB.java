package com.raremile.database.entities.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.raremile.database.dao.UniversityDaoImpl;

public class ConnectDB {
	private static final Logger LOG = LoggerFactory.getLogger(ConnectDB.class);
	static Connection con = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			LOG.error("Exception while loading class in jvm", e);
		}
	}

	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/university" + "?user=root&password=abhi1234");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void closeDb(PreparedStatement pstmt){
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}