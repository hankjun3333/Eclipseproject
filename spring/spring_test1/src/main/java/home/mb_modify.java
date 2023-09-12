package home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class mb_modify {
	Connection con = null;
	private void dbcon() {
		try {
			this.con = dbconfig.info();
		}
		catch(Exception e) {
			
		}
	}
	/*list.add(getMidx());
	list.add(getMid());
	list.add(getMemail());
	list.add(getMtel());
	list.add(getMage());*/
	protected ArrayList<String> mb_modify(String idx) {
		ArrayList<String> ar = new ArrayList<String>();
		try{
			this.dbcon();
			String sql = "select * from member where midx=?";
			PreparedStatement ps = this.con.prepareStatement(sql);
			ps.setString(1, idx);
			ResultSet rs = ps.executeQuery();
			rs.next();
			//ar.add(rs.getString("midx"));
			ar.add(rs.getString("midx"));
			ar.add(rs.getString("mid"));
			ar.add(rs.getString("memail"));
			ar.add(rs.getString("mtel"));
			ar.add(rs.getString("mage"));
			rs.close();
			ps.close();
			this.con.close();
	
		}
		catch(Exception e) {
			
		}
		return ar;
	}
}
