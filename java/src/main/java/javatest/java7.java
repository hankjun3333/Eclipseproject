package javatest;

//double roop 더블 반복문!
public class java7 {

	public static void main(String[] args) {
		new data4().abc();
	}

}
class data4{
	
	public void abc() {
		/*
		//for + for 
		int f ,ff;
		int total;
		for(f=1; f<=5;f++) {
			
			for(ff=1; ff<=5; ff++) {
				total = f + ff;
				System.out.println(total);
			}
		}
		*/
		/*
		int w = 1;
		int total =0;
		while(w<=5) {
			
			int ww =1; //while문 초기값을 안에 넣어야  그 초기값을 불러와서 인식을 한다!!!!!!!! 주의
			//(do-while 도 동일)
			while(ww<=5) {
				total = w + ww;
				System.out.println(total);
				ww++;
			}
			w++;
		}
		*/
		/*
		int z =1;
		int total;
		do {
			int zz = 1;
			do {
				total = z + zz;
				zz++;
			}while(zz<=5);
			z++;
		}while(z<=5);
		*/
		/* for + while 더블로 써보기*/
		/*
		  1+1 = 2, 1+2 = 3, 1+3 = 4, 2+1 = 3 , 2+2 = 4, 2+3 = 5
		  3+1 = 4, 3+2 = 5 , 3+3 = 6 이런식으로 출력하기
		 */
		int w =1;
		int f;
		int total = 0;
		while(w<=3) {
			for(f=1; f<=3; f++) {
				total = w+f;
				System.out.println(w + "+" + f + "=" + total);
			}
			w++;
		}
	}
}





