package javatest;

import java.util.*;

/*
  응용문제 1.
  외부 클래스명은 data2 를 활용하여 조건문을 완성하는 코드를 작성하시오
  "첫번째 숫자 를 입력합니다."
  "두번째 숫자 를 입력합니다."
  어느 값이 큰 값인지 콘솔로 출력하시오.
  단, 첫번째, 두번쩨 숫자 중 하나라도 미 입력시 재 호출 되도록 합니다.
  
 */

public class java5 {

	public static void main(String[] args) {
		data2 d = new data2();
		d.abc();

	}

}
/*int 형일 때 null일 경우를 어떻게 표현하지?*/
class data2{
	Scanner sc = null;
	
	public void abc() {
		System.out.println("첫번째 값을 입력하세요");
		this.sc = new Scanner(System.in);	
		String a = this.sc.nextLine().intern(); //intern은 string 문자 밖에안됨 int형은안됨
		System.out.println("두번째 값을 입력하세요");
		String b = this.sc.nextLine().intern();
		
		if(a ==null || a=="" || b==null || b=="") {
			System.out.println("미입력");
			abc();
		}
		else {
			if(Integer.parseInt(a)<Integer.parseInt(b)) {
				System.out.println(b);
			}
			else if(Integer.parseInt(a)>Integer.parseInt(b)) {
				System.out.println(a);
			}
			else {
				System.out.println("첫번째와 두번쨰 값이 같습니다.");
			}
				
		}
	}
}
