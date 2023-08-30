package javatest;

/*class 안에 class 있는 경우*/
/*
 응용문제 중 중첩 클래스를 이용하여 자식 클래스에 결과값을 출력하는 프로세스를 제작하시오
 부모 클래스명 : mother
 자식 클래스명 : child
 메인 클래스 에서 : mother 클래스로 값을 전달하는데 전달값은 2개이며 부모 클래스에서 받은 값을 child 클래스 에서 곱한 결과를 출력하도록 합니다.
 ex) 부모 클래스에 (30 50); 
 자식클래스에서 결과값 : 1500 이 출력 
  
 */
public class java15 {

	public static void main(String[] args) {
		
		mother m = new mother();
		
		m.abc(30,50);
		//이미 생성된 부모 객체를 이용하여 자식 인스턴스를 생성
		mother.child ch2 = m.new child(); //중첩에서 자식클래스 인스턴스 생성할떈 이런식! A a = a.new B();
		ch2.abc(40, 50); //해당 메소드를 호출
	}
	
}
class mother{
	int aa, bb;
	public void abc(int a , int b) {
		this.aa = a;
		this.bb = b;
		child ch = new child();
		ch.abc(a, b);
	}
	class child{
		/*불러올때*/
		//int aa = mother.this.aa; 이것도 가능
		//int bb = mother.this.bb;
		
		public void abc(int a, int b) {
			int total = a * b ;
			System.out.println(total);
		}
	}
}