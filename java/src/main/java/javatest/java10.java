package javatest;

//즉시 실행 메소드 부분 + 일반 메소드 부분
/*
  인자 값에 대한 자료형 또는 인자값 갯수에 따라 여러개의 같은 이름을 가진
  즉시 실행 메소드와 일반 메소드를 생성시킬수 있다!
  같은 이름 메소드가 인자값 갯수,종류 따라서 같이 사용할수 있다는말임
  //같은 형태는 메소드 이름 같게 인자를 다르게 해서 사용도 가능함ㅋ
 */
public class java10 {

	public static void main(String[] args) {
		box1 b= new box1();
		box1 b2= new box1("홍길동");
		box1 b3= new box1(30);
		b.box1();
		b.box1("김유신");
		//b.box1();
	
	}

}
//메소드를 한번했다고 해서 못쓰는게 아님 인자 값 다르게 받는 경우도 가능하다이말임
//
class box1{
	public box1() { // 즉시 실행 메소드 (일반 construct)
		System.out.println("즉시 실행 메소드1");
	}
	public box1(String a) { //(인자값 있는 construct)
		System.out.println("즉시 실행 메소드2");
	}
	public box1(int a) {
		System.out.println("즉시 실행 메소드3");
	}
	public box1(int a,int b) {
		System.out.println("즉시 실행 메소드3");
	}
	
	
	public void box1() { //일반 메소드 구조가 다름!! 
		System.out.println("일반 메소드1");
	}
	public void box1(String a) { //일반 메소드 구조가 다름!! 
		System.out.println("일반 메소드2");
	}
	String box2() {
		return null;
	}
	String box2(String a) {
		return null;
	}
}