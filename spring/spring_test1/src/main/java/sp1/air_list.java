package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class air_list{

	Connection con = null;
	PreparedStatement ps = null;
	Statement st = null; //sql 구문 실행 클래스
	private void dbcon() {
		try {
			this.con = new dbconfig().info();
		}
		catch(Exception e) {
			System.out.println("db연결오류임");
		}
	}
	//여러가지 테이블에 대한 총 갯수 값 파악!
	public int total_sum(String tablename) {
		this.dbcon();
		int sum =0;
		try {
		String sql = "select count(*)as cnt from "+tablename ;
		this.st = this.con.createStatement();
		ResultSet rs = this.st.executeQuery(sql);
		rs.next();
		sum = Integer.parseInt(rs.getString("cnt"));
		rs.close();
		this.st.close();
		this.con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return sum;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//페이징 출력!
	protected List<ArrayList<String>> person_list() throws Exception{
		this.dbcon();
		List<ArrayList<String>> all_data = new ArrayList<ArrayList<String>>();
		try {
			String sql = "select * from air_person order by pidx desc limit 4,2";
			this.ps = this.con.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			dto_air da = new dto_air();
			while(rs.next()) {
				da.setPidx(rs.getString("pidx"));
				da.setPid(rs.getString("pid"));
				da.setPname(rs.getString("pname"));
				da.setPassport(rs.getString("passport"));
				da.setPtel(rs.getString("ptel"));
				da.setAcode(rs.getString("acode"));
				da.setA_corp(rs.getString("a_corp"));
				da.setPcount(rs.getString("pcount"));
				da.setTotalprice(rs.getString("totalprice"));
				all_data.add(da.list_data());
			}
			rs.close();
			this.ps.close();
			this.con.close();
			
		}
		catch(Exception e) {
			System.out.println("문법오류");
		}
		return all_data;
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
			int totalprice) throws Exception{
			
		
		int oksign = 0;
		this.dbcon();
		
			try {
				//sql문 : count 인원수 확인할려고
				String count = "select count(a_avail) as cnt from air_reserve where acode=? and a_avail >= ?";
				this.ps = this.con.prepareStatement(count);
				this.ps.setString(1, acode);
				this.ps.setInt(2, pcount);
				
				ResultSet rs = this.ps.executeQuery();
				rs.next();
				if(rs.getString("cnt").equals(1)) { //해당 요청 인원과 여유인원이 맞을경우
					//사용자 정보를 입력받아서 sql 저장시킴
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
					if(oksign ==1) {
						//여기서 카운트 차감하는 것을 작성
					}
					this.ps.close();
				}
				else {
					oksign = 3; //여유좌석없음
				}
				//this.con.commit();

			}
			catch(Exception e) {
				System.out.println("데이터 입력시 조건에 문제가 발생하여 입력취소");
				//this.con.rollback();
			}
		return oksign;
	}
	

}
