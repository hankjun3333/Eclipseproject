package java_exp;

public class java10 {

	public static void main(String[] args) {
		box1 b = new box1();
		//b.box1("a");
		//new box1("a");
		//new box1("a",3);
		//b.box1();
		//b.box1("2",3);
		//new box1("a",3);
		new box1().box1("a");
	}

}
class box1{
	public box1() {
		System.out.println("즉시 실행 메소드 1");
	}
	public box1(String a) {
		System.out.println("즉시 실행 메소드 2");
	}
	public box1(String a , int b) {
		System.out.println("즉시 실행 메소드 3");
	}
	public void box1() { //즉시 실행메소드와 일반 메소드는 다름 void에 따라서 이름같아도 사용가능!!
		System.out.println("일반 메소드 1");
	}
	public void box1(String a) {
		System.out.println("일반 메소드 2 -인자값있는경우");
	}
	public void box1(String a,int b) {
		System.out.println("일반 메소드 3 - 인자값 2개 있는경우!");
	}
}





