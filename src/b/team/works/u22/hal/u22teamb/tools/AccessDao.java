package b.team.works.u22.hal.u22teamb.tools;
import java.sql.SQLException;
import java.util.ArrayList;

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

    /**
     * 予約内容のUPDATE用メソッド。
     * @param reservationid
     * @param menuNo
     * @param date
     * @param time
     * @return boolean
     */
	public boolean reservationUpdate(String reservationid , String menuNo , String date , String time) {
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
		}
		sql +=  " WHERE id = ? ";
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


}

