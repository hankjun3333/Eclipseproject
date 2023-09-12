package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class product_modify {
	Connection con = null;
	private void dbcon() { //db 정보를 못바꾸게 컨트롤러에서 통제 못함
		try {
			this.con = dbconfig.info();
		}
		catch(Exception e) {
			System.out.println("db접속 오류");
		}
	}
	
	/* 여기서 수정을 하는 모듈*/ //2차 배열로 만들 필요가 없다! // dto 사용안함 데이터 한개씩만 필요하기때문!
	protected ArrayList<String> view_ok(String idx){ //이건 외부에서 써야되니 private쓰면안됨
		ArrayList<String> onelist = new ArrayList<String>();
		PreparedStatement ps = null;
		try {
			this.dbcon(); //db 메소드를 실행시켜 주는 것!
			String sql = "select * from product where pidx=?";
			ps = this.con.prepareStatement(sql);
			ps.setString(1, idx);
			ResultSet rs = ps.executeQuery(); //데이터 하나 들고올땐 next쓰면됨!
			rs.next();
			//String pidx,pcode,pname,pmoney,pimg,psale,puse;
			onelist.add(rs.getString("pidx"));
			onelist.add(rs.getString("pcode"));
			onelist.add(rs.getString("pname"));
			onelist.add(rs.getString("pmoney"));
			onelist.add(rs.getString("pimg"));
			onelist.add(rs.getString("psale"));
			onelist.add(rs.getString("puse"));
			ps.close();
			this.con.close();
		}
		catch(Exception e) {
			System.out.println("sql 문법 오류");
		}
		
		return onelist;
	}
	
}
