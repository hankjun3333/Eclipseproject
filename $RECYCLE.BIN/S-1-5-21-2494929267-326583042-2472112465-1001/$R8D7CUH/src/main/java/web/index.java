package web;

// Module Part (class)
public class index {
	
	// this
	int sum = 0;
	
	public String test(String a, String b) {
		/*
		 * Interger.valueOf : 문자를 숫자로 변환시 해당 값이 숫자인지 문자인지 검토 후 int로 변환을 설정.
		 * Interger.parseInt : 문자를 숫자(int 형으로 변환)
		 * */
		this.sum = Integer.valueOf(a) + Integer.parseInt(b);
		// return 메소드 자료형이 문자 이므로 결과값을 리턴시킬 경우
		// 숫자를 문자화 하여 반환함.
		return Integer.toString(this.sum);
	}
	
	public String test2(int a , int b) {
		this.sum = a + b;
		double d = 21.5;
		// casting 형변환
		int dd = (int)d;
		
		return String.valueOf(this.sum);
	}
}
