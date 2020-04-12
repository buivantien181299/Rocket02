//
package com.vti.FinalExam.form;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Apr 12, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Apr 12, 2020
 */
public class RegisterEmployeeInput {
	
	private String projectName, proSkill;
	private int id;
	
	public String getProjectName() {
		return projectName;
	}
	public RegisterEmployeeInput setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
		
	}
	public String getProSkill() {
		return proSkill;
	}
	public RegisterEmployeeInput setProSkill(String proSkill) {
		this.proSkill = proSkill;
		return this;
		
	}
	public int getId() {
		return id;
	}
	public RegisterEmployeeInput setId(int id) {
		this.id = id;
		return this;
		
	}
}
