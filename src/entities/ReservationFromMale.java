/**
 * 
 */
package entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * QRコード読取後の予約詳細画面に表示する限定エンティティクラス。
 * 
 * @author Yuki Yoshida
 */
public class ReservationFromMale {
	private String _reservationId;
	private String _maleId;
	private String _maleName;
	private String _femaleId;
	private String _femaleName;
	private String _menuNo;	// １つ？
	private Timestamp _useDateTime;
	
	public ReservationFromMale() {
		this._reservationId = "";
		this._maleId = "";
		this._maleName = "";
		this._femaleId = "";
		this._femaleName = "";
		this._menuNo = "";
		this._useDateTime = null;
	}
	
	/**
	 * @return 予約ID。
	 */
	public String getReservationId() {
		return this._reservationId;
	}
	/**
	 * @param reservationId 予約ID。
	 */
	public void setReservationId(String reservationId) {
		this._reservationId = reservationId;
	}
	/**
	 * @return 夫ID。
	 */
	public String getMaleId() {
		return this._maleId;
	}
	/**
	 * @param maleId 夫ID。
	 */
	public void setMaleId(String maleId) {
		this._maleId = maleId;
	}
	/**
	 * @return 夫名。
	 */
	public String getMaleName() {
		return this._maleName;
	}
	/**
	 * @param maleName 夫名。
	 */
	public void setMaleName(String maleName) {
		this._maleName = maleName;
	}
	/**
	 * @return 妻ID。
	 */
	public String getFemaleId() {
		return this._femaleId;
	}
	/**
	 * @param femaleId 妻ID。
	 */
	public void setFemaleId(String femaleId) {
		this._femaleId = femaleId;
	}
	/**
	 * @return 妻名。
	 */
	public String getFemaleName() {
		return this._femaleName;
	}
	/**
	 * @param femaleName 妻名。
	 */
	public void setFemaleName(String femaleName) {
		this._femaleName = femaleName;
	}
	/**
	 * @return メニューNo。
	 */
	public String getMenuNo() {
		return this._menuNo;
	}
	/**
	 * @param menuNo メニューNo。
	 */
	public void setMenuNo(String menuNo) {
		this._menuNo = menuNo;
	}
	/**
	 * @return 予約時間。
	 */
	public Timestamp getUseDateTime() {
		return this._useDateTime;
	}
	/**
	 * @param useDateTime 予約時間。
	 */
	public void setUseDateTime(Timestamp useDateTime) {
		this._useDateTime = useDateTime;
	}
}
