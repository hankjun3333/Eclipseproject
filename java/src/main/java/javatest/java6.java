package javatest;

/*
  반복문 중 for, while, do-while 
  
  */
public class java6 {

	public static void main(String[] args) {
		new data3().abc();

	}

}

/* 1~5까지 출력문 */
class data3{
	
	public void abc() {
		/*
		 * int f; for(f=1; f<=5; f++) {
		 * 
		 * } int w= 1; while(w <= 5) { System.out.println(w); w++; }
		 * 
		 * 
		 * do {
		 * 
		 * w++; } while(w<=5);
		 */
		 
		
		/* 응용문제2. */
		/*
		 해당 숫자를 역순으로 출력합니다
		 10~1 while문으로
		 */
		/*
		 * int k=10; while(k>=1) { // System.out.println(k); k--; }
		 */
		/*
		 응용문제 3 
		 구구단 9*1 부터 9*9 까지 결과값 출력
		 do while 문 
		  
		 */
		
		
		/*응용문제 4*/
		/*
		 100에서 ~150 까지 모든 수를 합한 결과 값을 출력 
		 while문으로 제작 
		 */
		/*
		 * int z = 100; int sum =0; while(z<=150) { sum += z; z++; }
		 * System.out.println(sum);
		 */
		
		/*
		 응용문제 5
		 100~150까지 모든 수를 곱한 결과값 출력
		 for문으로 제작
		  
		 */
		
		int f =100;
		double totalsum=1;
		for(f=100; f<=150; f++) {
			totalsum = totalsum * f;
			
		}
		System.out.println(totalsum);
		
		//byte b = -128 부터 127 까지 출력이 된다! 정수형
		
	}
}
