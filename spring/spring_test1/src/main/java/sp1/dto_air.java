package sp1;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

//dto 파트
@Getter
@Setter
public class dto_air {

	String aidx,acode,a_corp,a_contry,a_sdate,a_avail,a_price,start_day,end_day;
	
	public ArrayList<String> lists(){
		ArrayList<String> lists1 = new ArrayList<String>();
		lists1.add(getAcode());
		lists1.add(getA_corp());
		lists1.add(getA_price());
		return lists1;
	} 
	
}
