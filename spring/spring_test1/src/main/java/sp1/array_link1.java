package sp1;

import java.util.*;
import java.util.LinkedList;

//ArrayList 2탄이라 보면됨 둘의 차이가 무엇인가?
//LinkedList
/*
 db 결합시 둘중 하나를 무조건 써야함!
  ArrayList - 중복을 허용 , 순서를 유지하는 배열 형태! - 출력 위주!
  
  LinkedList - 순방향 , 역순 검색 (양방향) - 해당되는 것 게시판 검색시 편함
  
 */
public class array_link1 {

	public static void main(String[] args) {
		//System.out.println(System.currentTimeMillis());//시간을 알아보자
		Integer a[] = {1,3,6,9,10};
		//배열 인덱스 중간에 데이터를 사용 및 수정할때 , 삭제 - > 링크드가 빠름
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(a));
		//System.out.println(list);
		
		list.add(3,55);
		//System.out.println(list);
		
		/* 어레이와 링크드 를 비교 */
		//순차적으로 삭제 및 삽입할때는 -> 어레이가 월등히 빠름
		Integer b[] = {1,3,6,9,10};
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(b));
		//System.out.println(list2);
		list2.add(3,55);
		//System.out.println(list2);
		
		/* 반복데이터 실험해보장*/
		LinkedList<Integer> data1 = new LinkedList<Integer>();
		ArrayList<Integer> data2 = new ArrayList<Integer>();
		long start = System.currentTimeMillis(); //타이머 시작!
		/*데이터 순차적 삽입형태*/
		Integer w =0;
		do {
			data2.add(w);
			w++;
		}while(w<=10000000);
		/*값을 2 단위로 중간중간 삽입하는 형태 */
		Integer ww = 0;
		int no = 2;
		do {
			data2.add(no,ww);
			no += 2;
			ww++;
		}while(ww<= 500);
		long end = System.currentTimeMillis(); // 작업 후 타이머 끝난 시간
		long timer = end-start; // 그 시간의 갭차이 총걸린시간
		System.out.println(timer); //두가지를 골고루 쓸줄 알아야함
	}

}





