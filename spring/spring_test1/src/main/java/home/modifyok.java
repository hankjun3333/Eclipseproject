package home;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class modifyok {
	Connection con = null;
	private void dbcon() {
		try {
			this.con = dbconfig.info();
		}
		catch(Exception e) {
			System.out.println("db 접속오류");
		}
	}
	
	protected int modify_ok( String mid ,String memail, String mtel, String mage,String midx) {
		int oksign = 0;
		try {
			this.dbcon();
			String sql = "update member set mid=?,memail=?,mtel=?,mage=? where midx=?";
			PreparedStatement ps = this.con.prepareStatement(sql);
			System.out.println(ps);
			ps.setString(1, mid);
			ps.setString(2, memail);
			ps.setString(3, mtel);
			ps.setString(4, mage);
			ps.setString(5, midx);
			oksign = ps.executeUpdate();
			System.out.println(oksign);
			ps.close();
			this.con.close();
		}
		catch(Exception e) {
			System.out.println("sql 문법오류");
		}
		
		
		return oksign;
	}
}
