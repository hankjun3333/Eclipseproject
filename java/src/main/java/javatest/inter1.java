package javatest;

import java.util.Scanner;

/*인터페이스는 협업을 위한 것*/
public interface inter1 {
	String name = "홍길동"; //필드에 적용된 전역변수
	String userid = "hong";
	//Scanner sc = null; xxxxxx
	//처음부터 객체와 인스턴스를 활용하여 api class를 생성시킴 -미리 import 해서 box6클래스가 가져가기 때문에
	//box6클래스는 따로 import하지 않음!
	Scanner sc = new Scanner(System.in); 
	public void a1(); //일반 메소드
	default void aa1() { // override 필수로 하지 않고 필요할때만 사용하도록할땐 default 메소드사용
		/*원래는 default는 안쓰면 default인데 interface 에서는 무조건 default라고 써줘야됨!*/
		System.out.println(this.userid);
	}
	class zzz { //인터페이스 안에 있는 외부(다른)클래스
		public void zzjj() { //그 외부클래스의 메소드
			System.out.println("inseterface 안에 다른 클래스를 활용");
		}
	}
}
