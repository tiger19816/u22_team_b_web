package entities;

/**
 * 夫情報のエンティティクラス
 *
 * @author ohs60224
 *
 */
public class Male {
	/**
	 * フィールド
	 */
	private int _id;
	private String _birthday;
	private int _height;
	private int _bodyWeight;
	private String _profession;

	/**
	 * コンストラクタ
	 */
	public Male() {
		this._id = 0;
		this._birthday = "";
		this._height = 0;
		this._bodyWeight = 0;
		this._profession = "";
	}

//セッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 夫IDのセッター
	 * @param id 夫ID
	 */
	public void setId(int id) {
		this._id = id;
	}
	/**
	 * 夫IDのセッター
	 * @param id 夫ID
	 */
	public void setId(String id) {
		this._id = Integer.valueOf(id);
	}
	/**
	 * 夫誕生日のセッター
	 * @param birthday 夫誕生日
	 */
	public void setBirthday(String birthday) {
		this._birthday = birthday;
	}
	/**
	 * 夫身長のセッター
	 * @param height 夫身長
	 */
	public void setHeight(int height) {
		this._height = height;
	}
	/**
	 * 夫身長のセッター
	 * @param height 夫身長
	 */
	public void setHeight(String height) {
		this._height = Integer.valueOf(height);
	}
	/**
	 * 夫体重のセッター
	 * @param bodyWeight 夫体重
	 */
	public void setBodyWeight(int bodyWeight) {
		this._bodyWeight = bodyWeight;
	}
	/**
	 * 夫体重のセッター
	 * @param bodyWeight 夫体重
	 */
	public void setBodyWeight(String bodyWeight) {
		this._bodyWeight = Integer.valueOf(bodyWeight);
	}
	/**
	 * 夫職業のセッター
	 * @param profession 夫職業
	 */
	public void setProfession(String profession) {
		this._profession = profession;
	}

//ゲッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 夫IDのゲッター
	 * @return 夫ID
	 */
	public int getId() {
		return this._id;
	}
	/**
	 * 夫誕生日のゲッター
	 * @return 夫誕生日
	 */
	public String getBirthday() {
		return this._birthday;
	}
	/**
	 * 夫身長のゲッター
	 * @return 夫身長
	 */
	public int getHeight() {
		return this._height;
	}
	/**
	 * 夫体重のゲッター
	 * @return 夫体重
	 */
	public int getBodyWeight() {
		return this._bodyWeight;
	}
	/**
	 * 夫職業のゲッター
	 * @return 夫職業
	 */
	public String getProfession() {
		return this._profession;
	}
}
