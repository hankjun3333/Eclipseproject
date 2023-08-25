package javatest;


//기본 구조 4가지
//this : 외부 class 에서 사용가능 main에선 this 못씀

class abc{
	String data = ""; // 일반변수
	static String data2 = ""; //메모리 변수 메모리에 올려놓음
	int number = 100;
	int aa,bb,cc =0; // 기본값 적용
	final String adata = "이순신"; //상수라서 값 못바꿈 필드값 못바꿈
	
	public abc() { //즉시 실행 메소드
		this.data = "20";
		this.data2 = "30"; 
		System.out.println(this.data);
	}
	public void data() { //일반 메소드
		String user = "홍길동";
		System.out.println(user);
		System.out.println(this.aa);
		System.out.println(this.bb);
		System.out.println(this.cc);
	}
	public static void data2() { //메모리 등록 메소드
		String user2 = "이순신";
		System.out.println(user2);
	}
	String data3(int a, int b) { //return 메소드 파라미터로 받을땐 int로 받을수있으나 return 할떈 string으로 변환필요
		int sum = a+b;
		this.data2 = String.valueOf(sum); //숫자를 - > 문자로 변환  Integer.toString??
		//Integer.toString(sum);
		return data2;
	}
	public int data4(String a , String b) { //void가 있는건 리턴 x
		int sum = Integer.parseInt(a) + Integer.parseInt(b); //문자를 숫자로 변환
		return sum;
	}
	
}

