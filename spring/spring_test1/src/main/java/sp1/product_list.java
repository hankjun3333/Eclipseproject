package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class product_list {
	Connection conn = null;
	PreparedStatement ps = null;
	public List<ArrayList<String>> pd_data(){
		List<ArrayList<String>> product = new ArrayList<ArrayList<String>>();
		try {
			String sql = "select * from product";
			dbconfig db2 = new dbconfig();
			this.conn = db2.info();
			this.ps = this.conn.prepareStatement(sql);
			System.out.println(this.ps);
			ResultSet rs = this.ps.executeQuery();
			//System.out.println(this.ps);
			dto_product dto = new dto_product();
			System.out.println(rs.next());
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
			
		}
		
		
		return product;
	}
}
