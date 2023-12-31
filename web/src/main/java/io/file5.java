package io;
//메인 안에서 코드 짤 경우 static void 내에서 필드사용시 불편한점
//외부 클래스에서 코드를 짜야 한다

/*Scanner를 이용한 파일에 데이터쓰기 기능 활성화*/
import java.io.FileWriter;
import java.util.*;
public class file5 {

	
	//main 에 있는 static 주의할점
	/*
	 static 사용시 new 인스턴스를 호출시 새롭게 읽어 들이므로 기존에 있는 코드를 인식하지 못하는 경우가 발생함!
	  
	 */
	
	//static main에는 this를 절대 사용하지 못함 필드에 올려놔도 못함 객체생성해서 사용해야함
	//this사용 하려면 외부클래스 사용 static void 내부에서는 this 사용안됨 인스턴스 생성해줘야됨
	
	//1.파일열고 스캐너 열고 스캐너 닫고 파일 닫고 역순으로 닫는거임
	public static void main(String[] args) { //메모리에 올려놓고 쓰다보니 this를 못슴 static은
		try {
			//객체생성
			FileWriter fw = null; 
			Scanner sc = null;
			
			/*인스턴스 생성*/
			//static void 일땐 객체를 생성해서 들어가야 됨
			fw = new FileWriter("D:\\project\\web\\src\\main\\webapp\\user.txt",true);
			sc = new Scanner(System.in);
			int f;
			for(f=0; f<3; f++) { //for(;;) 이건 무한
				System.out.println("사용자 이름을 입력해 주세요?");
				String name = sc.nextLine().intern(); //"\n"있으면 break;써도 fw.write(name)작동이되버림
				if(name == "exit") {
					break;
				}
				else {
					fw.write(name+"\n"); //저장할때만 \n사용하자  
				}
				//객체 새로 생성해버리면 인식을못함 기존의것을 파일 연것을인식못함 
			}
			System.out.println("모든 데이터 내용이 저장 되었습니다.");
			sc.close();
			fw.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("파일 오류 발생!!");
		}
		

	}

}
