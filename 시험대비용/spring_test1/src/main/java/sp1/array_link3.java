package sp1;

import java.util.ArrayList;
import java.util.Arrays;

/*2차원 배열에 대한 응용편!*/
/* 김경민 배유미 김승균 이철의 장진호 홍사라 박병준 전정호 이경선 최현제 서강인 염무원 
 집에서 다시 해보자!
 원시배열은 이름만있다! ArrayList 필수 !
 [결과]
 [[A조,김경민,배유미,김승균],[],[],[]이런식으로 출력] 
 */
public class array_link3 {

	public static void main(String[] args) {
		//코드 및 결과만 출력!
		ArrayList<ArrayList<String>> k = new ArrayList<ArrayList<String>>();
		ArrayList<String> kk1 = new ArrayList<String>();
		ArrayList<String> kk2= new ArrayList<String>();
		ArrayList<String> kk3 = new ArrayList<String>();
		ArrayList<String> kk4 = new ArrayList<String>();
		
			String a[]	={"A조","김경민","배유미","김승균"};
			String b[] = {"B조", "이철의", "장진호", "홍사라"};
			String c[] = {"C조", "박병준", "전정호", "이경선"};
			String d[] = {"D조", "최현제", "서강인", "염무원"};
		int w=0;
		while(w<a.length) {
			kk1.add(a[w]);
			w++;
		}
		//System.out.println(kk1);
		k.add(kk1);
		//System.out.println(k);
		int ww =0;
		while(ww<b.length) {
			kk2.add(b[ww]);
			ww++;
		}
		k.add(kk2);
		//System.out.println(k);
		int www =0;
		while(www<c.length) {
			kk3.add(c[www]);
			www++;
		}
		k.add(kk3);
		//System.out.println(k);
		int ww4 =0;
		while(ww4<d.length) {
			kk4.add(d[ww4]);
			ww4++;
		}
		k.add(kk4);
		System.out.println(k);
	}

}
