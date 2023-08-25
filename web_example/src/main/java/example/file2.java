package example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/* 
해당 buffer.txt의 파일을 읽어들인 후 배열로 내용을 저장 후
짝수 배열 값만 출력시키는 프로세서를 제작하시오. 
(2번줄 , 4번줄 데이터 출력) -- BufferedReader 버전
*/
public class file2 {

	public static void main(String[] args) {
		try {
			data2 d = new data2();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}

class data2{
	FileReader fr = null;
	public void abc() throws Exception{
		this.fr = new FileReader("D:\\project\\web_example\\src\\main\\webapp\\buffer.txt");
		BufferedReader br = new BufferedReader(this.fr);
		ArrayList<String> arr = new ArrayList<String>();
		String line = "";
		int count = 1;
		while((line=br.readLine()) != null) {
			//System.out.println(line);
			if(count %2 == 0) {
				arr.add(line);
			}
			count++;
		}
		System.out.println(arr);
	}
}





