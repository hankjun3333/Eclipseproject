package sp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

//List 배열! : ArrayList, LinkedList, Vector, Stack, list는 대분류 느낌! 나머진 소분류!!
public class array_link2 {

	public static void main(String[] args) {
		String a[] = {"A","B","C"};
		List<String> z = Arrays.asList(a); //asList 때문에 추가가 안됨
		System.out.println(z);
		
		/* ArrayList */
		List<String> zz = new ArrayList<String>(Arrays.asList(a));
		zz.add("D");
		zz.set(2, "H");
		zz.set(3, "J"); // 해당 데이터를 변경 update 개념! 
		System.out.println(zz);
		
		/*Vector : 멀티 쓰레드를 활용한다! - 배열에 대한 안정성이 좋음 단점은  */
		/*데이터 순차 집어넣는 것 LinkedList 보단 빠르고 ArrayList보단 느림 중간단계느낌임*/
		List<String> zzz = new Vector<String>(Arrays.asList(a));
		zzz.add("10");
		zzz.set(0, "AAA"); //set은 해당되는 값을 바꿔버릴수도 있음!
		System.out.println(zzz);
		
		/*자료형 없는경우 상관없이 다 넣을수있음(Object)*/ //어레이리스트 string떄려도 들어감ㅋㅋ
		List k = new ArrayList<String>(Arrays.asList(a));
		k.add(101);
		k.add("ㅎ오길동");
		System.out.println(k);
		
		ArrayList al = new ArrayList(Arrays.asList(a)); //이것도 오브젝트
		System.out.println(al);
		
		ArrayList<?> al2 = new ArrayList<Object>(Arrays.asList(a));
		
		new datalist().abc(); 
	}

}
class datalist{
	public void abc() {
		String member[][] =  {
				{"홍길동","skt","45"},
				{"이순신","lgt","55"},
				{"감감찬","kt","55"}
		};
		System.out.println(Arrays.toString(member[0]));
		/*String[] Ingeger[] 모든 배열은 2차 배열형태로 구성됨!*/
		ArrayList<String[]> al3 = new ArrayList<String[]>(Arrays.asList(member));
		System.out.println(al3);
		
		
		int w = 0;
		while(w<al3.size()) {
			System.out.println(al3.get(w)[0]);
			w++;
		}
		/*배열 안에 배열 있는 형태*/ /*2차배열을 만들어보즈아잉*/
		ArrayList<Integer>[] ai = new ArrayList[100];
		ArrayList<Integer> ai2 = new ArrayList<Integer>();
		int ww = 0;
		while(ww<10) {
			ai[ww] = new ArrayList<Integer>();
			ww++;
		}
		ai[0].add(10);
		ai[1].add(20);
		ai[2].add(30);
		ai[3].add(40);
		//System.out.println(Arrays.toString(ai)); //빈방을 만들어노흨콕 들어가야됨
		
		/* 2차원 배열 ArrayList 한방에 만들기는 매우 어렵다!*/ //이렇게는 하지말자!!
		//ArrayList<ArrayList<String>> k = new ArrayList<ArrayList<String>>();
		//System.out.println(Arrays.deepToString(k.toArray())); //출력할땐 이렇게 골때리게하는군
		/**/
		
		/* 반복문을 돌려서 데이터를 넣어야함! */
		/* 실제로는 이렇게 2차원 배열을 형성함! */
		ArrayList<ArrayList<String>> k = new ArrayList<ArrayList<String>>();
		/*2차원 배열에 그룹으로 값을 입력하기 위한 1차원 빈배열 생성!*/
		ArrayList<String> kk = new ArrayList<String>();
		kk.add("홍길동");
		kk.add("25");
		kk.add("hong@nate.com"); //1차원 배열에 값을 입력 후
		System.out.println(kk); /*그리고 이거를 새로운 어레이 에다 넣는 방식으로 들어가야 함!!*/
		k.add(kk); // 2차원 배열에 삽입
		
		ArrayList<String> kk2 = new ArrayList<String>(); /*새로운 그룹이 필요하기 떄문에 새로운 1차원 배열을 생성해야함!*/
		kk2.add("리순신");
		kk2.add("300");
		kk2.add("lee@nate.com");
		k.add(kk2);
		System.out.println(k);
		System.out.println(k.get(0).get(2)); //2차원 배열 형태에서 1차원의 값을 가져오기 위한 방법!
		k.get(1).remove(2); //1차원에 특정 인덱스 부분만 지우고 싶을때 사용하는방법
		/*만들어진 상태에서 다시 추가해보기*/
		k.get(1).add("lee@gmail.com");
		System.out.println(k);
	}
}










