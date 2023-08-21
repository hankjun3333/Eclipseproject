package example;

import java.util.Arrays;

//글자를 자르기!!
public class split1 {

	public static void main(String[] args) {
		String test = "어벤져스-홈커밍,1위,2500";
		//split특성은 배열로 만들어짐 배열로 만들어주자!
		//, (콤마로 나눠줘야) ;(세미콜론도 됨) 덩어리 단위로 나뉨 |(파이프)로 나누면 조각조각남
		// split[|] 하면 또 잘나눠짐
		// 파이프로 된건 [|], 콤마로 된건 ,  , +로 나뉜것도 있음 그건 [+] 자바에선 
		//다 배열기호넣고 만들어줘야됨
		String data[] = test.split(",");  
		//System.out.println(data.length);
		System.out.println(data[0]);
		
		System.out.println(Arrays.toString(data));
	}

}
