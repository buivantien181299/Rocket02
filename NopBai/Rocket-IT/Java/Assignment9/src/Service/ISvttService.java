//
package Service;

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
public interface ISvttService {
	public boolean LoginAccount(String account, String email);
	
	boolean insertSvtt(SVThucTap svThucTap);

	boolean updateSvtt(SVThucTap svThucTap);

	
}
