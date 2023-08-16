package io;

import java.io.FileWriter;
import java.util.Scanner;

public class file5 {
	//	main에 있는 static 주의할점!!
	/*
	  	static 사용시 new 인스턴스 호출시 새롭게 읽어들이므로 기존 코드를 인식 못하는 경우가 있음!!!!!!
  		그래서 가급적 메인에다가 코드 안때려박는다!!
  		static main 에서는 this를 사용을 못함!!
	  */
	public static void main(String[] args) {
		try {
			/*인스턴스를 생성*/
			FileWriter fw = null;
			Scanner sc = null;
			//static void 일땐 this 못쓰므로 객체 생성해서 들어가야 됨
			fw = new FileWriter("D:\\project\\web_example\\src\\main\\webapp\\user.txt");
			sc = new Scanner(System.in);
			int f;
			
			for(f=0; f<3; f++) {
				System.out.println("사용자 이름을 입력해주세요");
				String name = sc.nextLine().intern();
				if(name=="exit") {
					break;
				}
				else {
					fw.write(name + "\n");
				}
				
			}
			System.out.println("데이터 저장이 완료되었습니다.");
			sc.close();
			fw.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}

