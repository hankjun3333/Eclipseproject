package array_test;

import java.util.Arrays;

public class array2 {

	public static void main(String[] args) {
		new array2().test();
		
	}
	public void test() {
		/*
		 응용문제 1번 
		 해당 사용자 아이디 배열값 중 아이디가 3자리 이하의 사용자만 출력하시오 
		 */
		String id[] = {"hong","kim","park","lee","jang","so"};
		int w = 0;
		int ea = id.length;
		/*
		 for문으로 한번 해봄
		 * for(w=0; w<ea; w++) { //System.out.println(id[w]); if(id[w].length() <= 3) {
		 * System.out.println(id[w]); } }
		 */
		
		/*
		 while문으로 한번 해봄
		 * while(w<ea) { //System.out.println(id[w]); if(id[w].length() <= 3) {
		 * System.out.println(id[w]); } w++; }
		 */
		
		/*
		 foreach문으로 한번 해봄
		 * for(String k : id) { System.out.println(k); }
		 */
		
		//-----------------------------------------------
		
		/* 
		  응용문제 2번
		  데이터는 다음과 같습니다. 15 60 11 14 27의 총 5개의 숫자가 있으며
		  해당 데이터의 모든 합한 결과값을 출력시키세요 (127)		  
		 */
		
		int data[] = {15,60,11,14,27};
		int ww =0;
		int total = 0;
		//do-while 문으로 한번해봄
		do {
			//System.out.println(data[ww]);
			total += data[ww];
			ww++;
		}
		while(ww < data.length);
		//System.out.println(total);
		
		//----------------------------------------
		
		/*
		 응용문제 3번 
		 다음 숫자 데이터 리스트 중 짝수의 값만 모두 더한 최종 결과값을 출력하시오
		 5,10,15,20,25,30,35
		 힌트는? -   
		 */
		int data2[] = {5,10,15,20,25,30,35}; //동적 배열의 형태
		int www =0;
		int sum = 0;
		while(www<data2.length) {
			//System.out.println(data2[www]);
			if(data2[www]%2==0) {
				sum += data2[www];
			}
			www++;
		}
		System.out.println(sum);
		
		
	}
	
	
}
