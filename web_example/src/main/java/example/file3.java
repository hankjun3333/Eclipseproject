package example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*
숙제 : user_tel.txt 파일을 로드 후 해당 사용자에 맞게 전화번호가 등록 되도록
배열화 하여 콘솔로 출력 되도록 합니다.
단,출력된 결과가 cms_db.txt로 해당 내용이 저장되어야 합니다.
결과 : 
홍길동 (01011245564)
김유신 (01020041004) 이런식으로 split 활용하면됨!!
*/
public class file3 {

	public static void main(String[] args) {
		try {
			data3 d = new data3();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}

class data3{
	FileReader fr = null;
	BufferedReader br = null;
	public void abc() throws Exception{
		this.fr = new FileReader("D:\\project\\web_example\\src\\main\\webapp\\user_tel.txt");
		this.br = new BufferedReader(this.fr);
		ArrayList<String> arr = new ArrayList<String>(); //원시데이터 쏟을 배열
		// 홍길동(010-1124-5564)처럼 데이터 가공 후 쪼개서 다시 넣을 배열
		ArrayList<String> arr2 = new ArrayList<String>(); 
		String line = "";
		while((line=br.readLine()) != null) { //원시데이터를 배열에 담는다
			arr.add(line);
		}
		//System.out.println(arr);
		int w = 0;
		while(w<arr.size()) {
			String data[] = arr.get(w).split("[|]"); //split통해서 각각인덱스마다 분리
			//System.out.println(Arrays.toString(data));
			System.out.println(data[0]+" ("+data[1]+") "); //데이터 재 조합
			arr2.add(data[0]+" ("+data[1]+") "); //가공된 데이터 배열에 다시 담기
			w++;
		}
		//코드로 파일 생성해보자
		//Files.createFile(Paths.get( "D:\\project\\web_example\\src\\main\\webapp\\cms_db.txt"));
		//FileWriter로 출력해보자 비동기처리 true 잊지마시고
		FileWriter fw = new FileWriter("D:\\project\\web_example\\src\\main\\webapp\\cms_db.txt",true);
		//for in 배열반복문으로 인덱스 마다 분리해서 출력
		for(String name : arr2) {
			fw.write(name + "\n");
			w++;
		}
		//메모리 절감을 위한 프로세스 종료 해주시고
		fw.close(); 
		br.close();
		fr.close();
	}
}
