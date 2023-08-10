package array_test;

import java.util.*;
import java.util.Collections;

//2차 배열을
public class array7 {

	public static void main(String[] args) {
		new array7().test();
	}
	//2차 배열을 1차 배열로 만들어보자
	public void test() {
		int a[][] = {
				{1,3,5,7},
				{2,4,6,8}
		};
		int ea1 = a.length;
		System.out.println(ea1);
		int ea2 = a[0].length;
		System.out.println(ea2);
		int ea3 = ea1*ea2;
		System.out.println(ea3);
		//int b[] = new int[ea3];
		Integer b[] = new Integer[ea3];
		int count=0;
		for(int k[] : a) {
			for(int j : k) {
				//System.out.println(j);
				b[count] = j;
				count++;
			}
		}
		System.out.println(Arrays.toString(b));
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
		Arrays.sort(b,Collections.reverseOrder());
		System.out.println(Arrays.toString(b));
		
		/*
		  응용문제 9번
		  각 나라별 행복수치 관련 데이터 입니다. 현재 2차배열이고 해당 데이터를 1차 배열로 가공하여 출력되도록합니다.
		  1번 Data : 대한민국,일본,중국,베트남,태국
		  2번 Data : 40, 35, 70 , 55, 57
		  병합된 결과값은
		  ["대한민국(40)","일본(35)","중국(70)","베트남(55)","태국(57)"]
		 */
		
		//--------------------------------------8/11 여기까지
		Object data[][] = {
				{"대한민국","일본","중국","베트남","태국"},
				{40,35,70,55,57}
		};
		Object new_data[] = new Object[data[0].length];
		int i,k;
		int ct=0;
		String sum;
		for(i=0; i<data[0].length; i++) { //5
			for(k=0; k<data.length; k++) {
				if(i==k) {
					new_data[ct] = data[i][k];
					ct++;
				}
			}
		}
		System.out.println(Arrays.toString(new_data));
	}

}
