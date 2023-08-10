package array_test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

//sort정렬
public class array5 {

	public static void main(String[] args) {
		new array5().test();
	}
	//sort : 오름 차순, 내림차순으로 정렬할때 사용하는 클래스임
	/* 오름차순이 기본이고 내림차수는 Collections.reverseOrder 사용해야 됨*/
	//숫자 자료형을 가질땐 즉, int형 배열일땐 내림차순 정렬시엔 Integer로 선언해야 정상작동!!
	public void test() {		
		Integer a[] = {10,1,6,9,20,11,7};
		//오름 차순으로 해보자
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		Integer b[] = {10,1,6,9,20,11,7};
		Arrays.sort(b,Collections.reverseOrder());
		System.out.println(Arrays.toString(b)); //아무튼 여기서 중요한것은 int로 하면
		//Arrays.sort 에서 Collections.reversOrder() 를 못쓴다는 것!! Integer로 바꿔줘야됨
		
		String c[] = {"z","a","c","b","f"};
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
		Arrays.sort(c,Collections.reverseOrder());
		System.out.println(Arrays.toString(c));
	}

}


