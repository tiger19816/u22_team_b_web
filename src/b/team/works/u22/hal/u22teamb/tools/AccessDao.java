package b.team.works.u22.hal.u22teamb.tools;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;

public class AccessDao extends Dao{

	public AccessDao() throws SQLException, ClassNotFoundException {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int InsertAut(String sql)throws SQLException{
        try {
        	this.pst = cn.prepareStatement(sql);
            this.pst.executeUpdate();
//            this.rs = this.pst.getGeneratedKeys();
            pst = cn.prepareStatement("SELECT last_insert_id()");
            this.rs = this.pst.executeQuery();
            int result = 0;
            if(rs.next()) {
            	result = rs.getInt("last_insert_id()");
            }
            return result;
        }catch(SQLException e){
            throw e;
        }
    }

	public int update(String sql)throws SQLException{
		try{
			this.pst = cn.prepareStatement(sql);
			return this.pst.executeUpdate();
		}catch(SQLException e){
			throw e;
		}
	}

	public void close() throws SQLException {
		try {
			if(this.rs != null) {
				this.rs.close();
			}
			if(this.pst != null) {
				this.pst.close();
			}
			if(this.cn != null) {
				this.cn.close();
			}
		} catch(SQLException e) {
			throw e;
		}
	}

    public void shopInsert(String shopsId, String shopName) {
		String sql = "INSERT INTO reservationshops(id, shop_name) VALUES (?, ?);";
		try {
			this.pst = cn.prepareStatement(sql);
			pst.setString(1, shopsId);
			pst.setString(2, shopName);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}


    public int userInsert(String[] maleDatas , String[] femaleDatas) {
    		int result = 0;
		try {
			//夫情報を登録。
			String male_sql = "INSERT INTO male(name,mail,password,birthday,height,weight,profession)";
			male_sql += " VALUES(?,?,?,?,?,?,?)";
			this.pst = cn.prepareStatement(male_sql);
			pst.setString(1, maleDatas[0]);
			pst.setString(2, maleDatas[1]);
			pst.setString(3, maleDatas[2]);
			pst.setString(4, maleDatas[3]);
			pst.setString(5, maleDatas[4]);
			pst.setString(6, maleDatas[5]);
			pst.setString(7, maleDatas[6]);
			int flag = pst.executeUpdate();
			System.out.println(flag);
			//夫ID取得。
			if(flag>0) {
				pst = cn.prepareStatement("SELECT last_insert_id()");
				this.rs = this.pst.executeQuery();
				String maleId = "";
				if(rs.next()) {
					result = rs.getInt("last_insert_id()");
					maleId = String.valueOf(result);
				}

				//妻情報を登録。
				String female_sql = "INSERT INTO female(name,birthday,mail,password,icon_url,card_number,card_expiration_date,card_security_code,card_nominee,address,point_latitude,point_longitude,male_id)";
				female_sql += " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				this.pst = cn.prepareStatement(female_sql);
				pst.setString(1, femaleDatas[0]);
				pst.setString(2, femaleDatas[1]);
				pst.setString(3, femaleDatas[2]);
				pst.setString(4, femaleDatas[3]);
				pst.setString(5, femaleDatas[4]);
				pst.setString(6, femaleDatas[5]);
				pst.setString(7, femaleDatas[6]);
				pst.setString(8, femaleDatas[7]);
				pst.setString(9, femaleDatas[8]);
				pst.setString(10, femaleDatas[9]);
				pst.setString(11, femaleDatas[10]);
				pst.setString(12, femaleDatas[11]);
				pst.setString(13, String.valueOf(result));
				flag = pst.executeUpdate();
				System.out.println(flag);
				//妻ID取得。
				result = 0;
				if(flag>0) {
					pst = cn.prepareStatement("SELECT last_insert_id()");
					this.rs = this.pst.executeQuery();
					if(rs.next()) {
						result = rs.getInt("last_insert_id()");
					}
				}

				String text = RandomStringUtils.randomAlphabetic(15);
				String text2 = RandomStringUtils.random(10, text);
				String sql = "INSERT INTO team_b_db.signupcode(id,female_id,male_id) VALUES (?,?,?);";
				this.pst = cn.prepareStatement(female_sql);
				pst.setString(1, text2);
				pst.setString(2, String.valueOf(result));
				pst.setString(3, maleId);
				flag = pst.executeUpdate();
			}

			return result;

		} catch (SQLException e) {
			// TODO: handle exception
			return 0;
		}
    }

    /**
     * 予約内容のUPDATE用メソッド。
     * @param reservationid
     * @param menuNo
     * @param date
     * @param time
     * @return boolean
     */
	public boolean reservationUpdate(String reservationid , String menuNo , String date , String time , String message) {
		String sql = "UPDATE reservation SET";
		int count = 0;
		ArrayList<String> result = new ArrayList<String>();
		if(!"".equals(menuNo)) {
			sql += " menu_no = ? ";
			result.add(menuNo);
			count++;
		}
		if(!"".equals(date) && !"".equals(time)) {
			if(count == 1) {
				sql += ",";
			}
			sql += " use_date_time = ? ";
			result.add(date+" "+time);
			count++;
		}
		if(!"".equals(message)) {
			if(count > 1) {
				sql += ",";
			}
			sql += " message = ? ";
			result.add(menuNo);
		}
		sql +=  " WHERE id = ? ORDER BY use_date_time";
		System.out.println(sql);
		result.add(reservationid);
		try {
			this.pst = cn.prepareStatement(sql);
			for(int i=0; i<result.size(); i++) {
				pst.setString((i+1), result.get(i));
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	/**
     * 予約内容を確認済みUPDATE用メソッド。
     * @param reservationid
     * @return boolean
     */
	public boolean reservationCheckUpdate(String reservationid) {
		String sql = "UPDATE reservation SET check_flag = 1 WHERE id = ?;";
		try {
			this.pst = cn.prepareStatement(sql);
			pst.setString(1, reservationid);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	/**
	 * 夫の新規登録時のパスワード追加(変更)用メソッド。
	 * @param id
	 * @param password
	 * @return boolean
	 */
	public boolean malePasswordUpdate(String id , String password) {
		String sql = "UPDATE male SET password = ? WHERE id = ? ;";
		try {
			this.pst = cn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public String[] selectLatLng(String id) {
		String sql = "SELECT point_latitude, point_longitude FROM female WHERE id = ?;";
		String[] result = new String[2];
		try {
			this.pst = cn.prepareStatement(sql);
			this.pst.setString(1, id);
			rs = pst.executeQuery();

			if(rs.next()) {
				result[0] = rs.getString("point_latitude");
				result[1] = rs.getString("point_longitude");
			}
		} catch(SQLException e) {
		}
		return result;
	}
}

