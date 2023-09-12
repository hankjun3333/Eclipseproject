package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class product_list {
	Connection conn = null;
	PreparedStatement ps = null;
	
	//카운팅은 별도로 코딩하자
	public int data_ea() {
		int ea = 0;
		try {
			dbconfig db2 = new dbconfig();
			this.conn = db2.info();
			String sql = "select count(*)as cnt from product";
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery();
			rs.next();
			ea = rs.getInt("cnt");
			this.conn.close(); //connection이 필드에 올려놔서 한번 닫으면 다시 로드해줘야됨
			this.ps.close();
		}
		catch(Exception e) {
			System.out.println("sql문법오류");
		}
		return ea;
	}
	
	
	
	public List<ArrayList<String>> pd_data(){
		List<ArrayList<String>> product = new ArrayList<ArrayList<String>>();
		try {
			/*새로운 db연결을 재 실행함! 실서버에서 db 클로즈 안해주면 뻗는다*/
			/*그리고 클로즈 해놓고 새로 실행안해주면 인젝션 오류뜬다!*/
			dbconfig db2 = new dbconfig();
			this.conn = db2.info();
			System.out.println(this.conn);
			String sql = "select * from product order by pidx desc";
			this.ps = this.conn.prepareStatement(sql);
			System.out.println(this.ps);
			ResultSet rs = this.ps.executeQuery();
			
			/* DTO 작업을 해야함 setter!! dto로 던질거임 */
			dto_product dto = new dto_product();
			//System.out.println(rs.next());
			/* 세터 작업할때 필요한것만 가져오면됨! */
			while(rs.next()) {
				dto.setPidx(rs.getString("pidx"));
				dto.setPcode(rs.getString("pcode"));
				dto.setPname(rs.getString("pname"));
				dto.setPmoney(rs.getString("pmoney"));
				product.add(dto.db_data());
			}
			ps.close();
			rs.close();
			this.conn.close();
		}
		catch(Exception e) {
			System.out.println("sql 문법오류");
		}
		
		
		return product;
	}
}
