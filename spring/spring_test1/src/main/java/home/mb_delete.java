package home;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class mb_delete {
	Connection con = null;
	private void dbcon() {
		try {
			this.con = dbconfig.info();
		}
		catch(Exception e) {
			System.out.println("db연결 오류");
		}
	}
	protected int delete_ok(String idx) throws Exception{
		this.dbcon();
		String sql = "delete from member where midx=?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setString(1, idx);
		int oksign = ps.executeUpdate();
		ps.close();
		this.con.close();
		return oksign;
	}
}
