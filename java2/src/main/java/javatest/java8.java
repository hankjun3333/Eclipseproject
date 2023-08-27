package javatest;

import java.util.*;

/*
  double loop 응용편 do-while, for 이용 
  결과값은 이렇게 출력되도록 하시오
  9*1 = 9
  9*2 = 18
  9*3 = 27
  8*1 = 8
  8*2 = 16
  8*3 = 24
  7*1 = 7
  7*2 = 14
  7*3 = 21 이런식
  
  
  */
public class java8 {

	public static void main(String[] args) {
		/*
		 * int w=9; int f; int total=0; do { for(f=1; f<=3; f++) { total = w*f;
		 * System.out.println(w + "*" + f + "=" + total); }
		 * 
		 * w--; }while(w>=7);
		 */
		/*
		 응용문제 5
		 Scanner를 이용하여 다음과 같이 결과값이 나오도록 합니다.
		 " 구구단 2단부터 9단까지 숫자를 하나 입력하세요: "
		 사용자가 5를 입력 시 
		 5*1 부터 5*9 까지 출력되도록 합니다!
		 단,메인메소드에서 입력을 받은 후 외부 클래스로 메소드로 전송하여 출력함
		 */
		System.out.println("구구단 2단부터 9단까지 숫자를 하나 입력하세요:");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		data11 d = new data11();
		d.abc(a);
		
	}

}

class data11{
	public void abc(int a) {
		int f;
		int total=1;
		for(f=1; f<=9; f++) {
			total = a*f;
			System.out.println(a+"*"+f+"="+total);
			
		}
	}
}