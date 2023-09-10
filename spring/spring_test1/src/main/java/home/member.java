package home;
//모듈 파트

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class member {
	Connection con = null;
	PreparedStatement ps = null;
	public ArrayList<ArrayList<String>> mb_list(){
		ArrayList<ArrayList<String>> ar2 = new ArrayList<ArrayList<String>>();
		
		dto_member dto = new dto_member();
		try {
			dbconfig db = new dbconfig();
			this.con = db.info();
			//System.out.println(con);
			String sql = "select * from member order by midx desc";
			this.ps = this.con.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			//System.out.println(rs);
			while(rs.next()) {
				dto.setMidx(rs.getString("midx"));
				dto.setMid(rs.getString("mid"));
				dto.setMemail(rs.getString("memail"));
				dto.setMtel(rs.getString("mtel"));
				dto.setMage(rs.getString("mage"));
				ar2.add(dto.member_dto());
			}
			//System.out.println(ar2); 
			rs.close();
			this.ps.close();
			this.con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return ar2;
	}
	public ArrayList<ArrayList<String>> mb_list(String sh, String part){
		ArrayList<ArrayList<String>> ar2 = new ArrayList<ArrayList<String>>();
		String sql = "";
		dbconfig db = new dbconfig();
		try {
			if(part.intern() == "id") {
				this.con = db.info();
				sql = "select * from member where mid = ? order by midx desc";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, sh);
			}
			else if(part.intern() == "tel") {
				this.con = db.info();
				sql = "select * from member where mtel like ? order by midx desc";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, "%"+sh+"%");				
			}
			ResultSet rs = this.ps.executeQuery();
			dto_member dto = new dto_member();
			while(rs.next()) {
				dto.setMidx(rs.getString("midx"));
				dto.setMid(rs.getString("mid"));
				dto.setMemail(rs.getString("memail"));
				dto.setMtel(rs.getString("mtel"));
				dto.setMage(rs.getString("mage"));
				ar2.add(dto.member_dto());
			}
			if(ar2.size() == 0) {
				dto.setMidx(null);
				dto.setMid(null);
				dto.setMemail(null);
				dto.setMtel(null);
				dto.setMage(null);
				ar2.add(dto.member_dto());
			}
			rs.close();
			this.ps.close();
			this.con.close();
		}
		catch(Exception e) {
			System.out.println("오류사항2");
		}
		
		return ar2;
	}
}




