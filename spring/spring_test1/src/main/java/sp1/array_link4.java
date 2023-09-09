package sp1;
//DAO, DTO 구성

import java.util.*;

public class array_link4 {

	public static void main(String[] args) {
		//DAO 파트
		new box().datacall();
	}

}
class box{
	dto dt = new dto(); //setter, getter
	/* */
	public void datacall() {
		//return받는 메소드 형태가 2차원 배열이기 때문에 2차원형식으로 선언
		List<ArrayList<String>> select = this.list();
		System.out.println(select);
	}
	//Database 연결 및 데이터를 배열화 하는 메소드를 필요
	//dto가 1차 배열역할을 함!
	public List<ArrayList<String>> list(){
		List<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		/* 여기가 mysql db부분임!! db가있다는 예시 */
		String data[][] = new String[][] {
			{"hong","hong@nate.com"},
			{"lee","leesu@gmail.com"}
		};
		/*반복문을 이용해서 setter에 값을 이관함*/
		int w =0;
		while(w<data.length) {
			System.out.println(data[w][0]);
			this.dt.setUserid(data[w][0]);
			this.dt.setEmail(data[w][1]);
			/*dto에 1차원 메소드를 호출-리턴값을 받아서 -> 2차원배열 삽입*/
			al.add(this.dt.database());
			w++;
		}
		
		return al; //2차원 배열을 반환하는 형태
	}
}









