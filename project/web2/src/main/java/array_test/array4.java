package array_test;
//1차 배열 중 필요한 데이터를 추출하여 신규 배열로 커스텀 하는 방법
import java.util.*;
public class array4 {

	public static void main(String[] args) {
		new array4().test();

	}
	public void test() {
		//b[]에서 짝수 데이터만 a로 넣는 방법
		int a[] = new int [5];
		int b[] = {1,2,3,4,5,6,7};
		int count = 0;
		
		for(int i : b) {
			//System.out.println(i);
			if(i%2==0) {
				//System.out.println(i);
				a[count] = i;
				count++;
			}
		}
		System.out.println(Arrays.toString(a));
		//--------------------------------------------------------
		
		/*
		 * 응용문제 6
		 * 다음 데이터 값 중 아이디가 4글자 이상 아이디만 추출하여 새로운 데이터 배열로 출력하시오.
		 * hong
		 * kim
		 * park
		 * jang
		 * sun
		 * so
		 * han
		 * jung
		 * */
		//do-while문으로 해봄
		/*
		 * String data[] = {"hong","kim","park","jang","sun","so","han","jung"}; String
		 * new_data[] = new String[data.length]; int w =0; int ct = 0; do {
		 * //System.out.println(data[w]); if(data[w].length() >= 4) { new_data[ct] =
		 * data[w]; ct++; } w++; } while(w<data.length);
		 * System.out.println(Arrays.toString(new_data));
		 */
		//for문으로 해볼까 -- 잘작동하는군!
		String data[] = {"hong","kim","park","jang","sun","so","han","jung"};
		String new_data[] = new String[data.length];
		int w =0;
		int ct = 0;
		for(w=0; w<data.length; w++) {
			if(data[w].length() >=4 ) {
				new_data[ct] = data[w];
				ct++;				
			}
		}
		System.out.println(Arrays.toString(new_data));
		
	}

}











