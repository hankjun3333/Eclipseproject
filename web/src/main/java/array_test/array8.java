package array_test;

import java.util.ArrayList;
import java.util.Arrays;

//ArrayList 배열 구조
public class array8 {

	public static void main(String[] args) {
		new array8().test();
	}
	public void test() {
		//ArrayList 라는 클래스 : 배열을 사용하는 클래스의 한 종류
		/* add(데이터 추가), get(데이터 값 출력),remove(데이터 삭제), 숫자는 index 0부터 */
		/* size(배열 index갯수를 말함 (length안통함 여기선)) */
		String member[] = {"이순신","홍길동","유관순","강감찬"};
		//<자료형 다쓸수잇음>
		ArrayList<String> ar = new ArrayList<String>(); //빈배열 생성
		//클래스 형태라서 length안먹음 size 써야됨 
		//방 갯수가 자동으로늘어남
		//System.out.println(ar.size());
		ar.add(member[0]);
		ar.add(member[2]);
		ar.add(member[3]);
		//System.out.println(ar.size()); //size()는 현재 배열크기
		//System.out.println(ar); //자체가 ArrayList라서 ar 바로 찍으면됨
		ar.get(1); //이때는 배열기호 x
		//System.out.println(ar.get(1));
		ar.remove(2); //db는 가급적 지우면안됨
		//System.out.println(ar);
		
		//Arrays int 자체가 없기때문에 원시배열 부터 Integer로 선언해야됨
		Integer no[] = {3,4,2,7,5,10};
		//ArrayList 에선 Integer로 써야됨 int자료형이 없음
		//Arrays.asList() => 원시데이터(배열)를 한번에 ArrayList 배열로 데이터를 이관하는 것 
		ArrayList<Integer> ar2 = new ArrayList<Integer>(Arrays.asList(no));
		//System.out.println(ar2.size());
		//System.out.println(ar2);
		
		//ArrayList에 있는 값을 모두 합한 결과값을 출력하시오 (문제)
		int i = 0;
		int sum = 0;
		for(i=0; i<ar2.size(); i++) {
			sum += ar2.get(i);
		}
		//System.out.println(sum);
		
		//이건 위에거 다른방식
		//만약에 int로 원시데이터 선언했을 경우 ArrayList에 사용이 불가능할까?
		//for문을 돌려서 집어 넣으면 들어가짐
		int no2[] = {3,4,2,7,5,10};
		ArrayList<Integer> ar3 = new ArrayList<Integer>();
		for(int f=0; f< no2.length; f++) {
			ar3.add(no2[f]);
		}
		//System.out.println(ar3);
		
		/*
		 * 응용문제 10번
		 * 다음 데이터가 있습니다.
		 * 10,7,6,1,11,37,41,22 입니다
		 * 해당 데이터 에서 짝수 값을 모두 삭제되도록 하여 배열을 출력되도록 합니다.
		 * 결과 [7,1,11,37,41]
		 * 단, ArrayList활용하기
		 */
		
		//원시데이터는 건들지 않는게좋다 망하는수가잇다
		//Array로 다때려박은다음 가공하던지하자
		Integer no3[] = {10,7,6,1,11,37,41,22};
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(no3));
		//System.out.println(arr);
		int w=0;
		while(w<arr.size()) {
			if(arr.get(w)%2 == 0) {
				arr.remove(w);
			}
			w++;
		}
		System.out.println(arr);
		
		//for each를 통한 반복문 사용시 데이터를 수정하거나 추가하는 경우에는 문제가 발생함
		//계속 기존 데이터를 로드하며 사용하기때문 size()는 상관이없음
	}

}






