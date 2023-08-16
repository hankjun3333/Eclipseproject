package web;
//Module 파트 클래스로 만든건 모두 모듈

public class index {

	int sum = 0;
	
	//this의 역할?
	
	//필드에서 this로 넣음
	public String test(String a, String b) {
		/*
		 Integer.valueOf : 문자를 숫자로 변환시 해당 값이 숫자인지 문자인지 검토 후 변환
		 Integer.parseInt : 문자를 숫자로 int형으로 변환
		  */
		
		
		this.sum =Integer.valueOf(a)+Integer.parseInt(b);
		//return 메소드 자료형이 문자 이므로 결과값을 리턴시킬 경우
		//숫자를 문자화 하여 반환함 toString 이용해서
		
		return Integer.toString(this.sum);
	}
	
	//컨트롤러에서 정수형 변환 모듈에서 정수로 받고 다시 string으로 리턴하는 방법임
	public String test2(int a, int b) {
		this.sum = a + b;
		//강제 형변환 X (casting변환 O) //int dd =(int)d; 이런거
		
		return String.valueOf(this.sum);
	}
}





