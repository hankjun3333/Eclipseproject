package example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class file1 {

	public static void main(String[] args) {
		try {
			new box_office().abc();
		}
		catch(Exception e) {
			System.out.println("파일 로드 오류!!");
		}

	}

}
/* Scanner를 이용하여 다음과 같이 실행되도록 합니다*/

/*  
  1.개봉작 리스트 출력
  2.프로그램 종료 
  
  1번 입력 후 엔터 실행시, 영화리스트가 출력 되어야 하며,
  2번 입력시 프로그램을 강제 종료합니다.
 */
class box_office{
	FileReader fr = null;
	Scanner sc = null;
	public void abc() throws Exception{
		this.fr = new FileReader("D:\\project\\example\\src\\main\\webapp\\movie_db.txt");
		BufferedReader bf = new BufferedReader(this.fr);
		this.sc = new Scanner(System.in);
		System.out.println("1. 개봉영화 리스트 출력 || 2. 종료? ");
		String button = sc.next().intern();
		String line ="";
		//System.out.println("1번은 영화 리스트 출력 , 2번은 프로그램 종료");
		if(button == "1번") {
			while((line = bf.readLine()) != null) {
				System.out.println(line);
			}
		}
		else{
			System.out.println("프로그램 종료");
			System.exit(0);
		}
		bf.close();
		this.fr.close();
	}
}






