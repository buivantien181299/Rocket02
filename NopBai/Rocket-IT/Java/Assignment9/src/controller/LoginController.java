//
package controller;

import Service.SvttService;
import entity.SVThucTap;

/**
 * This class . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 31, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 31, 2020
 */
public class LoginController {
	private SvttService service;
	
	public LoginController() {
		service = new SvttService();
	}
	
	public boolean insertTrainee(SVThucTap svThucTap) {
		return service.insertSvtt(svThucTap);
	}
	
	public boolean updateTrainee(SVThucTap svThucTap) {
		return service.updateSvtt(svThucTap);
	}
	

	public boolean login(String email, String account) {
		return service.LoginAccount(account, email);
	}
	
}
