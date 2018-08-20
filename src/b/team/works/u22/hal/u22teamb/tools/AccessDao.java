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

