package sp1;

import java.util.ArrayList;

/*2차원 배열에 대한 응용편!*/
/* 김경민 배유미 김승균 이철의 장진호 홍사라 박병준 전정호 이경선 최현제 서강인 염무원 
 집에서 다시 해보자!
 원시배열은 이름만있다! ArrayList 필수 !
 [결과]
 [[A조,김경민,배유미,김승균],[],[],[]이런식으로 출력] 
 */
public class array_link3_1 {

	public static void main(String[] args) {
		String a[] = {"김경민","배유미","김승균","이철의", 
				"장진호","홍사라","박병준","전정호","이경선","최현제","서강인","염무원"};
		String b[] = {"A조","B조","C조","D조"};
		ArrayList<ArrayList<String>> kk = new ArrayList<ArrayList<String>>();
		ArrayList<String> k1 = new ArrayList<String>();
		ArrayList<String> k2 = new ArrayList<String>();
		ArrayList<String> k3 = new ArrayList<String>();
		ArrayList<String> k4 = new ArrayList<String>();
		
		k1.add(b[0]);
		k2.add(b[1]);
		k3.add(b[2]);
		k4.add(b[3]);
		int w=0;
		while(w<a.length) {
			//System.out.println(a[w]);
			if(w<=2) {
				
				k1.add(a[w]);
			}
			else if(w>2 && w<=5) {
				k2.add(a[w]);
			}
			else if(w>5 && w<=8) {
				k3.add(a[w]);
			}
			else {
				k4.add(a[w]);
			}
			w++;
		}
		kk.add(k1);
		kk.add(k2);
		kk.add(k3);
		kk.add(k4);
		System.out.println(kk);
	}

}
