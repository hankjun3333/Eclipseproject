package sp1;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class dto_product {
	String pidx,pcode,pname,pmoney,pimg,psale,puse;
	public ArrayList<String> db_data(){
		ArrayList<String> lists = new ArrayList<String>();
		lists.add(getPidx()); //번호
		lists.add(getPcode()); //상품코드
		lists.add(getPname()); //상품명
		lists.add(getPmoney()); //상품가격
		return lists;
	}
}
