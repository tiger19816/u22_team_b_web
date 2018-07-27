package b.team.works.u22.hal.u22teamb.tools;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Female;
import entities.Male;

/**
 * SQL文クラス
 *
 * @author ohs60224
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

	//妻の情報を抽出
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

	//妻の情報を抽出（主キー検索）
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


	//夫の情報を抽出
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

	//夫の情報を抽出（主キー検索）
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
		this.SelectWhere(" reservation r INNER JOIN reservationshops rs ON r.id = rs.id ", where);
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		try {
			while(rs.next()) {
				ArrayList<String> datas = new ArrayList<String>();
				datas.add(rs.getString("shop_name"));
				datas.add(rs.getString("use_date_time"));
				result.add(datas);
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
		this.SelectWhere(" reservation r INNER JOIN reservationshops rs ON r.id = rs.id ", where);
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		try {
			while(rs.next()) {
				ArrayList<String> datas = new ArrayList<String>();
				datas.add(rs.getString("shop_name"));
				datas.add("1000");
				datas.add(rs.getString("use_date_time"));
				result.add(datas);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}
