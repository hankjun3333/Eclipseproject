package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;

//delete 모듈 부분 
public class product_delete {
	Connection con = null;
	
	public product_delete() {
		try {
			this.con = dbconfig.info();
		}
		catch(Exception e) {
			System.out.println("db접속 오류");
		}
	}
	
	//삭제 모듈 부분
	protected int delete_ok(String idx) throws Exception{
		String sql = "delete from product where pidx=?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setString(1, idx);
		int	oksign = ps.executeUpdate(); //oksign 정상 1 0뜨면 문법오류!

		ps.close();
		this.con.close();
		return oksign;
	}
}
