package array_test;

import java.util.Arrays;

//2차 배열을 1차 배열로 합산하는 것 합산시키는 경우가 많음
public class array7 {

	public static void main(String[] args) {
		new array7().test();

	}
	//2차배열을 1차 배열로 만ㄷ르어버리는 것
	public void test() {
		int a[][] = {
				{1,3,5,7},
				{2,4,6,8}
		};
		int ea1 = a.length;//2
		int ea2 = a[0].length;//4
		int make = ea1 * ea2; //해당 배열에 전체 갯수를 파악하기 위한 공식
		int b[] = new int[make]; //2차 배열을 1차 배열로 병합하기 위한 빈배열생성
		
		int count = 0; //배열 배정 번호 순차적으로 값을 넣기 위한것
		for(int i[] : a) { //{1357} 그룹
			for(int j: i) { //배열 내부 데이터
				//System.out.println(j);
				b[count] =j; //b[0] b[1] 이렇게 값을 넣어줘야하니 [변수] 선언해주고 하나씩 증가해주고 값 입력해주고 해야됨
				count++;
			}
		}
		Arrays.sort(b); //배열 오름차순으로 정렬 //내림차순은 int니까 못함 Integer로 바꿔줘야됨
		//System.out.println(Arrays.toString(b));
		
		/*
		 * 응용문제 9번
		 * 각 나라별 행복수치 관련 데이터 입니다. 해당 데이터를 1차 배열로 가공하여 출력되도록합니다.
		 * 1번 Data : 대한민국,일본,중국,베트남,태국
		 * 2번 Data : 40, 35, 70 , 55, 57
		 * 병합된 결과값은
		 * ["대한민국(40)","일본(35)","중국(70)","베트남(55)","태국(57)"]
		 * 
		 * */
		String data[][] = {
				{"대한민국","일본","중국","베트남","태국"},
				{"40","35","70","55","57"}
		};
		 
		
		
		String new_data[] = new String[data[0].length];
		int ww =0;
		do {
			new_data[ww] = data[0][ww] + "("+ data[1][ww] + ")";
		}
		while(ww<data[0].length);
	}
	

}









