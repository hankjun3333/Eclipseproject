package home;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class insertok_m{
	Connection con = null;
	PreparedStatement ps = null;
	private void dbcon() {
		try {
			this.con = new dbconfig().info();
		}
		catch(Exception e) {
			System.out.println("db 연결오류");
		}
	}
	
	protected int ok_insert(String mid, String memail, String mtel, String mage) {
		int oksign = 0;
		try {
			this.dbcon();
			String sql = "insert into member values('0',?,'a1234',?,?,'10','2',?,now())";
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, mid);
			this.ps.setString(2, memail);
			this.ps.setString(3, mtel);
			this.ps.setString(4, mage);
			oksign = this.ps.executeUpdate();
			this.ps.close();
			this.con.close();
		}
		catch(Exception e) {
			System.out.println("sql 문법오류 ");
		}
		return oksign;
	}
}
