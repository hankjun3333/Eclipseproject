package java_exp;

public class java11 {

	public static void main(String[] args) {
		//new box2().abc();
		box3 b = new box3();
		b.abc();
		b.box3();
		//b.abc();
	}

}
class box2{
	public void abc() {
		System.out.println("부모가 출력하는거임");
	}
}
class box3 extends box2{
	@Override
	public void abc() {
		super.abc(); // super.abc(); 가 부모 것을 불러와줌!
		System.out.println("부모 것을 받아옴");
	}
	public void box3() {
		System.out.println("자식클래스 일반메소드");
	}
	public box3() {
		System.out.println("자식클래스 즉시 실행메소드");
	}
}
