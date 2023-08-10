package array_test;

//java니까 java 라이브러리 불러오는게 중요함
//실무에서는 import java.util.*; 라이브러리 전체불러오는 것
import java.util.Arrays;

//원시배열 형태
public class array1 {
	//메인에 코드를 많이때리지 않는다 외부 모듈 or 밖으로 빼서 코드짠다

	public static void main(String[] args) {
		//String, int, Object,(byte -file첨부시) 배열은 크게 3종류
		//숫자 배열은 값이 없으면 0들어감
		//문자 배열은 값이 없으면 null들어감
		// [] a, a[] 둘다 맞음 형태는
		//toString 쓰고 싶으면 byte형태로 바꿔야됨 int는 for문으로 내용확인하자
		
		//Arrays.toString : 모든 원시 배열에 리스트를 모두 표시하는 클래스 이며
		//단, 라이브러리를 java.util.Arrays;를 부분이 아닌 apache,spring...다른것을 불러올 경우
		//버그는 숫자형태의 배열은 출력이 안되는 현상이 발생함
		int []a = new int[5]; // 5개의 데이터
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		int ea = a.length;
		System.out.println(ea);
		int f;
		for(f=0; f<ea; f++) {
			System.out.println(a[f]);
			//지금은 못쓰지만 사용할수 있는 경우가 있음
			//System.out.println(Arrays.toString(a));
			
		}
		//String 형태
		String b[] = new String[3];
		b[0] = "홍길동";
		b[1] = "이순신";
		int ea2 = b.length;
		System.out.println(ea2);
		System.out.println(Arrays.toString(b));
		
		//Object : 문자 + 숫자 합쳐진 원시데이터 자료형
		//이놈의 최대 단점은 데이터 입력은 쉬우나 , 활용시 자료형 무조건 한번은 변환해서 사용해야 됨
		Object c[] = new Object[3];
		c[0] = "hong";
		c[1] = 25;
		int ea3 = c.length;
		//System.out.println(ea3);
		//System.out.println(Arrays.toString(c));
		
		//결론 int는 toString 사용안됨 byte로 형변환 해줘야됨 나머진 toString쓰면됨 --라이브러리 적용하면 쓸수있음
		
		//null,0의 값을 적용하지 않고 규격에 맞게 데이터를 입력하는 형태
		int [] d = {1,2,3,4,5}; // 자료형태로 배열선언 
		int ea4 = d.length;
		//System.out.println(ea4);
		//System.out.println(Arrays.toString(d));
		
		//이것도 배열 ㅇㅇ 클래스형태로 배열 선언
		Integer e[] = {10,20,30,40};
		int ea5 = e.length;
		//System.out.println(ea5);
		//System.out.println(Arrays.toString(e));
		
	}
	

}
