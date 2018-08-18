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
	private String _name;
	private String _mail;
	private String _password;
	private String _birthday;
	private int _height;
	private int _weight;
	private String _profession;
	private String _code;

	/**
	 * コンストラクタ
	 */
	public Male() {
		this._id = 0;
		this._name = "";
		this._mail = "";
		this._password = "";
		this._birthday = "";
		this._height = 0;
		this._weight = 0;
		this._profession = "";
		this._code = "";
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
	 * 夫名のセッター
	 * @param name 夫名
	 */
	public void setName(String name) {
		this._name = name;
	}
	/**
	 * 夫メールアドレスのセッター
	 * @param mail 夫メールアドレス
	 */
	public void setMail(String mail) {
		this._mail = mail;
	}
	/**
	 * 夫パスワードのセッター
	 * @param password 夫パスワード
	 */
	public void setPassword(String password) {
		this._password = password;
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
	public void setWeight(int bodyWeight) {
		this._weight = bodyWeight;
	}
	/**
	 * 夫体重のセッター
	 * @param bodyWeight 夫体重
	 */
	public void setWeight(String bodyWeight) {
		this._weight = Integer.valueOf(bodyWeight);
	}
	/**
	 * 夫職業のセッター
	 * @param profession 夫職業
	 */
	public void setProfession(String profession) {
		this._profession = profession;
	}

	/**
	 * 夫登録用コードのセッター
	 * @param code 登録用コード
	 */
	public void setCode(String code) {
		this._code = code;
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
	 * 夫名のゲッター
	 * @return 夫名
	 */
	public String getName() {
		return this._name;
	}
	/**
	 * 夫メールアドレスのゲッター
	 * @return 夫メールアドレス
	 */
	public String getMail() {
		return this._mail;
	}
	/**
	 * 夫パスワードのゲッター
	 * @return 夫パスワード
	 */
	public String getPassword() {
		return this._password;
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
	public int getWeight() {
		return this._weight;
	}
	/**
	 * 夫職業のゲッター
	 * @return 夫職業
	 */
	public String getProfession() {
		return this._profession;
	}

	/**
	 * 夫登録用コードのゲッター
	 *  @return 登録用コード
	 */
	public String getCode() {
		return this._code;
	}
}
