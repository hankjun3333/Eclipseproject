package array_test;

import java.util.ArrayList;
import java.util.Arrays;

//2차 배열
//정적배열,동적배열 {"홍길동"}
public class array6 {

	public static void main(String[] args) {
		new array6().test();
	}
	public void test() {
		//2차배열형태의 기본 반복문이 더블반복문임
		String member[][] = {
				{"박초롱","윤보미","정은지","김남주","오하영"},
				{"31","29","33","31","32"}
		};
		int ea = member.length;
		System.out.println(ea);
		int data_ea = member[0].length;
		System.out.println(data_ea);
		//밖에 for문 2번 안에 5번 이중포문임 값이 없으면 null 갯수는 맞춰줘야됨
		
		
		/*
		 * 응용문제 7 번 
		 * 다음 코드를 활용하여 예시처럼 결과값을 출력되도록 해보시오
		 * 박초롱
		 * 31
		 * 윤보미
		 * 29
		 * 정은지
		 * 31 이런식
		 * */
		int f, ff;
		for(f=0; f<data_ea; f++) { // 5
			for(ff=0; ff<ea; ff++) { //2
				
				System.out.println(member[ff][f]);	
			}	
		}
		
		/*
		 *응용문제 8번
		 *해당 데이터 배열에 있는 모든 값 중 짝수값만 모두 더하여 결과값을 출력하는 코드를 작성하시오
		 *1번 데이터 : 11 42 22 16
		 *2번 데이터 : 7 33 10 29
		 */ 
		//결과 값은 90
		//두개를 하나로 합치거나 이중포문 써서 값 출력
		int number[][] = {
				{11,42,22,16},
				{7,33,10,29}
		};
		
		int total = 0; //합산값을 위한 변수선언
		for(int a[]: number) { // 배열 그룹 number 2차배열이니까 1차 배열로 따로따로 구성
			for(int b : a) { // 위에서 구성된 1차 배열에 있는 데이터를 한개씩 분리
				if(b% 2 == 0) { //분리된 값을 짝수조건에 맞을때
					total += b; // 합산
				}
			}
			
		}
		System.out.println(total);
		
		
		/*
		 * 숙제 :
		 * 해당 두개의 배열 데이터가 있습니다. 각 배열별로 인덱스가 같은 번호를 더하여
		 * 짝수 홀수인지를 배열 결과 데이터로 재 설정하여 출력하시오.
		 * Adata = 5 17 19 22 23
		 * Bdata = 1 2 3 4 5
		 * 결과 출력예시)
		 * ["짝수","홀수","짝수","짝수","짝수"]
		 */
		
		/*
		 * int adata[] = {5,17,19,22,23}; int bdata[] = {1,2,3,4,5}; String cdata[] =
		 * new String[adata.length]; int k =0; int sum = 0; int count=0;
		 * 
		 * for(k=0; k<adata.length; k++) { sum = adata[k] + bdata[k]; if(sum %2 ==0) {
		 * cdata[count] = "\"짝수\""; } else { cdata[count] = "\"홀수\""; } count++; }
		 * System.out.println(Arrays.toString(cdata));
		 */
		  
		//2차배열로 만들어서 해보자
		int n[][] = {
				{5,17,19,22,23},
				{1,2,3,4,5}
		};
		int ea1 = n[0].length;
		int w = 0;
		String newdata[] = new String[ea1];
		int sum = 0; // int sum =0; sum += 변수 이럴땐넣어야함 변수선언시 초기화 안하면 쓰레기값들어가잇는상태
		while(w<ea1) {
			sum = n[0][w] + n[1][w];
			if(sum %2 ==0) { //짝수 판별
				newdata[w] = " \"짝수\" ";
			}
			else { //홀수판별
				newdata[w] = " \"홀수\" ";
			}
			w++;
		}
		System.out.println(Arrays.toString(newdata));
		  
		
	}
}









