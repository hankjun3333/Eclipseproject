package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class air_reserveok {

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
	//인자값으로 길게 받아와야 하는 경우는 dto를 만드는게 좋다!
	protected int reserve_insert(String acode,
			String a_corp,
			String a_contry,
			String a_sdate2,
			int a_avail,
			int amoney,
			String start_day2,
			String end_day2) throws Exception{
		int oksign = 0;
		this.con.setAutoCommit(false); //transaction 사용
		try {
		this.dbcon();
		this.ps = con.prepareStatement("insert into air_reserve values('0',?,?,?,?,?,?,?,?,now())");
		this.ps.setString(1, acode);
		this.ps.setString(2, a_corp);
		this.ps.setString(3, a_contry);
		this.ps.setString(4, a_sdate2);
		this.ps.setInt(5, a_avail);
		this.ps.setInt(6, amoney);
		this.ps.setString(7, start_day2);
		this.ps.setString(8, end_day2);
		this.con.commit(); //완료
		oksign = this.ps.executeUpdate();
		this.ps.close();
		this.con.close();
		}
		catch(Exception e) {
			System.out.println(e);
			this.con.rollback(); //입력사항 취소쉬킴
		}
		return oksign;
	}
	
	
}
