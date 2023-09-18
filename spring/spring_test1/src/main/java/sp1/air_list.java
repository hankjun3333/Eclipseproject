package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class air_list{

	Connection con = null;
	PreparedStatement ps = null;
	private void dbcon() {
		try {
			this.con = new dbconfig().info();
		}
		catch(Exception e) {
			System.out.println("db연결오류임");
		}
	}
	//air_reserve테이블에서 acode,a_corp , a_price가져옴
	public List<ArrayList<String>> select() {
		List<ArrayList<String>> lists2 = new ArrayList<ArrayList<String>>();
		try {
			this.dbcon();
			String sql = "select * from air_reserve";
			this.ps = this.con.prepareStatement(sql);
			ResultSet rs  = this.ps.executeQuery();
			
			dto_air dto = new dto_air();
			while(rs.next()) {
				dto.setAcode(rs.getString("acode"));
				dto.setA_corp(rs.getString("a_corp"));
				dto.setA_price(rs.getString("a_price"));
				lists2.add(dto.lists());
			}
			rs.close();
			this.ps.close();
			this.con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return lists2;
	}
	
	//db에 저장하는 부분
	protected int insert(String pid,
			String pname,
			String passport,
			int ptel,
			String acode,
			String a_corp,
			int pcount,
			int totalprice) {
			
		int oksign = 0;
			try {
				this.dbcon();
				String sql = "insert into air_person values('0',?,?,?,?,?,?,?,?)";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, pid);
				this.ps.setString(2, pname);
				this.ps.setString(3, passport);
				this.ps.setInt(4, ptel);
				this.ps.setString(5, acode);
				this.ps.setString(6, a_corp);
				this.ps.setInt(7, pcount);
				this.ps.setInt(8, totalprice);
				oksign = this.ps.executeUpdate();
			}
			catch(Exception e) {
				System.out.println("여기가오류임11");
				
			}
		return oksign;
	}
	
	
}
