package array_test;

//원시배열 + 조건문 + 반복문
public class array2 {

	public static void main(String[] args) {
		
		//test() 불러오는법 1번
		array2 ar = new array2();
		ar.test();
		
		//test() 불러오는 법 2탄
		//new array2().test();
		
		
	}
	
	public void test() {
		String id[] = {"hong","kim","park","lee","jang","so"};
		int leng= id.length;
		
		//힌트
		//int word = id[0].length();
		//System.out.println(word);
		/*
		 
		 응용문제 1번 
		 해당 사용자 아이디 배열값 중 아이디가 3자리 이하의 사용자만 출력하시오 
		 
		 */
		int i =0;
		for (i=0; i<leng; i++) {
			if(id[i].length() <= 3) {
				System.out.println(id[i]);
			}
		}
		/* 응용문제 2번
		  데이터는 다음과 같습니다. 15 60 11 14 27의 총 5개의 숫자가 있으며
		  해당 데이터의 모든 합한 결과값을 출력시키세요 (127)		  
		 */
		int id2[] = {15,60,11,14,27};
		int j=0;
		int total =0; //결과값 받는 변수가 필요
		for (j=0; j<id2.length; j++) {
			//System.out.println(id2[j]);		
			total += id2[j];
			
		}
		System.out.println(total);
		
		/*
		 응용문제 3번 
		 다음 숫자 데이터 리스트 중 짝수의 값만 모두 더한 최종 결과값을 출력하시오
		 5,10,15,20,25,30,35
		 힌트는? -   
		 */
		
		/*
		 * int num = 45; if(num % 2 ==0) { System.out.println("짝수"); } else {
		 * System.out.println("홀수"); }
		 */
		
		int num[] = {5,10,15,20,25,30,35};
		int total2 = 0;
		int k;
		for(k=0; k<num.length; k++) {
			//System.out.println(num[k]);
			if(num[k] % 2 ==0) {
				total2 += num[k];
			}			
		}
		System.out.println(total2);
		
	}

}














