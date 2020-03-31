//
package repository;
import jdbc.ConnectData;
import java.sql.*;

import entity.SVThucTap;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 31, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 31, 2020
 */
public class SvttRespository implements ISvttRepository{
	
	
	/* 
	* @see repository.ISvttRepository#LoginAccount(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean LoginAccount(String account, String email) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = ConnectData.connect();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Trainee where email = ? and account =?");
			pstmt.setString(1, email);
			pstmt.setString(2, account);
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
			ConnectData.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/* 
	* @see repository.ISvttRepository#insertSvtt(entity.SVThucTap)
	*/
	@Override
	public boolean insertSvtt(SVThucTap svThucTap) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = ConnectData.connect();
		try {
			pstmt = con.prepareStatement(
					"insert into ThucTapSinh (Account,Email,FirstName,LastName) values (?,?,?,?)");
			pstmt.setString(1, svThucTap.getAccount());
			pstmt.setString(2, svThucTap.getEmail());
			pstmt.setString(3, svThucTap.getFirstName());
			pstmt.setString(4, svThucTap.getLastName());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectData.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/* 
	* @see repository.ISvttRepository#updateSvtt(entity.SVThucTap)
	*/
	@Override
	public boolean updateSvtt(SVThucTap svThucTap) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = ConnectData.connect();
		try {
			pstmt = con.prepareStatement(
					"update ThucTapSinh set FirstName=?,LastName=?,Email=? where Account=?");
			pstmt.setString(1, svThucTap.getFirstName());
			pstmt.setString(2, svThucTap.getLastName());
			pstmt.setString(3, svThucTap.getEmail());			
			pstmt.setString(4, svThucTap.getAccount());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectData.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/* 
	* @see repository.ISvttRepository#getSvttByUserName(java.lang.String)
	*/
	@Override
	public boolean getSvttByUserName(String email) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = ConnectData.connect();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Trainee where email=?");
			pstmt.setString(1, email);		
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
			ConnectData.closeAll(con, pstmt, rs);
		}
		return false;
	}

	
}
