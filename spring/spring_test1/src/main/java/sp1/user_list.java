package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class user_list {
	Connection conn = null;
	PreparedStatement ps = null;
	//db연결
	public user_list() {
		try {
			this.conn = dbconfig.info();
			//System.out.println(this.conn);
		}
		catch(Exception e) {
			System.out.println("db연결오류");
		}
	}
	/*연락처 검색!*/
	public List<ArrayList<String>> listdata2(String pt){
		List<ArrayList<String>> member2 = new ArrayList<ArrayList<String>>();
		try {
			String sql = "select * from member2 where mtel like ?";
			this.ps = this.conn.prepareStatement(sql);
			this.ps.setString(1, "%"+pt+"%");
			/*ResultSet : Stream형태*/
			ResultSet rs = this.ps.executeQuery();
			System.out.println(this.ps);
			//System.out.println(rs.next()); /* true떠야됨 안뜨면 연결이나 잘못됫다는거임 */
			dto_user dto = new dto_user(); //dto setter, getter, Array 생성이됨
			//검색은 입력했지만 해당 아이디가  없을경우
			System.out.println(rs.next());
			while(rs.next()) {
				/*일단 dto 필드 변수명 전체 선언만 해주고 db_data에서 return할지 안할지만 고르면됨*/
				dto.setMno(rs.getString("mno"));
				dto.setMid(rs.getString("mid"));
				dto.setMpass(rs.getString("mpass"));
				dto.setMemail(rs.getString("memail"));
				dto.setMtel(rs.getString("mtel"));
				dto.setMage(rs.getString("mage"));
				dto.setMarea(rs.getString("marea"));
				dto.setMinter(rs.getString("minter"));
				dto.setMdate(rs.getString("mdate"));
				member2.add(dto.db_data());
				}
			if(member2.size() ==0) {
				dto.setMno(null);
				dto.setMid(null);
				dto.setMpass(null);
				dto.setMemail(null);
				dto.setMtel(null);
				dto.setMage(null);
				dto.setMarea(null);
				dto.setMinter(null);
				dto.setMdate(null);
				member2.add(dto.db_data());
			}
			this.conn.close();
		}
		catch(Exception e) {
			System.out.println("데이터베이스 컬럼 및 dto 오류발생!");
		}
				
		return member2;
	}
		
	//검색어가 있을 경우의 처리 메소드
	/*
	 1.검색어를 입력시 데이터베이스에 값과 동일할 경우!
	 2.검색어를 입력했는데 데이터베이스 값과 동일하지 않을경우
	 3.  
	 */

	public int total_member() throws Exception{
		//전체 가입자 수 카운팅하는 부분이 있어야함
		//완전 별도로 뺴야됨 이건 배열이 아니니까!
		  String sql2 = null;
		  sql2 = "select count(*) as cnt from member2";
		  this.ps = this.conn.prepareStatement(sql2);
		  ResultSet rs2 = this.ps.executeQuery();
		  rs2.next();
		  int total = Integer.parseInt(rs2.getString("cnt")) ;
		 
				
		return total;
	}
	
	
	public List<ArrayList<String>> listdata(String sh, String part){
		List<ArrayList<String>> member2 = new ArrayList<ArrayList<String>>();
		String sql = null;
		try {

			if(part.intern() == "id") {
				sql = "select * from member2 where mid = ? order by mno desc";				
				this.ps = this.conn.prepareStatement(sql);
				this.ps.setString(1, sh);				
			}
			else if(part.intern() == "tel") { //전화번호로 검색
				sql = "select * from member2 where mtel like ? order by mno desc";
				this.ps = this.conn.prepareStatement(sql);
				this.ps.setString(1, "%"+sh);
			}
			/*ResultSet : Stream형태*/
			ResultSet rs = this.ps.executeQuery();
			//System.out.println(rs.next()); /* true떠야됨 안뜨면 연결이나 잘못됫다는거임 */
			dto_user dto = new dto_user(); //dto setter, getter, Array 생성이됨
			//검색은 입력했지만 해당 아이디가  없을경우
	
			while(rs.next()) {
				/*일단 dto 필드 변수명 전체 선언만 해주고 db_data에서 return할지 안할지만 고르면됨*/
				dto.setMno(rs.getString("mno"));
				dto.setMid(rs.getString("mid"));
				dto.setMpass(rs.getString("mpass"));
				dto.setMemail(rs.getString("memail"));
				dto.setMtel(rs.getString("mtel"));
				dto.setMage(rs.getString("mage"));
				dto.setMarea(rs.getString("marea"));
				dto.setMinter(rs.getString("minter"));
				dto.setMdate(rs.getString("mdate"));
				member2.add(dto.db_data());
				}
			if(member2.size() ==0) {
				dto.setMno(null);
				dto.setMid(null);
				dto.setMpass(null);
				dto.setMemail(null);
				dto.setMtel(null);
				dto.setMage(null);
				dto.setMarea(null);
				dto.setMinter(null);
				dto.setMdate(null);
				member2.add(dto.db_data());
			}
			this.ps.close();
			this.conn.close();
			
		}
		catch(Exception e) {
			System.out.println("데이터베이스 컬럼 및 dto 오류발생!");
		}
				
		return member2;
	}
	
	
	
	//sql 문법 및 데이터를 배열로 변환하여 가져옴
	/*검색어 없을 때 메소드*/
	public List<ArrayList<String>> listdata(){
		List<ArrayList<String>> member2 = new ArrayList<ArrayList<String>>();
		try {
			String sql = "select * from member2 order by mno desc";
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			//System.out.println(rs.next()); /* true떠야됨 안뜨면 연결이나 잘못됫다는거임 */
			dto_user dto = new dto_user(); //dto setter, getter, Array 생성이됨
			
			while(rs.next()) {
				/*일단 dto 필드 변수명 전체 선언만 해주고 db_data에서 return할지 안할지만 고르면됨*/
				dto.setMno(rs.getString("mno"));
				dto.setMid(rs.getString("mid"));
				dto.setMpass(rs.getString("mpass"));
				dto.setMemail(rs.getString("memail"));
				dto.setMtel(rs.getString("mtel"));
				dto.setMage(rs.getString("mage"));
				dto.setMarea(rs.getString("marea"));
				dto.setMinter(rs.getString("minter"));
				dto.setMdate(rs.getString("mdate"));
				member2.add(dto.db_data());
			}
			this.ps.close();
			this.conn.close();
			
		}
		catch(Exception e) {
			System.out.println("데이터베이스 컬럼 및 dto 오류발생!");
		}
		
		return member2;
	}
		
}
		
	
