package javatest;
/* Thread 란 무엇인가? cpu가 일을 할 수 있는 공간 (메인클래스 에는 안함), 그 외에는 사용가능*/
//Thread란? 1개의 Cpu의 공간을 말함
/* extends => 상속 받아서 쓰는 형태의 (Thread) 사용*/
/*interface => 인터페이스로 쓰는 형태 Runnable 사용*/
//MultiThread : 개발자가 1개 이상의 cpu 공간을 활용하는 사항

public class java18 {

	public static void main(String[] args) {
		int a = 100;
		int w = 0;
		th1 t = new th1();
		/*
		while(w<=a) {
			System.out.println(w);
			w++;
		}
		*/
		
		/*
		while(w<=a) {
			th2 t2 = new th2(w);
			//t2.run(); 메소드 직접실행 하는거아님
			//start는 Thread 중 run 메소드를 실행시키는 것임
			t2.start(); //이게 쓰레드를 쓰는거임 먼저 처리되는것이 먼저 출력이 됨
			w++;
		}
		*/
		
		  int aa=0;
		  th3 t3 = new th3(aa);
		  Thread th = new Thread(t3);
		  th.start();
		  for(aa =0; aa<11; aa++) {
			  t3 = new th3(aa);
			  th = new Thread(t3);
			  th.start();
		  }
	}
}
class th1 {
	int start(int a) {
		return a;
		
	}
}
class th2 extends Thread{ 
	private int b = 0;
	public th2(int a) {
		this.b = a;
	}
	@Override
	public void run() {
		System.out.println(this.b);
		
	}
}
class th3 implements Runnable{

	public int c = 0;
	public th3(int z) {
		this.c = z;
	}
	@Override
	public void run() {
		System.out.println(this.c);
	}
	
}






