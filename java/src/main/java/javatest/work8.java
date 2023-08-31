package javatest;

public class work8 {

	public static void main(String[] args){

		int price[] = {2000,3000,1500,2300,3200,1100,3300,4200,6100,4300};
		int count[] = {2,1,1,2,3,2,1,1,2,3};
		int length = price.length;
		thr2 th = null;
		
		//thr2 th = new thr2(); 이게 안되는이유가머지
		for(int i =0; i<length; i++) {
			th = new thr2(price[i],count[i]);
			th.start();			
		}

        
	}
}
class thr2 extends Thread{
	private int price = 0;
	private int count = 0;
	private int total = 0;
	
	public thr2(int a,int b) {
		this.price = a;
		this.count = b;
	}

	@Override
	public void run() {
		this.total = this.price * this.count;
		System.out.println(total);
	}
	
}