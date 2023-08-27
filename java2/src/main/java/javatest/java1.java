package javatest;


/* 초급 class + method 관련 활용 (java2)랑 연관 */
public class java1 {

	public static void main(String[] args) {
		abc a =new abc(); // 인스턴스 생성하면서 바로 실행됨 즉시 실행메소드도 작동하며 , 객체 + 인스턴스 작동됨
		a.aa = 10;
		a.bb = 20;
		a.cc = 30; //메인에서 해당 외부 클래스 필드 변수에 값을 적용 
		a.data(); //변수 만들어서 실행 일반 메소드 작동
		abc.data2(); //메모리 변수라서 바로 실행
		System.out.println(a.number); //외부 클래스에 있는 필드를 가져오는 방법 인스턴스를 생성해서 a.변수값 가져오면됨
		String result = a.data3(100,200); //외부클래스 return은 무조건 변수로 받아야됨
		System.out.println(result);
		
		int call = a.data4("500", "500"); //return 숫자형으로 반환
		System.out.println(call);
	}

}
