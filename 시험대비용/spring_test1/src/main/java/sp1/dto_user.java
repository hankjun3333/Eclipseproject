package sp1;
import lombok.*;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dto_user {
	String mno,mid,mpass,memail,mtel,marea,minter,mage,mdate;
	/*Database에 있는 값을 => 1차원 배열로 만들어서 => return 으로 2차원 배열로 던짐*/
	public ArrayList<String> db_data(){
		ArrayList<String> lists = new ArrayList<String>();
		lists.add(getMno()); //auto
		lists.add(getMid()); //아이디
		lists.add(getMemail()); //이메일
		lists.add(getMtel()); //전화번호
		lists.add(getMage()); //나이
		lists.add(getMdate()); //가입일자
		
		return lists;
	}
}
