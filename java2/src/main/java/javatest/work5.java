package javatest;

import java.util.*;

/*
 숙제 상속형태의 클래스를 이용하여 다음 문제에 맞는 결과값을 돌출하는 코드를 작성하시오
 [DB] = {55,1,6,8,10,22,96,33,31,45,48,60}
 스캐너로 질문함
 "해당 데이터를 1.짝수, 2.홀수 를 선택하세요?:"
 [결과]
 짝수값 : 6,8,10,22,96,48,60
 홀수값 : 55,1,33,31,45 //sort 정렬해서 이쁘게
 
 최종값은 (짝수이면) 6 8 10 22 48 60 96 이렇게 오름차순으로 정렬 하여 출력합니다.! 
  
 */
public class work5 {

	public static void main(String[] args) {
		try {
			new data5().db();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
class db{
	String a[] = null;
	public void db() {
		this.a = new String[] {"55","1","6","8","10","22","96","33","31","45","48","60"};
	}
}
class data5 extends db{
	Scanner sc = null;
	@Override
	public void db() {
		super.db();
		
		this.sc = new Scanner(System.in);
		System.out.println("해당 데이터를 1.짝수, 2.홀수 를 선택하세요?: (기본값 - 짝수)");
		String q1 = sc.nextLine().intern();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<String> arr2 = new ArrayList<String>();
		int ck=0;
		if(q1 =="짝수") {
			for(String num : this.a) {
				if(Integer.parseInt(num)%2 ==0) {
					//System.out.println(num);
					arr.add(Integer.parseInt(num));
				}
			}
			Collections.sort(arr); //정렬이 도데채 왜안될까
			
		}
		else if(q1 =="홀수") {
			for(String num : this.a) {
				if(Integer.parseInt(num)%2 !=0) {
					arr.add(Integer.parseInt(num));
				}
			}
			Collections.sort(arr);
		}
		else {
			while(true) {
				System.out.println("값을 제대로 입력해주세요");
				System.out.println("해당 데이터를 1.짝수, 2.홀수 를 선택하세요?: (기본값 - 짝수)");
				q1 = sc.nextLine().intern();
			}
		}
		System.out.println(arr);
		
	}
}
