package javatest;

import java.util.Arrays;

//오버로딩,오버라이드 {추상클래스, Thread, interface, Network, IO}
/*
 오버로딩 : 자식 메소드에서 새로운 메소드를 정의하여 코드를 작성하는 형태! (상속은받음)
 오버라이딩 : 부모 클래스에 있는 메소드를 그대로 상속받음(인자값,형태 변환 x) 그대로 사용하여 동일한 형태로
 메소드 구조를 사용하여 코드를 작성하는 형태! 
 */
public class java11 {

	public static void main(String[] args) {
		box3 b = new box3();
		b.abc();
		b.ccc("홍길동");
		b.abc("아이디","이메일");

	}

}
//메소드 이름,인자값형태 부모거 그대로 물려받는거 오버라이드!!
//자식 클래스 수준에서 임의로 메소드 만든거는 오버로딩!!
class box2{
	String user = "hong";
	public void abc() {
		System.out.println("부모 외부 내용값");
	}
	public void abc(String a , String b) {
		//이러면 a,b받는 오버라이드도 가능 
		String data[] = {"1번","2번","3번"};
	}
	public void abc(String a , int idx) {
		//
	}
	public void abc(String a , int tel, int number) {
		//
	}
}
class box3 extends box2{
	@Override //오버라이드 //부모 상속받은 메소드를 조금이라도 인자값 변환하여 사용시 오류뜸(오버라이드 사용x)
	public void abc() {
		super.abc(); //상속받은 부모 내용을 가져오는 것!
		this.user = "park";
		System.out.println(this.user);
		//System.out.println(Arrays.toString(data));
		System.out.println("자식 내용 값");
	}
	@Override
	public void abc(String a, String b) {
		
		super.abc(a,b);
		//System.out.println(Arrays.toString(this.data));
	}
	public void abc(String name) { //이게 오버로딩임! 메소드 이름같은데 인자값 갯수,형태 다르게 한 것
		//super.abc(); //상속받은 부모 내용을 가져오는 것!
		System.out.println("자식 내용 값");
	}
	public void ccc(String name) { //이것도 오버로딩!!
		System.out.println("오버로딩에 사용되는 값");
	}
}