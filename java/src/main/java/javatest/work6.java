package javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 숙제.
 추상 클래스 + 중첩클래스 (nestedclass) 이용하여 프로세스 제작합니다
 추상 클래스에서는 father 라는 이름을 가지고 있으며 
 메소드는 f_method라는 이름을 가집니다. 
 또한, 변수도 u_name 이라는 문자형 변수를 생성합니다. - 여기까지 추상클래스 만들어라!
 
 f_method에 문자형으로 인자값을 하나 받는 형태로 제작합니다.
 
 메인에서 Scanner를 이용하여 사용자 이름을 입력하는 프로세서를 구성합니다.
 구성 후 외부 클래스로 f_method로 값을 전달합니다!
 전달 된 값을 자식 클래스에 전달하며 해당 메소드에 다음과 같이 처리합니다.
 
 홍길동, 이순신 ,유관순은 일반회원 입니다.
 강감찬, 장보고는 실버 회원입니다. 라고 출력 합니다
 그 외에 사용자 이름을 입력시 "해당 사용자는 비회원 입니다." 라고 출력되도록 하시오!  
 */

public class work6 {

	public static void main(String[] args) {

		System.out.println("회원 이름을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		String user = sc.nextLine().intern();
		n_parent np = new n_parent();
		np.f_method(user);			
		n_parent.n_child nc = np.new n_child();
		//nc.abc(user);
	}

}

abstract class father{
	String u_name = "";
	public abstract void f_method(String a);
}
class n_parent extends father{
	String normal[] = {"홍길동","이순신","유관순"};
	String silver[] = {"강감찬","장보고"};
	
	@Override
	public void f_method(String a) {
		this.u_name = a;
		int w=0;
		String msg = "";
		while(w<normal.length) {
			if(this.u_name == normal[w]) {
				//System.out.println("일반회원입니다.");
				msg = "일반회원입니다.";
			}
			else if(this.u_name != normal[w]) {
				
			}
	
			w++;
		}
		w =0;
		while(w<silver.length) {
			if(this.u_name == silver[w]) {
				//System.out.println("일반회원입니다.");
				msg = "실버 회원입니다.";
			}
			w++;
		}
		if(msg.intern() == "") {
			msg = "비회원 입니다.";	
		}
		new n_child().abc(msg);
		

	}
	class n_child{
		public void abc(String a) {
			System.out.println(a);
		}
	}
}





