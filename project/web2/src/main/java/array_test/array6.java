package array_test;

import org.apache.catalina.tribes.util.Arrays;

//2차 배열
//정적배열은 자리만선언
//동적배열은 자리선언과 동시에 값도집어넣음
public class array6 {

	public static void main(String[] args) {
		new array6().test();
	}
	public void test() {
		//2차 배열의 기본적인 형태
		String member[][] = {
				{"박초롱","윤보미","정은지","김남주","오하영"},
				{"31","29","33","31","32"}
		};
		int ea = member.length;
		//System.out.println(ea);
		int ea2 = member[0].length;
		//System.out.println(ea2);
		int ea3 = ea* ea2;
		
		//-------------------------------------------------------------
		/*
		 * 응용문제 7 번 
		 * 다음 코드를 활용하여 예시처럼 결과값을 출력되도록 해보시오
		 * 박초롱
		 * 31
		 * 윤보미
		 * 29
		 * 정은지
		 * 31 이런식 출력 해보자
		 * */
		//바깥 그룹 ea가 2개고
		//안쪽 데이터가 ea2가 5개였는데 각각 5번을 크게 돌려야 하니 이렇게 값을 바꿈
		/*
		 * int i, j; for(i=0; i<ea2; i++) { //5 for(j=0; j<ea; j++) { //2 //
		 * System.out.println(member[j][i]); }
		 * 
		 * }
		 */
		
		//--------------------------------------------------------------
		/*
		 응용문제 8번
		 해당 데이터 배열에 있는 모든 값 중 짝수값만 모두 더하여 결과값을 출력하는 코드를 작성하시오
		 1번 데이터 : 11 42 22 16
		 2번 데이터 : 7 33 10 29
		 */
		int number[][] = {
				{11,42,22,16},
				{7,33,10,29}
		};
		int ea10 = number.length;
		int ea11 = number[0].length;
		int ea12 = ea10*ea11;
		//2차원 배열 이니 최초 1차원 배열로 받아야함
		
		/* foreach문을 써봄
		 * int sum =0; for (int k[] : number) { for(int l : k) {
		 * //System.out.println(l); if(l%2==0) { sum += l; } } System.out.println(sum);
		 * }
		 */
		//이중 for문을 써보장'
		int aa,bb;
		int total = 0;
		for(aa=0; aa<ea10; aa++) {
			for(bb=0; bb<ea11; bb++) {
				//System.out.println(number[aa][bb]);
				if(number[aa][bb]%2==0) {
					total += number[aa][bb]; 
				}
			}
			//System.out.println(total);
		}
		//-----------------------------------------------
		/*
		 * 숙제 :
		 * 해당 두개의 배열 데이터가 있습니다. 각 배열별로 인덱스가 같은 번호를 더하여
		 * 짝수 홀수인지를 배열 결과 데이터로 재 설정하여 출력하시오.
		 * Adata = 5 17 19 22 23
		 * Bdata = 1 2 3 4 5
		 * 결과 출력예시)
		 * ["짝수","홀수","짝수","짝수","짝수"]
		 */
		
		
		  int adata[] = {5,17,19,22,23}; 
		  int bdata[] = {1,2,3,4,5}; 
		  String cdata[] = new String[adata.length]; 
		  int k =0; 
		  int sum = 0; 
		  int count=0; 
		
		  for(k=0; k<adata.length; k++) {
			  sum = adata[k] + bdata[k];
			  if(sum %2 ==0) {
				  cdata[count] = "\"짝수\"";
			  }
			  else {
				  cdata[count] = "\"홀수\"";
			  }
			  count++;
		  }
		  System.out.println(Arrays.toString(cdata));
		
	}	
}
