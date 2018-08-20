package b.team.works.u22.hal.u22teamb.tools;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Female;
import entities.Male;
import entities.Shops;

/**
 * SQL文クラス
 *
 * @author ohs60224
 * こういうの+エンティティクラスはDB作成者が作成するものだと思う
 *
 */
public class DataAccess extends Dao{
	/**
	 * フィールド。
	 */
	private String _sql;

	/**
	 * コンストラクタ。
	 *
	 * @throws Exception 全ての例外。
	 */
	public DataAccess() throws Exception, SQLException {
		super();
	}

	public void DataAccessClose() throws Exception, SQLException {
		super.close();
	}

//基本構文+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * SELECT文
	 *
	 * @param table 抽出先のテーブル名
	 * @throws Exception
	 * @throws SQLException
	 */
	public void Select(String table) throws Exception, SQLException {
		try {
			this._sql = "SELECT * FROM " + table + ";";
			this.pst = this.cn.prepareStatement(this._sql);
			this.rs = this.pst.executeQuery(this._sql);
			System.out.println(_sql);
		}
		catch(Exception e){
			e.printStackTrace();
            throw e;
		}
	}

	/**
	 * WHERE付きのSELECT文
	 *
	 * @param table 抽出先のテーブル名
	 * @param where 条件
	 * @throws Exception
	 * @throws SQLException
	 */
	public void SelectWhere(String table, String where) throws Exception, SQLException {
		try {
			this._sql = "SELECT * FROM " + table + " WHERE " + where + ";";
			System.out.println(_sql);
			this.pst = this.cn.prepareStatement(this._sql);
			this.rs = this.pst.executeQuery(this._sql);
		}
		catch(Exception e){
			e.printStackTrace();
            throw e;
		}
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//抽出系+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 妻の情報を抽出
	 *
	 * @return 妻情報
	 * @throws Exception
	 * @throws SQLException
	 */
	public ArrayList<Female> FemaleSelect() throws Exception, SQLException {
		this.Select("female");
		ArrayList<Female> result = new ArrayList<Female>();
		try {
			Female f = null;
			while(rs.next()) {
				f = new Female();
				f.setId( rs.getInt("id") );
				f.setName( rs.getString("name") );
				f.setBirthday( rs.getString("birthday") );
				f.setPassword( rs.getString("password") );
				f.setIcon( rs.getString("icon_url") );
				f.setAddress( rs.getString("address") );
				f.setMail( rs.getString("mail") );
				f.setCardNumber( rs.getString("card_number") );
				f.setCardExpirationDate( rs.getString("card_expiration_date") );
				f.setCardSecurityCode( rs.getString("card_security_code") );
				f.setCardNominee( rs.getString("card_nominee") );
				f.setPointLatitude( rs.getString("point_latitude") );
				f.setPointLongitude( rs.getString("point_longitude") );
				f.setMaleId( rs.getInt("male_id") );

				result.add(f);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}

	/**
	 * 妻の情報を抽出（主キー検索）
	 *
	 * @param id 主キー値
	 * @return 妻情報
	 * @throws Exception
	 * @throws SQLException
	 */
	public ArrayList<Female> FemaleSelect(String id) throws Exception, SQLException {
		String where = "id = " + id;
		this.SelectWhere("female", where);
		ArrayList<Female> result = new ArrayList<Female>();
		try {
			Female f = null;
			while(rs.next()) {
				f = new Female();
				f.setId( rs.getInt("id") );
				f.setName( rs.getString("name") );
				f.setBirthday( rs.getString("birthday") );
				f.setPassword( rs.getString("password") );
				f.setIcon( rs.getString("icon_url") );
				f.setAddress( rs.getString("address") );
				f.setMail( rs.getString("mail") );
				f.setCardNumber( rs.getString("card_number") );
				f.setCardExpirationDate( rs.getString("card_expiration_date") );
				f.setCardSecurityCode( rs.getString("card_security_code") );
				f.setCardNominee( rs.getString("card_nominee") );
				f.setPointLatitude( rs.getString("point_latitude") );
				f.setPointLongitude( rs.getString("point_longitude") );
				f.setMaleId( rs.getInt("male_id") );

				result.add(f);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}


	/**
	 * 夫の情報を抽出
	 *
	 * @return 夫情報
	 * @throws Exception
	 * @throws SQLException
	 */
	public ArrayList<Male> MaleSelect() throws Exception, SQLException {
		this.Select("male");
		ArrayList<Male> result = new ArrayList<Male>();
		try {
			Male m = null;
			while(rs.next()) {
				m = new Male();
				m.setId( rs.getInt("id") );
				m.setName( rs.getString("name") );
				m.setMail( rs.getString("mail") );
				m.setPassword( rs.getString("password") );
				m.setBirthday( rs.getString("birthday") );
				m.setHeight( rs.getInt("height") );
				m.setWeight( rs.getInt("weight") );
				m.setProfession( rs.getString("profession") );
				result.add(m);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}

	/**
	 * 夫の情報を抽出（主キー検索）
	 *
	 * @param id 主キー値
	 * @return 夫情報
	 * @throws Exception
	 * @throws SQLException
	 */
	public ArrayList<Male> MaleSelect(int id) throws Exception, SQLException {
		String where = "id = " + id;
		this.SelectWhere("male", where);
		ArrayList<Male> result = new ArrayList<Male>();
		try {
			Male m = null;
			while(rs.next()) {
				m = new Male();
				m.setId( rs.getInt("id") );
				m.setName( rs.getString("name") );
				m.setMail( rs.getString("mail") );
				m.setPassword( rs.getString("password") );
				m.setBirthday( rs.getString("birthday") );
				m.setHeight( rs.getInt("height") );
				m.setWeight( rs.getInt("weight") );
				m.setProfession( rs.getString("profession") );
				result.add(m);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}

	//予約リストの行毎に表示する情報を抽出（妻主キー検索）
	public ArrayList<ArrayList<String>> ReservationListSelect(int id) throws Exception, SQLException {
		String where = "r.female_id = " + id + " AND delete_flag = 0 " ;
		this.SelectWhere(" reservation r INNER JOIN reservationshops rs ON r.shops_id = rs.id ", where);
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		try {
			while(rs.next()) {
				ArrayList<String> datas = new ArrayList<String>();
				datas.add(rs.getString("shop_name"));
				datas.add(rs.getString("use_date_time"));
				datas.add(rs.getString("shops_id"));
				datas.add(rs.getString("r.id"));
				result.add(datas);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	//予約リストの１データ毎に表示する情報を抽出（予約主キー検索）
	public ArrayList<String> ReservationDataSelect(int id) throws Exception, SQLException {
		String where = "r.id = " + id + " AND delete_flag = 0 " ;
		this.SelectWhere(" reservation r INNER JOIN reservationshops rs ON r.shops_id = rs.id ", where);
		ArrayList<String> result = new ArrayList<String>();
		try {
			while(rs.next()) {
				result.add(rs.getString("r.id"));
				result.add(rs.getString("shops_id"));
				result.add(rs.getString("menu_no"));
				result.add(rs.getString("use_date_time"));
				result.add(rs.getString("shop_name"));
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	//履歴リストの行毎に表示する情報を抽出（妻主キー検索）
	public ArrayList<ArrayList<String>> HistoryListSelect(int id) throws Exception, SQLException {
		String where = "r.female_id = " + id + " AND visit_flag = 0 AND delete_flag = 0  " ;
		this.SelectWhere(" reservation r INNER JOIN reservationshops rs ON r.shops_id = rs.id ", where);
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		try {
			while(rs.next()) {
				ArrayList<String> datas = new ArrayList<String>();
				datas.add(rs.getString("shop_name"));
				datas.add("1000");
				datas.add(rs.getString("use_date_time"));
				datas.add(rs.getString("shops_id"));
				result.add(datas);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	//夫婦のログインチェック情報を抽出（view検索）
	public ArrayList<String> UserLoginSelect(String mail , String password) throws Exception, SQLException {
		String where = "mail = '" + mail + "' AND password = '" + password + "'" ;
		this.SelectWhere(" userlist ", where);
		ArrayList<String> result = new ArrayList<String>();
		try {
			while(rs.next()) {
				result.add(rs.getString("id"));
				result.add(rs.getString("sex"));
				result.add(rs.getString("mail"));
				result.add(rs.getString("password"));
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	//店のログインチェック情報を抽出（view検索）
	public ArrayList<String> StoreLoginSelect(String id , String password) throws Exception, SQLException {
		String where = "id = '" + id + "' AND password = '" + password + "'" ;
		this.SelectWhere(" shops ", where);
		ArrayList<String> result = new ArrayList<String>();
		try {
			if(rs.next()) {
				result.add(rs.getString("id"));
				result.add(rs.getString("name"));
			}else {
				result = null;
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	//夫の登録用コードを抽出(夫主キー検索)
	public String MaleRegistrationCodeSelect(String code) throws Exception, SQLException {
		String where = " sc.id = "+ code ;
		this.SelectWhere(" male m INNER JOIN signupcode sc ON m.id = sc.male_id INNER JOIN female f ON f.id = sc.female_id ", where);
		String result = "";
		try {
			if(rs.next()) {
				result = rs.getString("m.id");
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//更新系+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * 店新規登録
	 *
	 * @param s 店エンティティクラス
	 * @return 登録が完了したことを示すtrue
	 * @throws Exception
	 */
	public Boolean addStore(Shops s) throws Exception {
		try {
			//shopsに対して
			this._sql = "INSERT INTO shops "
					+ "(id, "
					+ "password, "
					+ "name, "
					+ "phonetic, "
					+ "open_time, "
					+ "tel, "
					+ "address, "
					+ "average_budget, "
					+ "point_latitude, "
					+ "point_longitude, "
					+ "lunch_service, "
					+ "non_smoking_seat, "
					+ "card_usage, "
					+ "image1, "
					+ "image2) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			this.pst = this.cn.prepareStatement(this._sql);

			this.pst.setInt(1, s.getId());
			this.pst.setString(2, s.getPassword());
			this.pst.setString(3, s.getName());
			this.pst.setString(4, s.getPhonetic());
			this.pst.setString(5, s.getOpenTime());
			this.pst.setString(6, s.getTel());
			this.pst.setString(7, s.getAddress());
			this.pst.setInt(8, s.getAverageBudget());
			this.pst.setString(9, s.getPointLatitude());
			this.pst.setString(10, s.getPointLongitude());
			this.pst.setString(11, s.getLunchService());
			this.pst.setString(12, s.getNonSmokingSeat());
			this.pst.setString(13, s.getCardUsage());
			this.pst.setString(14, s.getImage1());
			this.pst.setString(15, s.getImage2());

			this.pst.executeUpdate();


			//freewordに対して
			this._sql = "INSERT INTO freeword "
					+ "(shops_id, "
					+ "no, "
					+ "name) "
					+ "VALUES "
					+ "(?, ?, ?)";
			this.pst = this.cn.prepareStatement(this._sql);

			this.pst.setInt(1, s.getId());
			this.pst.setInt(2, s.getNo());
			this.pst.setString(3, s.getFreeName());

			this.pst.executeUpdate();

			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}
