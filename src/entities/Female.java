package entities;

/**
 * 妻情報のエンティティクラス
 *
 * @author ohs60224
 *
 */
public class Female {
	/**
	 * フィールド
	 */
	private int _id;
	private String _name;
	private String _birthday;
	private String _password;
	private String _icon;
	private String _address;
	private String _mail;
	private String _cardNumber;
	private String _cardExpirationDate;
	private String _cardSecurityCode;
	private String _cardNominee;
	private String _pointLatitude;
	private String _pointLongitude;
	private Male male;

	/**
	 * コンストラクタ
	 */
	public Female() {
		this._id = 0;
		this._birthday = "";
		this._password = "";
		this._icon = "";
		this._address = "";
		this._mail = "";
		this._cardNumber = "";
		this._cardExpirationDate = "";
		this._cardSecurityCode = "";
		this._cardNominee = "";
		this._pointLatitude = "";
		this._pointLongitude = "";
		this.male = new Male();
	}

//セッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 妻IDのセッター
	 * @param id 妻ID
	 */
	public void setId(int id) {
		this._id = id;
	}
	/**
	 * 妻IDのセッター
	 * @param id 妻ID
	 */
	public void setId(String id) {
		this._id = Integer.valueOf(id);
	}
	/**
	 * 妻名のセッター
	 * @param name 妻名
	 */
	public void setName(String name) {
		this._name = name;
	}
	/**
	 * 妻誕生日のセッター
	 * @param birthday 妻誕生日
	 */
	public void setBirthday(String birthday) {
		this._birthday = birthday;
	}
	/**
	 * 妻パスワードのセッター
	 * @param password 妻パスワード
	 */
	public void setPassword(String password) {
		this._password = password;
	}
	/**
	 * 妻アイコン画像名のセッター
	 * @param icon 妻アイコン画像名
	 */
	public void setIcon(String icon) {
		this._icon = icon;
	}
	/**
	 * 妻登録住所のセッター
	 * @param address 妻登録住所
	 */
	public void setAddress(String address) {
		this._address = address;
	}
	/**
	 * 妻メールアドレスのセッター
	 * @param mail 妻メールアドレス
	 */
	public void setMail(String mail) {
		this._mail = mail;
	}
	/**
	 * 妻カードナンバーのセッター
	 * @param cardNumber 妻カードナンバー
	 */
	public void setCardNumber(String cardNumber) {
		this._cardNumber = cardNumber;
	}
	/**
	 * 妻有効期限のセッター
	 * @param cardExpirationDate 妻有効期限
	 */
	public void setCardExpirationDate(String cardExpirationDate) {
		this._cardExpirationDate = cardExpirationDate;
	}
	/**
	 * 妻セキュリティコードのセッター
	 * @param cardSecurityCode 妻セキュリティコード
	 */
	public void setCardSecurityCode(String cardSecurityCode) {
		this._cardSecurityCode = cardSecurityCode;
	}
	/**
	 * 妻名義名のセッター
	 * @param cardNominee 妻名義名のセッター
	 */
	public void setCardNominee(String cardNominee) {
		this._cardNominee = cardNominee;
	}
	/**
	 * 妻登録地（緯度）のセッター
	 * @param pointLatitude 妻登録地（緯度）
	 */
	public void setPointLatitude(String pointLatitude) {
		this._pointLatitude = pointLatitude;
	}
	/**
	 * 妻登録地（緯度）のセッター
	 * @param pointLatitude 妻登録地（緯度）
	 */
	public void setPointLatitude(Double pointLatitude) {
		this._pointLatitude = Double.toString(pointLatitude);
	}

	/**
	 * 妻登録地（経度）のセッター
	 * @param pointLongitude 妻登録地（経度）
	 */
	public void setPointLongitude(String pointLongitude) {
		this._pointLongitude = pointLongitude;
	}
	/**
	 * 妻登録地（経度）のセッター
	 * @param pointLongitude 妻登録地（経度）
	 */
	public void setPointLongitude(Double pointLongitude) {
		this._pointLongitude = Double.toString(pointLongitude);
	}
	/**
	 * 夫IDのセッター
	 * @param maleId 夫ID
	 */
	public void setMaleId(int maleId) {
		this.male.setId(maleId);
	}
	/**
	 * 夫IDのセッター
	 * @param maleId 夫ID
	 */
	public void setMaleId(String maleId) {
		this.male.setId( Integer.valueOf(maleId) );
	}

//ゲッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 妻IDのゲッター
	 * @return 妻IDのゲッター
	 */
	public int getId() {
		return this._id;
	}
	/**
	 * 妻名のゲッター
	 * @return 妻名のゲッター
	 */
	public String getName() {
		return this._name;
	}
	/**
	 * 妻誕生日のゲッター
	 * @return 妻誕生日
	 */
	public String getBirthday() {
		return _birthday;
	}
	/**
	 * 妻パスワードのゲッター
	 * @return 妻パスワード
	 */
	public String getPassword() {
		return _password;
	}
	/**
	 * 妻アイコン画像名のゲッター
	 * @return icon 妻アイコン画像名
	 */
	public String getIcon() {
		return _icon;
	}
	/**
	 * 妻登録住所のゲッター
	 * @return address 妻登録住所
	 */
	public String getAddress() {
		return _address;
	}
	/**
	 * 妻メールアドレスのゲッター
	 * @return mail 妻メールアドレス
	 */
	public String getMail() {
		return _mail;
	}
	/**
	 * 妻カードナンバーのゲッター
	 * @return 妻カードナンバー
	 */
	public String getCardNumber() {
		return this._cardNumber;
	}
	/**
	 * 妻有効期限のゲッター
	 * @return 妻有効期限
	 */
	public String getCardExpirationDate() {
		return this._cardExpirationDate;
	}
	/**
	 * 妻セキュリティコードのゲッター
	 * @return 妻セキュリティコード
	 */
	public String getCardSecurityCode() {
		return this._cardSecurityCode;
	}
	/**
	 * 妻名義名のゲッター
	 * @return 妻名義名
	 */
	public String getCardNominee() {
		return this._cardNominee;
	}
	/**
	 * 妻登録地（緯度）のゲッター
	 * @return 妻登録地（緯度）
	 */
	public String getPointLatitude() {
		return this._pointLatitude;
	}
	/**
	 * 妻登録地（経度）のゲッター
	 * @return 妻登録地（経度）
	 */
	public String getPointLongitude() {
		return this._pointLongitude;
	}
	/**
	 * 夫IDのゲッター
	 * @return 夫ID
	 */
	public int getMaleId() {
		return this.male.getId();
	}
}
