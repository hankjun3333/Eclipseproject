package array_test;

import java.util.*;

//sort 정렬
public class array5 {
	
	public static void main(String[] args) {
		new array5().test();

	}
	//sort : 오름 차순 ,내림차순으로 정렬할때 사용하는 클래스
	//단 , int 사용시 Collections.reverseOrder가 작동하지 않음 
	//숫자 자료형을 가지는 배열은 내림차순 정렬시 Integer로 설정시 정상작동한다
	
	public void test() {
		int a[] = {10,1,6,9,20,11};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a)); // 오름차순으로 정렬됨
		//내림차순 정렬시 숫자는 Integer사용해야 reverseOrder 사용가능
		//오름차순은 그냥 int 해도 됨
		
		Integer b[] = {10,1,6,9,20,11};
		Arrays.sort(b,Collections.reverseOrder());
		System.out.println(Arrays.toString(b));
		
		//문자열도 정렬이됨 딲 숫자일때 내림차순 정렬시 Integer사용만 하면됨 나머지 다먹음
		String c[] = {"z","a","c","h","f"};
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		Arrays.sort(c,Collections.reverseOrder());
		System.out.println(Arrays.toString(c));
		
	}
}
