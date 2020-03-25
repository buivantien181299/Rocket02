//
package com.vti.template.backend.datalayer;

import java.sql.*;

import java.util.List;

import com.vti.template.entity.User;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 25, 2020
 */
public class UserDAO implements IUserDAO{

	/* 
	* @see com.vti.template.backend.datalayer.IUserDAO#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String email, String passWord) {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Trainee where userName=? and passWord=?");
			pstmt.setString(1, email);
			pstmt.setString(2, passWord);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dem++;
			}
			if (dem == 1) {
				return true;
			}else {
				return false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/* 
	* @see com.vti.template.backend.datalayer.IUserDAO#getAllUser()
	*/
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	* @see com.vti.template.backend.datalayer.IUserDAO#insertUser(com.vti.template.entity.User)
	*/
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
