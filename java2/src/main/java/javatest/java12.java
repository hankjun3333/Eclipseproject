package javatest;
//상속에 관련된 문제사항 ( extends ) 상속은 하나클래스만! a b c 있으면 b가 a상속받고 c가 b를 상속받으면 a,b 둘다사용가능
//대신 상속은 한번에 하나씩만!!!!!!
/*단, 상속받은 class 에서 다시 상속을 사용하면 여러개 extends 사용할 수 있긴 있음!!*/
//두개 상속받고싶을땐 인터페이스!!!!
public class java12 {

	public static void main(String[] args) {
		box5 b = new box5();
		b.aa();
		b.bb();
	}

}
class login_ex{ // logout의 부모 클래스
	
	public void aa() {
		System.out.println("로그인 메소드");
	}

}
class logout_ex extends login_ex{ //login_ex 상속받은 자식클래스
	@Override
	public void aa() {
		super.aa();
	}
	public void bb() { //오버로딩! 부모엔 bb()가없음
		System.out.println("로그아웃 메소드");
	}
}
class box5 extends logout_ex{
	@Override
	public void aa() {
		// TODO Auto-generated method stub
		super.aa();
	}
	@Override
	public void bb() {
		// TODO Auto-generated method stub
		super.bb();
	}
	
}