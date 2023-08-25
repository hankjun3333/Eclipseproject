package example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class file1 {

	public static void main(String[] args) {
		try {
			new box_office().abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
class box_office{
	FileReader fr = null;
	Scanner sc = null;
	public void abc() throws Exception{
		/*Scanner를 이용하여 다음과 같이 실행되도록 합니다.*/
		String url = "D:\\project\\web_example\\src\\main\\webapp\\movie_db.txt";
		this.fr = new FileReader(url);
		this.sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(this.fr);
		ArrayList<String> arr = new ArrayList<String>();
		String num = sc.nextLine().intern();
		String line = "";
		while((line=br.readLine()) != null) {
			if(num == "1") {
				arr.add(line);
			}
			else if(num == "2") {
				System.out.println("프로그램 강제종료");
				System.exit(0);
			}
		}
		System.out.println(arr);
		br.close();
		this.sc.close();
		this.fr.close();
	}
}





