package entities;

/**
 * 店情報のエンティティクラス
 *
 * @author ohs60224
 *
 */
public class Shops {
	/**
	 * フィールド
	 */
	private int _id;
	private String _password;

	/**
	 * コンストラクタ
	 */
	public Shops() {
		this._id = 0;
		this._password = "";
	}

	/**
	 * 店IDのセッター
	 * @param id 店ID
	 */
	public void setId(int id) {
		this._id = id;
	}
	/**
	 * 店IDのセッター
	 * @param id 店ID
	 */
	public void setId(String id) {
		this._id = Integer.valueOf(id);
	}
	/**
	 * 店パスワードのセッター
	 * @param password 店パスワード
	 */
	public void setPassword(String password) {
		this._password = password;
	}

	/**
	 * 店IDのゲッター
	 * @return 店ID
	 */
	public int getId() {
		return this._id;
	}
	/**
	 * 店パスワードのゲッター
	 * @return 店パスワード
	 */
	public String getPassword() {
		return this._password;
	}
}
