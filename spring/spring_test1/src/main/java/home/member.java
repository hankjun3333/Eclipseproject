package home;
//모듈 파트

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class member {
	Connection con = null;
	PreparedStatement ps = null;
	public ArrayList<ArrayList<String>> mb_list(){
		ArrayList<ArrayList<String>> ar2 = new ArrayList<ArrayList<String>>();
		
		dto_member dto = null;
		try {
			dbconfig db = new dbconfig();
			this.con = db.info();
			System.out.println(con);
			String sql = "select * from member";
			this.ps = this.con.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				dto.setMidx("midx");
				dto.setMid("mid");
				dto.setMemail("memail");
				dto.setMtel("mtel");
				dto.setMage("mage");
				ar2.add(dto.member_dto());
			}
			rs.close();
			this.ps.close();
			this.con.close();
			
			
		}
		catch(Exception e) {
			
		}
		return ar2;
	}
}
