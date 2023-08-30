package javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 응용문제1. (오버라이드 활용!)
 "학생명을 입력 해주세요?"
 "검색할 과목명을 입력해주세요 (국어,수학,과학,역사)?:"
 
 데이터는 데이터 별도의 class를 이용합니다! 해당 class 안에 해당 배열 데이터가 있으며,
 해당 데이터를 상속 받아서 다음과 같이 결과가 돌출되도록 프로세서를 작성하시오.
 [데이터]
 {"홍길동","이순신","유관순"},
 {"80","78","92","40"},
 {"40","80","80","100"},
 {"55","40","50","90"}
 결과
 홍길동
 과학 88점!
  
 */
public class java13 {

	public static void main(String[] args) {
		data_test d = new data_test();
		//d.data();
		d.datasearch();

	}

}
//부모 클래스에 static을 때려버리면 변수값을 가져올 수 있다!
//상속을 먼저 받아야 this로 값을 받을 수가 있다!
//super는 상속 받을때 해당 메소드를 실행 후 상속 받음!
class data_ex{ //db영역!
	String member[][] = null;
	String user[] = null;
	public void data() {
		this.user = new String[]{"홍길동","이순신","유관순"}; //이렇게 갯수 안맞을땐 빼주는게 좋음 핸들링할땐 갯수가 맞아야 편함
		this.member= new String[][]{
			 {"80","78","92","40"},
			 {"40","80","80","100"},
			 {"55","40","50","90"}
		};
		
	}
}

class data_test extends data_ex{
	Scanner sc = null;
	@Override
	public void data() {
		super.data(); 
		//System.out.println(Arrays.toString(this.member[0]));
		//System.out.println(Arrays.deepToString(this.member[1])); //2차배열 찍어줌
		int w=0;
		ArrayList<String> arr = new ArrayList<String>();
		while(w<this.user.length) {
			arr.add(this.user[w]+Arrays.deepToString(this.member[w]));
			w++;
		}
		System.out.println(arr);
	}
	public void datasearch() {
		this.data();
		this.sc = new Scanner(System.in);
		System.out.println("학생명을 입력해 주세요?:");
		String name = sc.nextLine().intern();
		int node = 0;
		for(String n : this.user) {
			if(n==name) {
				node=node;
				break;
			}
			else {
				node++;
			}
		}
		System.out.println("검색할 과목명을 입력하세요 (국어,수학,과학,역사)?:");
		String subject = this.sc.nextLine();
		int snode=0; //과목에 대한 노드 번호!
		switch(subject) {
			case "국어": 
				snode = 0;
			break;
			
			case "수학": 
				snode = 1;
			break;
			
			case "과학": 
				snode = 2;
			break;
			
			case "역사": 
				snode = 3;
			break;
			default: //case 외에 사용되는 명령어
		}
		System.out.println(name+"학생의"+subject+"과목의 점수는"+ this.member[node][snode] +"입니다.");
	}
}


