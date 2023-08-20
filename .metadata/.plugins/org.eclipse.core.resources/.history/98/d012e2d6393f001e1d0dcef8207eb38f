package io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//파일 복사 및 이동
public class file12 {

	public static void main(String[] args) {
		try {
			data10 d = new data10();
			d.abc();
		} catch (Exception e) {
			System.out.println("파일 복사 및 이동 코드 오류발생");
		}

	}
}

class data10 {
	public void abc() throws Exception {
		// createDirectories() : 디렉토리 생성 메소드
		// Paths.get() : 경로를 말함
		// Files.createDirectories(Paths.get("D:\\project\\web\\src\\main\\webapp\\test2"));
		/* 파일 복사기능 */
		/* Files.copy (원본파일,사본파일경로) */
		/* Path : interface를 이용하여 경로를 확인 후 객체에 저장 */

		/* Files.copy Files.delete Files.createFile */

		
		  /*파일 복사*/ 
		Path data1 = Paths.get("D:\\project\\web\\src\\main\\webapp\\datalist.txt"); 
		Path data2 = Paths.get("D:\\project\\web\\src\\main\\webapp\\test\\datalist.txt");
		  
		Files.copy(data1, data2);
		  
	  /* 파일 삭제*/
//		Path data3 =Paths.get("D:\\project\\web\\src\\main\\webapp\\test\\datalist.txt");
//		Files.delete(data3); 
	  /*빈 파일 생성*/ 
//		  Path data4 = Paths.get("D:\\project\\web\\src\\main\\webapp\\test\\datalist.json");
//		  Files.createFile(data4);
		 

		
		  /*파일 이동*/ 
		Path data5 = Paths.get("D:\\project\\web\\src\\main\\webapp\\test\\datalist.txt");
		Path dt  = Paths.get("D:\\project\\web\\src\\main\\webapp\\test2\\datalist.txt");
		Files.move(data5,dt);
		 
	}
}
