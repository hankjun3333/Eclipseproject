package io;

import java.io.FileWriter;
import java.util.Scanner;

/*응용문제1
  Scanner를 이용하여 사용자가 입력한 숫자를 모두 저장되도록 합니다.
  "1~100까지 숫자중 한가지를 입력하세요"
  단, 한줄에 하나의 숫자가 입력되도록 하며 quit라는 명령어 입력시 
  프로세서가 종료되도록 하며 저장 파일명은 number.dat 로 저장되도록 하시오. 
 */
public class file6 {

	public static void main(String[] args) {
		try {
				FileWriter fw = new FileWriter("D:\\project\\web\\src\\main\\webapp\\number.txt",true);
				Scanner sc = new Scanner(System.in);
				for(;;) {
					System.out.println("1~100까지 숫자중 한가지를 입력하세요");
					String data = sc.nextLine().intern();//quit로 인하여 String으로 처리
					if(data == "quit") {
						break;
					}
					else if(Integer.parseInt(data)<1||Integer.parseInt(data)>100) {
						System.out.println("1~100의 범위에 벗어났습니다.");
					}
					else {
						fw.write(data+"\n");
					}				
				}
				System.out.println("모든 데이터 저장이 완료되었습니다.");
				sc.close(); //Scanner 종료
				fw.close(); //파일 저장(close를 안할 경우 해당 파일은 오픈되어 있음)
			}
		catch(Exception e) {			
				System.out.println(e);
			}

	}

}
