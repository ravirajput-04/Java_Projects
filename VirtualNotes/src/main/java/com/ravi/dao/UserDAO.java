package com.ravi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ravi.beans.UserDetails;

public class UserDAO {
	private Connection con;

	public UserDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean addUser(UserDetails user) {
		boolean f = false;
		try {
			String query = "insert into ENOTES_USER_DETAILS values(ENOTES_SEQUENCE.NEXTVAL,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public UserDetails loginUser(UserDetails user) {
		UserDetails us = null;
		try {
			String query = "select * from ENOTES_USER_DETAILS where EMAIL = ? and PASSWORD = ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				us = new UserDetails();
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}
}