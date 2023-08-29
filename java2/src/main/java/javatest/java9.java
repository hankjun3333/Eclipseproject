package javatest;
/*app app1 과 연계*/
import app.app1; //외부 패키지 임포트 해줘야됨 무조건!!!!!! ex) 패키지명.public class명! default 같이 외부패키지 외부클래스는 못함!!

import java.util.Arrays;
//import : 가져오는 기능, export : 내보내는 기능!
import java.util.Scanner;

/*패키지가 다를 경우 public class 핸들링하는방법!!*/
public class java9 {

	public static void main(String[] args) {
		app1 ap = new app1();
		//ap.main(args);
		//new abox().dataload(); //일반적인 사용방법!
		//new bbox().dataload();
		//new cbox().dataload();
		//ddd[] 이건 추상클래스의 이름을 써야 됨! 추상클래스를 상속 받아서 배열 형태로 사용함!
		//추상클래스를 쓰는 이유는 여러개를 공용화 해서 프로젝트에 사용할때!
		ddd[] d = {new abox(),new bbox(), new cbox()}; //이렇게 반복문 + 배열로 동시 실행도 가능!
		//d[0].dataload();
		/*
		 * int w = 0; while(w<d.length) { d[w].dataload(); w++; }
		 */
		//일반 반복문은 조건 걸어서 사용가능! -- 반복문으로 배열을 순차적 실행하는 형태!
		
		for(ddd z : d) { //for each 문제점은 break를 못걸음! 중간에 멈출수가 없음
			//System.out.println();
			z.dataload();
		}
		
		
		//외부 패키지 임포트시 public class는 불러올 수 있지만 디폴트 class 이런건 안됨!
		/*public class만 호출 하여 가져올 수 있음 실수많이들 하는 부분이니까 절대 까먹지말자 무조건암기!!*/
		//controller 할때 헷갈릴수 이쓰니 개념 주의!!
	}

}
//abstract : 추상 클래스 + 추상 메소드 (프레임 워크에 활용) -- 안드로이드 스튜디오같은 것
/*public class가 없을 경우 abstract에서도 public로 핸들링 할 수 있으며,
 * 단,public class가 있을 경우 default로 abstract를 이용합니다.*/

/*private 같은 class 에서만 , protected(반공개-패키지가 같으면 값을 바꿀수있음),default(해당 파일에서 활용하는 변수선언)*/
abstract class ddd{
	public String userid = null; //공용으로 사용하는 변수 this를 바로 활용가능)
	public String useremail = null;
	public int userpoint = 0;
	public abstract void dataload();
	public abstract void datainsert();
	//abstract private은 못씀! 다른 클래스에서 가져다 
}
class abox extends ddd{

	@Override
	public void datainsert() {
		//안쓰면 오버라이드 만들어놓긴해야됨 비워놓더라도
		
	}

	@Override
	public void dataload() {
		this.userpoint = 2500; //변수도 공용으로 사용가능!
		System.out.println("abox 클래스");
	}
	
}
class bbox extends ddd{

	@Override
	public void datainsert() {
		//안쓰면 오버라이드 만들어놓긴해야됨 비워놓더라도
		
	}
	@Override
	public void dataload() {
		System.out.println("bbox 클래스");
		
	}
	
}
class cbox extends ddd{
	@Override
	public void datainsert() {
		//안쓰면 오버라이드 만들어놓긴해야됨 비워놓더라도
		
	}
	@Override
	public void dataload() {
		System.out.println("cbox 클래스");
	}
	
}


