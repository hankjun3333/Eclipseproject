package sp1;

//값을 간단하게 해주는 + 날짜 + 암호화 간단하게 다때려박는곳
//전부 다 return으로 활용!
public class simplify {

	//날짜 및 시간 단순화 작업! --인터페이스로도 만들어 놓는게 좋음!
	public String day(String val) {
		
		val = val.replaceAll("T"," ");
		return val;
	}
	public String split(String val) {
		//ArrayList<String> ar = new ArrayList<String>(); 
		String a[] = new String[3];
		a = val.split("|");
		val = a[1];
		return val;
		
	}
}
