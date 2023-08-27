package javatest;

import java.util.*;

/*
  숙제 1:
  "개인정보 수집 및 이용동의 ( Y/N )"
  "이메일 수집 및 이용 동의 ( Y/N )"
  "통합 서비스 약관 이용 동의 ( Y/N )"
  해당 동의를 모두 Y 를 하였을 경우
  "서비스 이용 약관에 모두 동의 하셨습니다." 콘솔에 출력
  단, 하나라도 N이 적용시 다시 처음부터 약관동의 등의 내용이 출력 되도록합니다.
  
 */
public class work1 {

	public static void main(String[] args) {
		
		try {
			data33 d = new data33();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
class data33{
	Scanner sc = null;
	
	public void abc() throws Exception{
		this.sc = new Scanner(System.in);
		System.out.println("개인정보 수집 및 이용동의 ( Y/N )");
		String data1 = sc.nextLine().intern();
		while(true) {
			if(data1=="" || data1==null || data1=="n" || data1 !="y") {
				System.out.println("개인정보 수집 및 이용동의 Y를 체크해주세요");
				System.out.println("개인정보 수집 및 이용동의 ( Y/N )");
				data1=sc.nextLine().intern();
			}
			else if(data1=="y") {
				break;
			}
		}
		System.out.println("이메일 수집 및 이용 동의 ( Y/N )");
		String data2 = sc.nextLine().intern();
		while(true) {
			if(data2=="" || data2==null || data2=="n" || data2 !="y") {
				System.out.println("이메일 수집 및 이용 동의 Y를 체크해주세요");
				System.out.println("이메일 수집 및 이용 동의 ( Y/N )");
				data2=sc.nextLine().intern();
			}
			else if(data2=="y") {
				break;
			}
		}
		System.out.println("통합 서비스 약관 이용 동의 ( Y/N )");
		String data3 = sc.nextLine().intern();
		while(true) {
			if(data3=="" || data3==null || data3=="n" || data3 !="y") {
				System.out.println("통합 서비스 약관 이용 동의 Y를 체크해주세요");
				System.out.println("통합 서비스 약관 이용 동의 ( Y/N )");
				data3=sc.nextLine().intern();
			}
			else if(data3=="y") {
				break;
			}
		}
		System.out.println("정보가 잘 저장이 되었습니다.");
	}
}




