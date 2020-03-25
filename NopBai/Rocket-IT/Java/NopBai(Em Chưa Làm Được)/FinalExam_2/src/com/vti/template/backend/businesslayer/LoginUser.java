//
package com.vti.template.backend.businesslayer;

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
public class LoginUser implements ILoginUser{
	
	
	

	/* 
	* @see com.vti.template.backend.businesslayer.ILoginUser#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String eamil, String passWord) {
		// TODO Auto-generated method stub
		return false;
	}

	/* 
	* @see com.vti.template.backend.businesslayer.ILoginUser#getAllTrainee()
	*/
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	* @see com.vti.template.backend.businesslayer.ILoginUser#insertTrainee(com.vti.template.entity.User)
	*/
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
