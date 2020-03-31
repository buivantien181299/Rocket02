//
package Service;

import entity.SVThucTap;
import repository.SvttRespository;

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
public class SvttService implements ISvttService{
	
	private SvttRespository dao;
	
	/**
	 * Constructor for class SvttService.
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 31, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 31, 2020
	 */
	public SvttService() {
		dao = new SvttRespository();
	}
	
	/* 
	* @see Service.ISvttService#LoginAccount(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean LoginAccount(String account, String email) {
		return dao.LoginAccount(account, email);
	}

	/* 
	* @see Service.ISvttService#insertSvtt(entity.SVThucTap)
	*/
	@Override
	public boolean insertSvtt(SVThucTap svThucTap) {
		boolean bl = dao.getSvttByUserName(svThucTap.getEmail());
		if(!bl) {
			return dao.insertSvtt(svThucTap);
		}else {
			System.out.println("UserName existed!");
			return false;
		}
	}

	/* 
	* @see Service.ISvttService#updateSvtt(entity.SVThucTap)
	*/
	@Override
	public boolean updateSvtt(SVThucTap svThucTap) {
		boolean bl = dao.getSvttByUserName(svThucTap.getEmail());
		if (bl) {
			return dao.updateSvtt(svThucTap);
		}else {
			System.out.println("UserName is not existed!");
			return false;
		}
	}

	/* 
	* @see Service.ISvttService#deleteSvtt(java.lang.String)
	*/
	

	
}
