package java_exp;

public class java13 {

	public static void main(String[] args) {
		//Math.random(); -> 기본 함수는 double 형이다!!!!!!
		//double a = Math.random()*10; //0.xx~ 9.xxx 까지 나옴!
		//System.out.println(a);
		//Math.ceil(0)--무조건올림 1~10 , Math.round(0) 0~10 -- 반올림, Math.floor(0) - 0~9
		//이 사실을 반드으시 기억하자잉
		//int a = (int) Math.ceil(Math.random()*10); // 우측변은 아직 double이라는 사실을 잊지말자!
		//System.out.println(a);
		//그래서 int로 형변환을 해줘야댐!!~
		//int b = (int) Math.floor(Math.random()*10);
		//System.out.println(b);
		//int c = (int) Math.round(Math.random()*10);
		//System.out.println(c);
		
		/*응용편, 사용자가 보안코드 5자리를 입력해야 합니다.
		 보안코드 5자리가 출력되도록 코드를 작성하시오. 
		 */
		String seq = "";
		int w=0;
		int a = 0;
		while(w<5) {
			a = (int) Math.floor(Math.random()*10);
			seq = seq + String.valueOf(a); // seq 에 String으로 변환해서도 되고 int로도 그냥 돠네?
			w++;
		}
		System.out.println(seq);

	}

}


