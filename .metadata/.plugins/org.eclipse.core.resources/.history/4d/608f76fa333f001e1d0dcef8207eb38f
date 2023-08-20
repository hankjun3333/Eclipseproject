package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//FileReader + BufferedReader 응용편

/*
 *응용문제 2
 *datalist.txt에 숫자가 있습니다. 해당 파일을 읽어 들여서 해당 숫자 중
 *짝수 값만 모두 출력 되도록 하시오.
 * */
public class file8 {
	
	public static void main(String[] args) {
		try {
			new data6().abc();
		}
		catch(Exception e){
			System.out.println("파일 오류발생");
		}
		

	}
	

}
class data6{
	FileReader fr =null;
	BufferedReader bf = null; 
	
	public void abc() throws Exception{
		//FileReader가 있어야 버퍼 리더를 쓸 수가 있음
		this.fr = new FileReader("D:\\project\\web\\src\\main\\webapp\\datalist.txt");
		
		BufferedReader bf = new BufferedReader(this.fr);
		ArrayList<String> ar = new ArrayList<String>();
		String line = "";
		while((line = bf.readLine())!=null) {
			if(Integer.parseInt(line)%2==0) {
				ar.add(line);
			}
			
		}
		System.out.println(ar);
		this.bf.close();
		this.fr.close();
	}
}

