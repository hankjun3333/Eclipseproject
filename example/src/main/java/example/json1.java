package example;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/*
 json1.java에서 원시 배열값을 json으로 변환 후 Front가 해당 데이터를
 ajax로 로드하여 웹 페이지에 출력하는 형태! 
  
  
 */
public class json1 {

	public static void main(String[] args) throws Exception{
		/*json만들기 - 라이브러리가 필요 ! Maven repository -> json-simple*/
		
		JSONObject jo = new JSONObject(); // put 만 사용, 키를 생성!!
		JSONArray ja = new JSONArray(); //add만 사용가능 -> key 생성 X
		//데이터 생성
		int user[] = {2600, 3200, 1900}; //숫자형태 배열
		int w = 0;
		while(w<user.length) {
			//System.out.println(user[w]);
			//ja.add(user[w]); /*키가 없는 형태의 배열*/
			//키 생성시 반복문으로 작동하면 객체 및 인스턴스를 새롭게 생성하면서 적용해야합니다
			JSONObject jo2 = new JSONObject(); 
			/* 내부에 있는 키 생성후 -> 대표키 생성 */
			jo2.put("product"+w, user[w]); //("키 이름",데이터 값)
			ja.add(jo2); //[]배열화 적용
			w++;
		}
		jo.put("adata", ja); //JSONObject를 통해서 대표키를 생성하는 형태!
		
		//System.out.println(jo);
		FileWriter fw = new FileWriter("D:\\project\\example\\src\\main\\webapp\\data.json",false);
		//fw.write("test");
		BufferedWriter bw = new BufferedWriter(fw);
		//bw.write(jo.toString()); -- 단순json 파일생성 , 배열형태를 문자열로 변환후 저장
		bw.write("ajax_data("+jo.toString()+")"); //외부에서 가져갈 수 있도록 cors해제하는방법(함수호출로적용)
		bw.flush(); //BufferedWriter는 반드시 flush 를 써야함!
		bw.close();
		fw.close();
		
	}

}
