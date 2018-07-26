package b.team.works.u22.hal.u22teamb.tools;
import java.sql.SQLException;

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
}

