package javatest;

import java.util.*;

public class work3 {

	public static void main(String[] args) {
		try {
			data88 d = new data88();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
class data88{
	Scanner sc = null;
	public void abc() throws Exception{
		this.sc = new Scanner(System.in);
		System.out.println("당신의 성별은??");
		String data1 = sc.nextLine().intern();
		while(true) {
			if(data1 == "남성" || data1 == "여성") {
				//System.out.println(data1);
				break;
			}
			else {
				System.out.println("남성 또는 여성으로 입력해주세요!");
				System.out.println("당신의 성별은??");
				data1 = sc.nextLine().intern();
			}
		}
		System.out.println("당신의 연령층은? ( 10대-1번 ,20대-2번 ,30대-3번 ,40대-4번 ,50대이상-5번 )");
		String data2 = sc.nextLine().intern();
		while(true) {
			if(data2 =="1번" || data2 =="2번" || data2 =="3번" || data2=="4번"||data2=="5번") {
				System.out.println(data2);
				break;
			}
			else if(data2 =="1" || data2 =="2" || data2 =="3" || data2=="4"||data2=="5") {
				//System.out.println(data2+"0대");
				break;	
			}
			else {
				System.out.println("ex) 제발 1번 또는 1 이라고 입력해주세요!!");
				System.out.println("당신의 연령층은? ( 10대-1번 ,20대-2번 ,30대-3번 ,40대-4번 ,50대이상-5번 )");
				data2 = sc.nextLine().intern();
			}
		}
		System.out.println("현재 기후 위기 단계 수준은?" + "\n" + "ex)"+ "\n" +"1. 매우심각"+ "\n" +"2. 심각" +"\n"+ "3. 보통"+"\n" + "4. 심각하지 않음" );
		String data3 = sc.nextLine().intern();
		while(true) {
			if(data3 =="1번" || data3 =="2번" || data3 =="3번" || data3=="4번") {
				break;
			}
			else if(data3 =="1" || data3 =="2" || data3 =="3" || data3=="4") {
				break;
			}
			else{
				System.out.println("ex) 제발 1번 또는 1 이라고 입력해주세요!!");
				System.out.println("현재 기후 위기 단계 수준은?" + "\n" + "ex)"+ "\n" +"1. 매우심각"+ 
				"\n" +"2. 심각" +"\n"+ "3. 보통"+"\n" + "4. 심각하지 않음" );
				data3 = sc.nextLine().intern();
			}
		}
		System.out.println("정보가 깔끔하게 저장됬군요!");
	}
}







