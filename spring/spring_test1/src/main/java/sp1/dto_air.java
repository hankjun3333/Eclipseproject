package sp1;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

//dto 파트
@Getter
@Setter
public class dto_air {

	String aidx,acode,a_corp,a_contry,a_sdate,a_avail,a_price,start_day,end_day;
	String pidx,pid,pname,passport,ptel,pcount,totalprice;
	public ArrayList<String> lists(){
		ArrayList<String> lists1 = new ArrayList<String>();
		lists1.add(getAcode());
		lists1.add(getA_corp());
		lists1.add(getA_price());
		return lists1;
	} 
	
	public ArrayList<String> list_data(){
		ArrayList<String> al = new ArrayList<String>();
		al.add(getPidx());
		al.add(getPid());
		al.add(getPname());
		al.add(getPassport());
		al.add(getPtel());
		al.add(getAcode());
		al.add(getA_corp());
		al.add(getPcount());
		al.add(getTotalprice());
		return al;
	}
}
