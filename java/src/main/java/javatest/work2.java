package javatest;

public class work2 {

	public static void main(String[] args) {
		/*
		 구구단 7단~9단 까지 단, 각 구구단의 곱셈값은 5까지만 나오도록 합니다
		 7*1=7 ~ 7*5=35 8*1=8 ~~~~ 9*5 = 45
		 반복문 제약은 do-while , while 활용!
		 */
		data77 d = new data77();
		d.abc();
	}

}
class data77{
	public void abc() {
		int w=7;
		int sum = 1;
		do {
			int ww=1;
			while(ww<=5) {
				sum = w * ww;
				System.out.println(w + "*" + ww + "=" + sum);
				ww++;
			}
			w++;
		}while(w<=9);
		
	}
}