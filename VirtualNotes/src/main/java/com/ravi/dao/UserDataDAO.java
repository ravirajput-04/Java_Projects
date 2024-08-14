package com.ravi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ravi.beans.UserData;

public class UserDataDAO {
	private Connection con;
	public UserDataDAO(Connection con) {
		super();
		this.con = con;
	}


	public boolean AddNotes(String title, String content, String id) {
		boolean f = false;
	
		try {
			String query = "insert into ENOTES_USER_DATA values(ENotes_Sequence.NEXTVAL,?,?,?)";
			int eid = Integer.parseInt(id);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, eid);
			int i = pstmt.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	public List<UserData> getData(int id){
		List<UserData> list = new ArrayList<UserData>();
		UserData data = null;
		try {
			String query = "select * from ENotes_User_Data where eid = ? order by id desc";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
			 data=new UserData();
				data.setId(rs.getInt(1));
				data.setTitle(rs.getString(2));
				data.setContent(rs.getString(3));
				list.add(data);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public UserData getDataById(int dataId) {
		UserData ud = null;
		try {
			String query = "select * from ENotes_User_Data where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, dataId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				ud = new UserData();
				ud.setId(rs.getInt(1));
				ud.setTitle(rs.getString(2));
				ud.setContent(rs.getString(3));
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ud;
	}
	
	public boolean dataUpdate(int dataId, String title, String content) {
		boolean f = false;
		try {
			String query = "update ENotes_User_Data set title=?, content = ? where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, dataId);
			int i = pstmt.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteNotes(int dataId) {
		boolean f = false;
		try {
			String query = "delete from ENotes_User_Data where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, dataId);
			int i = pstmt.executeUpdate();
			if(i==1) {
				f=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}