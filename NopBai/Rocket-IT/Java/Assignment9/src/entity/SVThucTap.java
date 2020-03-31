//
package entity;

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
public class SVThucTap {
	private String account, firstName, lastName, email;

	
	public String getAccount() {
		return account;
	}

	
	public SVThucTap setAccount(String account) {
		this.account = account;
		return this;
	
		
	}

	public String getFirstName() {
		return firstName;
	}

	
	public SVThucTap setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
		
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public SVThucTap setLastName(String lastName) {
		this.lastName = lastName;
		return this;
		
	}
	

	public String getEmail() {
		return email;
	}
	

	public SVThucTap setEmail(String email) {
		this.email = email;
		return this;
		
	}
}
