//
package com.vti.template.entity;

/**
 * This class is đăng ký quản lý.
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 25, 2020
 */
public class Manager extends User{
	
	private byte ExpInYear;
	

	public byte getExpInYear() {
		return ExpInYear;
	}


	public void setExpInYear(byte expInYear) {
		ExpInYear = expInYear;
		
	}
}
