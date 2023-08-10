package array_test;
//foreach문 사용
public class array3 {

	public static void main(String[] args) {
		new array3().test();
	}
	/*
	  여기서 가장 중요으한 꿀팁! for each문 에서는 배열이 String이면
	  foreach문에서도 String을 반드시써야한다!!!!!!!!!!
	 */
	public void test() {
		String user[] = {"홍길동","김유신","장보고","유관순"};
		for(String i : user) {
			System.out.println(i);
		}
	//-----------------------------------------------------------
		
		/*
		응용문제 4번 : 
		foreach를 이용하여 다음 배열 데이터의 값을 모두 곱한 결과값을 출력하시오
		5 10 15 20 25 30 35
	    */
		//여기수어 중요한 꿀팁은 foreach문에서 밑에 i는 index번호가 아니라
		//그 위치에 있는 값을 뜻함 해당 데이터 값!!!!!
		int num[] = {5,10,15,20,25,30,35};
		int sum = 1;
		for(int i : num) {
			//System.out.println(i);
			sum *= i;
		}
		System.out.println(sum);
		//-------------------------------------------
		/*
		응용문제 5 
		다음 리스트 숫자 중 짝수 , 홀수 각각의 갯수를 출력하시오
		3 6 9 12 15 18 21 24 27 짝수는 몇개? 홀수는 몇개?
		 */
		int list[] = {3,6,9,12,15,18,21,24,27};
		int w = 0;
		int count1 =0;
		int count2 =0;
		while(w<list.length) {
			if(list[w]%2==0) {
				count1++;
			}
			else {
				count2++;
			}
			w++;
		}
		System.out.println("짝수 : " + count1 + " 홀수 : " + count2);
		
		//----------------------------------------------------------
		
		
	}

}
