package home;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dto_member {
	String midx,mid,mpass,memail,mtel,marea,minter,mage,mdate;
	public ArrayList<String> member_dto() {
		ArrayList<String> list = new ArrayList<String>();
		list.add(getMidx());
		list.add(getMid());
		list.add(getMemail());
		list.add(getMtel());
		list.add(getMage());
		return list;
	}
}
