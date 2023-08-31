package javatest;

public class work7 {

	public static void main(String[] args) {
		
		int num2[] = {7,14,21,28,35,42,49,56,63};
		
		thr1 th = null;
		for(int i=0; i<num2.length; i++) {
			th = new thr1(num2[i]);
			th.start();
		}
		//th.run(num);
	}

}
class thr1 extends Thread{
	private int b = 0;
	private int bb = 0;
	public thr1(int a) {
		this.b = a;

	}
	@Override
	public void run() {
		System.out.println(this.b);

		}
	}
