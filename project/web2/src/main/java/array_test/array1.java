package array_test;

import java.util.*;

//java니까 java 라이브러리를 불러오는게 매우 중요함
public class array1 {
	//메인에 절대 코드르르 많이 넣지 않는다
	//외부로 빼고 인스턴스 생성해서 실행하자!!!!!!!
	public static void main(String[] args) {
		/*
		  배열의 종류로는 String, int, Object,byte
		  이렇게 있고 byte 같은 경우는 file 첨부시 사용한다.!! 
		*/
		/*
		 	숫자배열은 없으면 0 문자 배열 같은경우는 없으면 null
			[] a , a [] 배열 선언시 형태는 둘다 맞다!
			int는 toString을 못쓴다 byte형태로 바꾸어 줘야 됨
			Arrays.toString : 모든 원시 배열에 리스트를 모두 표시하는 클래스이다!
			원시배열을 console에 찍어보고 싶으면 Arrays.toString 사용하면됨!
	    */
		int a[] = new int [5]; //5개의 데이터 정적 배열의 형식
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		System.out.println(Arrays.toString(a));
		//int a[] =new int[5]; 이렇게 선언시 값을넣지 않는것은 정적배열
		/*
		   동적 배열 선언과 동시에 값을 집어 넣는것!
		   정적 배열은 선언시엔 자리만 만들어 놓고 값은 직접 입력하는 것
		 */

		String b[] = {"홍길동","리순신","유관순"};
		int ea = b.length;
		System.out.println(ea);
		System.out.println(Arrays.toString(b));
		
		Object c[] = {"홍순신","이정혁",30};
		int eb = c.length;
		System.out.println(eb);
		System.out.println(Arrays.toString(c));
		
		Integer d[] = {10,20,30};
		int ec = d.length;
		System.out.println(ec);
		System.out.println(Arrays.toString(d));
	}

}


