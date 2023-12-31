package array_test;

import java.util.Arrays;

//1차 배열 중 필요한 데이터 만 추출하여 신규 배열로 커스텀하는 방법
public class array4 {

	public static void main(String[] args) {
		new array4().test2();

	}
	//b[] 에서 짝수 데이터만 a로 집어넣는 연습
	public void test2() {
		int a[] = new int[5]; //빈배열 5개
		int b[] = {1,2,3,4,5,6,7}; // 실제 데이터 있는 배열
		
		int w = 0;
		int array =0; //배열 번호를 지정하기위한 변수
		while(w<b.length) {
			if(b[w]%2 == 0 && array<a.length) { //짝수조건
				//조건에 맞는경우 이렇게 넣는다
				a[array] = b[w]; //해당 조건이 맞을 경우에 빈배열 0부터 순차적으로 값을 넣어줌
				array++; //빈배열 순차 +1씩 증가
			}
			w++;
		}
		System.out.println(Arrays.toString(a)); //최종결과 출력 toString시 java.util라이브러리사용확인
		
		/*
		 * 응용문제 6
		 * 다음 데이터 값 중 아이디가 4글자 이상 아이디만 추출하여 새로운 데이터 배열로 출력하시오.
		 * hong
		 * kim
		 * park
		 * jang
		 * sun
		 * so
		 * han
		 * jung
		 * */
		
		String data[] = {"hong","kim","park","jang","sun","so","han","jung"};
		//빈배열 생성
		String newdata[] = new String[data.length];
		int k = 0;
		
		for (String m : data) { 
			//System.out.println(data[k]);
			if(m.length() >= 4) { //배열 값 중 단어가 4자리 이상 조건
				newdata[k] = m; //신규 빈배열 값을 이관하는 작업
				k++;
			}
			
		}
		System.out.println(Arrays.toString(newdata));
	}

}
