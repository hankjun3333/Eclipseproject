package io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//파일 복사 및 이동
public class file12 {

	public static void main(String[] args) {
		try {
			data10 d = new data10();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
class data10{
	public void abc() throws Exception{
		//Files.createDirectories(Paths.get("D:\\project\\web_example\\src\\main\\webapp\\test2"));
		/*파일 복사*/
		Path data1 = Paths.get("D:\\project\\web_example\\src\\main\\webapp\\datalist.txt");
		Path data2 = Paths.get("D:\\project\\web_example\\src\\main\\webapp\\test\\datalist.txt");
		//Path data2 = Paths.get("D:\\project\\web_example\\src\\main\\webapp\\test\\datalist.txt");
		
		//Files.copy(data1, data2);
		/*파일 삭제*/
		Path data3 = Paths.get("D:\\project\\web_example\\src\\main\\webapp\\test\\datalist.txt");
		//Files.delete(data3);
		/*파일 이동*/
		Path data4 =Paths.get("D:\\project\\web_example\\src\\main\\webapp\\test\\datalist.txt");
		Path directory =Paths.get("D:\\project\\web_example\\src\\main\\webapp\\test2\\datalist.txt");
		Files.move(data4, directory);
	}
}
