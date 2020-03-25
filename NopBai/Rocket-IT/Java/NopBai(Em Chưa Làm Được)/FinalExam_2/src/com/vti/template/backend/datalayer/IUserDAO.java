//
package com.vti.template.backend.datalayer;

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
public interface IUserDAO {
	boolean login(String userName, String passWord);

	List<User> getAllUser();

	boolean insertUser(User user);
}
