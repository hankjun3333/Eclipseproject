package java_exp;

//상속관계에서는 void타입으로 선언!?
public class java12 {

	public static void main(String[] args) {
		logout out = new logout();
		out.login("a",3);
	}

}
class login{
	public void login() {
		System.out.println("부모 클래스 - 일반메소드");
	}
	public void login(String a) {
		System.out.println("");
	}
}
class logout extends login{
	
	public void login() {
		
		System.out.println("a");
	}
	public void login(String a , int b) {
		System.out.println("b");
	}
}
class box5 extends logout{

	@Override
	public void login(String a) {
		// TODO Auto-generated method stub
		super.login(a);
	}

	@Override
	public void login(String a, int b) {
		// TODO Auto-generated method stub
		super.login(a, b);
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		super.login();
	}
	
}
