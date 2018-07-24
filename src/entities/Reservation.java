package entities;

/**
 * 予約情報のエンティティクラス
 *
 * @author ohs60224
 *
 */
public class Reservation {
	/**
	 * フィールド
	 */
	private int _id;
	private Shops shops;
	private int _menuNo; //※これって外部キーにならないのか？
	private Female female;
	private String _useDateTime;

	/**
	 * コンストラクタ
	 */
	public Reservation() {
		this._id = 0;
		this.shops = new Shops();
		this._menuNo = 0;
		this.female = new Female();
		this._useDateTime = "";
	}

//セッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 予約IDのセッター
	 * @param id 予約ID
	 */
	public void setId(int id) {
		this._id = id;
	}
	/**
	 * 予約IDのセッター
	 * @param id 予約ID
	 */
	public void setId(String id) {
		this._id = Integer.valueOf(id);
	}
	/**
	 * 店IDのセッター
	 * @param shops 店ID
	 */
	public void setShops(int shopsId) {
		this.shops.setId(shopsId);
	}
	/**
	 * 店IDのセッター
	 * @param shops 店ID
	 */
	public void setShops(String shopsId) {
		this.shops.setId(shopsId);
	}
	/**
	 * 項番のセッター
	 * @param menuNo 項番
	 */
	public void setMenuNo(int menuNo) {
		this._menuNo = menuNo;
	}
	/**
	 * 項番のセッター
	 * @param menuNo 項番
	 */
	public void setMenuNo(String menuNo) {
		this._menuNo = Integer.valueOf(menuNo);
	}
	/**
	 * 妻IDのセッター
	 * @param female
	 */
	public void setFemale(int femaleId) {
		this.female.setId(femaleId);
	}
	/**
	 * 妻IDのセッター
	 * @param female
	 */
	public void setFemale(String femaleId) {
		this.female.setId(femaleId);
	}
	/**
	 * 予約時間のセッター
	 * @param useDateTime 予約時間
	 */
	public void setUseDateTime(String useDateTime) {
		this._useDateTime = useDateTime;
	}

//ゲッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 予約IDのゲッター
	 * @return 予約ID
	 */
	public int getId() {
		return this._id;
	}
	/**
	 * 店IDのゲッター
	 * @return 店ID
	 */
	public int getShops() {
		return this.shops.getId();
	}
	/**
	 * 項番のゲッター
	 * @return 項番
	 */
	public int getMenuNo() {
		return this._menuNo;
	}
	/**
	 * 妻IDのゲッター
	 * @return 妻ID
	 */
	public int getFemale() {
		return this.female.getId();
	}
	/**
	 * 予約時間のゲッター
	 * @return 予約時間
	 */
	public String getUseDateTime() {
		return this._useDateTime;
	}
}
