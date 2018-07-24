package entities;

/**
 * メニュー情報のエンティティクラス
 *
 * @author ohs60224
 *
 */
public class Menu {
	/**
	 * フィールド
	 */
	private Shops shops;
	private int _no;
	private String _name;
	private String _photoUrl;
	private int _price;

	/**
	 * コンストラクタ
	 */
	public Menu() {
		this.shops = new Shops();
		this._no = 0;
		this._name = "";
		this._photoUrl = "";
		this._price = 0;
	}

//セッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * 店IDのセッター
	 * @param shops 店ID
	 */
	public void setShopsId(int shopsId) {
		this.shops.setId(shopsId);
	}
	/**
	 * 店IDのセッター
	 * @param shops 店ID
	 */
	public void setShopsId(String shopsId) {
		this.shops.setId(shopsId);
	}
	/**
	 * 項番のセッター
	 * @param no 項番
	 */
	public void setNo(int no) {
		this._no = no;
	}
	/**
	 * 項番のセッター
	 * @param no 項番
	 */
	public void setNo(String no) {
		this._no = Integer.valueOf(no);
	}
	/**
	 * メニュー名のセッター
	 * @param name メニュー名
	 */
	public void setName(String name) {
		this._name = name;
	}
	/**
	 * 画像名のセッター
	 * @param photoUrl 画像名
	 */
	public void setPhotoUrl(String photoUrl) {
		this._photoUrl = photoUrl;
	}
	/**
	 * 価格のセッター
	 * @param price 価格
	 */
	public void setPrice(int price) {
		this._price = price;
	}
	/**
	 * 価格のセッター
	 * @param price 価格
	 */
	public void setPrice(String price) {
		this._price = Integer.valueOf(price);
	}

//ゲッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 店IDのゲッター
	 * @return 店ID
	 */
	public int getShopsId() {
		return this.shops.getId();
	}
	/**
	 * 項番のゲッター
	 * @return 項番
	 */
	public int getNo() {
		return this._no;
	}
	/**
	 * メニュー名のゲッター
	 * @return メニュー名
	 */
	public String getName() {
		return this._name;
	}
	/**
	 * 画像名のゲッター
	 * @return 画像名
	 */
	public String getPhotoUrl() {
		return this._photoUrl;
	}
	/**
	 * 価格のゲッター
	 * @return 価格
	 */
	public int getPrice() {
		return this._price;
	}
}
