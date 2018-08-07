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
	private String _name;
	private String _phonetic;
	private String _openTime;
	private String _tel;
	private String _address;
	private int _averageBudget;
	private String _pointLatitude;
	private String _pointLongitude;
	private String _lunchService;
	private String _nonSmokingSeat;
	private String _cardUsage;
	private String _image1;
	private String _image2;

	private int _no;
	private String _freeName;

	/**
	 * コンストラクタ
	 */
	public Shops() {
		this._id = 0;
		this._password = "";
		this._name = "";
		this._phonetic = "";
		this._openTime = "";
		this._tel = "";
		this._address = "";
		this._averageBudget = 0;
		this._pointLatitude = "";
		this._pointLongitude = "";
		this._lunchService = "";
		this._nonSmokingSeat = "";
		this._cardUsage = "";
		this._image1 = "";
		this._image2 = "";

		this._no = 0;
		this._freeName = "";
	}

//セッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

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

	public void setName(String name) {
		this._name = name;
	}

	public void setPhonetic(String phonetic) {
		this._phonetic = phonetic;
	}

	public void setOpenTime(String openTime) {
		this._openTime = openTime;
	}

	public void setTel(String tel) {
		this._tel = tel;
	}

	public void setAddress(String address) {
		this._address = address;
	}

	public void setAverageBudget(int averageBudget) {
		this._averageBudget = averageBudget;
	}

	public void setAverageBudget(String averageBudget) {
		this._averageBudget = Integer.valueOf(averageBudget);
	}

	public void setPointLatitude(String pointLatitude) {
		this._pointLatitude = pointLatitude;
	}

	public void setPointLatitude(Double pointLatitude) {
		this._pointLatitude = Double.toString(pointLatitude);
	}

	public void setPointLongitude(String pointLongitude) {
		this._pointLongitude = pointLongitude;
	}

	public void setPointLongitude(Double pointLongitude) {
		this._pointLongitude = Double.toString(pointLongitude);
	}

	public void setLunchService(String lunchService) {
		this._lunchService = lunchService;
	}

	public void setNonSmokingSeat(String nonSmokingSeat) {
		this._nonSmokingSeat = nonSmokingSeat;
	}

	public void setCardUsage(String cardUsage) {
		this._cardUsage = cardUsage;
	}

	public void setImage1(String image1) {
		this._image1 = image1;
	}

	public void setImage2(String image2) {
		this._image2 = image2;
	}

	public void setNo(int no) {
		this._no = no;
	}

	public void setNo(String no) {
		this._no = Integer.valueOf(no);
	}

	public void setFreeName(String freeName) {
		this._freeName = freeName;
	}

//ゲッター++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

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

	public String getName() {
		return this._name;
	}

	public String getPhonetic() {
		return this._phonetic;
	}

	public String getOpenTime() {
		return this._openTime;
	}

	public String getTel() {
		return this._tel;
	}

	public String getAddress() {
		return this._address;
	}

	public int getAverageBudget() {
		return this._averageBudget;
	}

	public String getPointLatitude() {
		return this._pointLatitude;
	}

	public String getPointLongitude() {
		return this._pointLongitude;
	}

	public String getLunchService() {
		return this._lunchService;
	}

	public String getNonSmokingSeat() {
		return this._nonSmokingSeat;
	}

	public String getCardUsage() {
		return this._cardUsage;
	}

	public String getImage1() {
		return this._image1;
	}

	public String getImage2() {
		return this._image2;
	}

	public int getNo() {
		return this._no;
	}

	public String getFreeName() {
		return this._freeName;
	}
}
