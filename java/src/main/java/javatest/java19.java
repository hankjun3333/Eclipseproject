package javatest;
public class java19 {

	//위에 타타다닥 던지고 밑에서 파바바박 처리하는 느낌으로 쓰레드를 해야한다
	public static void main(String[] args) {
		int num[] = {10,5,19,22,13,6,4};
		th4 t4 = null;
		int w =0;
		
		while(w<num.length) {
			//System.out.println(num[w]);
			//th4 t = new th4(num[w]); // new th4().start(); 객체 생성없이 인스턴스 생성은 주의해서 사용하자
			t4 = new th4(num[w]); // 값 1개1개마다 계속 새로운 인스턴스 생성! th4 private int b =0; 이게 계속 0으로 초기화 된다!
			t4.start();
			w++;
		}
	}

}
//setter는 셋팅 해주는 역할 값을 필드 값에 넣어준다던지 이런것!
//getter는 return 해주는 역할!
class th4 extends Thread{
	
	private int b = 0; //필드값선언 private 여기서만 값을 바꿀수 있도록 처리! --인스턴스가 계속 생성되므로 변수 값이 계속 초기화 됨
	/*여기서 조건을 처리해도 된다!*/
	public th4(int a) { //쓰레드 처리는 바로 쓰레드-오버라이드로 받기가 어려움 //즉시 실행 메소드를 생성해줘야됨!
		this.b = a; //인자값을 필드값에 넣어버림 //그럼 밑에 오버라이드 메소드는 this.b로 사용이 가능! (위에서날라온 인자값)
		// int a  인자값 a는 셋터역할이다! this.b 를 값을 셋팅해주는 것이니까
	}
	
	
	@Override //Thread 의 메소드 run은 메인 함수 부분에서 start하면 자동으로 불러와짐
	public void run() { // 결과값을 출력하는 부분!
		int sum = 0;
		int i = 1;
		for(i=1; i<=this.b; i++) { //인자값을 기억함
			sum += i;
		}
		System.out.println(this.b+" 의 결과값은 :"+sum+" 입니다.");
		
	}
	
}