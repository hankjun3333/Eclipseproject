package sp1;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.*;
//dto setter, getter

@Setter
@Getter
/*setter, getter 중 getter를 로드하여 1차원 배열로 데이터 삽입!*/
//setter는 필드값을 셋팅해줌
public class dto {

	String userid = null;
	String email = null;
	
	public ArrayList<String> database(){
		/* 1차원 배열 을 만들어서 2차원 배열에 넣을 용도임 dto*/
		ArrayList<String> as = new ArrayList<String>();
		as.add(getUserid());
		as.add(getEmail());
		return as;
	}

}
