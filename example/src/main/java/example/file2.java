package example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

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
	public void abc()  throws Exception{
		this.fr = new FileReader("D:\\project\\example\\src\\main\\webapp\\buffer.txt");
		BufferedReader bf = new BufferedReader(this.fr);
		ArrayList<String> arr = new ArrayList<String>();
		String line = "";
		while((line=bf.readLine()) != null) { //여기선 핸들링 가급적 ㄴㄴ
			//갯수파악 등 핸들링 할땐 ArrayList일단 넣고 
			//ArrayList에서 핸들링하자
			arr.add(line);
		}
		//System.out.println(arr);
		int w =0;
		while(w<=arr.size()) { //count를 이용해서 while문 한방에 처리도 가능!!!
			if(w%2==1) {
			System.out.println(arr.get(w));
			}
			w++;
		}
		bf.close();
		this.fr.close();
		
	}
}




