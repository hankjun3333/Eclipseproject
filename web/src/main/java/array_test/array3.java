package array_test;

//foreach문 사용 : 무조건 배열에만 사용하는 반복문임 자바 8번대에 튀어나온놈
public class array3 {

	public static void main(String[] args) {
		//실행하자마자 test()실행
		new array3().test();
	}
	
	//for each문에서 string형이면 다 string int는 다 int 배열은 자료형에 맞추어서 선언한다!!!!
	public void test() {
		/* foreach는 배열값을 이용하여 범위할당 한 만큼만 반복적으로 사용하는 문법
		 * 주의사항 : 배열 자료형과 foreach에 사용하는 자료형을 동일하게 설정해줘야됨!!
	     */
		String user[] = {"홍길동","김유신","장보고","유관순"};
		
		for(String f : user) {
			System.out.println(f);
		}
		/*
			응용문제 4번 : 
			foreach를 이용하여 다음 배열 데이터의 값을 모두 곱한 결과값을 출력하시오
			5 10 15 20 25 30 35
			
		 */
		//int형으로 구성된 배열일때 foreach문쓰면 n이 그자체 값이 되는 것임
		int data[] = {5,10,15,20,25,30,35}; //393750000
		int total=1;
		for(int n : data) {
			//System.out.println(n);
			total = total*n;
		}
		System.out.println(total);
		
		/*
		응용문제 5 
		다음 리스트 숫자 중 짝수 , 홀수 각각의 갯수를 출력하시오
		3 6 9 12 15 18 21 24 27 짝수는 몇개? 홀수는 몇개?
		 */
		int data2[] = {3,6,9,12,15,18,21,24,27};
		int count1 =0;
		int count2 =0;
		for(int i : data2) {
			//System.out.println(i);
			if(i%2==0) {
				//System.out.println(i);
				count1++;
				
			}
			else{
				//System.out.println(i);
				count2++;
			}
			
		}
		System.out.println("짝수 : " + count1 + " 홀수 : " + count2);
	}
}








