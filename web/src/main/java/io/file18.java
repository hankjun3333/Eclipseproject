package io;

import java.io.FileWriter;
import java.util.Scanner;
/*
  수욱제
  Scanner를 이용하여 총 10개의 숫자를 입력합니다!
  단, 1~100까지의 숫자만 입력이 가능하며, 100이상 숫자를 입력할 경우
  해당 콘솔로 "100까지의 숫자만 입력이 가능합니다." 라고 메세지를 출력되어야 합니다.
  (실패시 카운팅 ㄴㄴ)무조건 10개의 숫자를 받아야 하며, 해당 숫자는 모두 data_num.txt파일로 저장 되어야 합니다.
  힌트) continue 또는 무한반복 사용 및 counting 을 이용해야함!
  
 */
public class file18 {

	public static void main(String[] args) {
		
		try {
			data15 d =new data15();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			
			try {
				System.out.println("시스템 종료하였습니다.");
				System.exit(0);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

	}

}
class data15{
	FileWriter fw =null;
	public void abc() throws Exception{
		this.fw = new FileWriter("D:\\project\\web\\src\\main\\webapp\\data_num.txt");
		Scanner sc = new Scanner(System.in);
		int w =0;
		for(w=0; w<10; w++) {
			System.out.println("1~100까지 숫자 중 한가지 입력하세요");
			int data = sc.nextInt();
			if(data<1 || data>100 ) {
				System.out.println("범위에서 벗어났습니다!.");
				w--;
				continue;
			}
			//int를 문자로 바꿨는데 왜 InputMismatchException?
			//아무글자나 쳐도 예외처리됨 이유가뭘까?
			else if(String.valueOf(data) =="quit") { 
				break;
			}
			else {
				fw.write(data + "\n");
			}
		}
		System.out.println("모든 데이터 저장완료");
		sc.close();
		fw.close();
	}
}

