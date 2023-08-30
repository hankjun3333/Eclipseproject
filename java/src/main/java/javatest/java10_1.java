package javatest;

import java.util.Arrays;
import java.util.Scanner;
//질문을 배열로 처리하는 방법!
public class java10_1 {

	public static void main(String[] args) {
		String q[] = {"고객명을 입력하세요","아이디를 입력하세요","패스워드를 입력하세요"};
		Scanner sc = new Scanner(System.in);
		String a[] = new String[q.length];
		int w =0; //배열이니까 0부터
		while(w<q.length) {
			System.out.println(q[w]);
			a[w] =sc.nextLine(); 
			w++;
		}
		System.out.println(Arrays.toString(a));
		
	}

}
