package javatest;

//random 함수 사용법

public class java14 {

	public static void main(String[] args) {
		//Math.random() : 랜덤함수 -기본 자료형 double , 
		//Math.round
		double no = Math.random()*10;
		//double no2 = Math.round(Math.random()*10);
		int no1 = (int) Math.ceil(Math.random()*10); //1~10
		//int no1 = Integer.parseInt(Math.ceil(Math.random()*10)); Integer parseint 변환 xxx
		//System.out.println(no1);
		int no2 = (int) Math.floor(Math.random()*10); //0~9
		//System.out.println(no2);
		int no3 = (int) Math.round(Math.random()*10); //0~10
		//System.out.println(no3);
		
		/*응용편, 사용자가 보안코드 5자리를 입력해야 합니다.
		 보안코드 5자리가 출력되도록 코드를 작성하시오. 
		 */
		String security = "";
		int w= 0;
		while(w<=4) {
			int n= (int)Math.floor(Math.random()*10);
			security += n;
			w++;
		}
		System.out.println(security);
		
	}

}
