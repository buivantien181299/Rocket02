//
package com.vti.template.entity;

/**
 * This class is .đăng ký nhân viên
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 25, 2020
 */
public class Employee extends User{
	
	private String projectName, proSkill;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
		
	}
	

}
