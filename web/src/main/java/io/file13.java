package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

//이미지 파일 처리하는 방법 -- stream써야됨
public class file13 {

	public static void main(String[] args) {
		try {
			data11 dt = new data11();
			dt.abc();
		}
		catch(Exception e) {
			System.out.println("");
		}

	}

}
class data11{
	public void abc() throws Exception{
		InputStream is = new FileInputStream("D:\\project\\web\\src\\main\\webapp\\image.jpg");
		System.out.println(is.available());
		
		
		  byte[] file = new byte[is.available()];
		  is.read();
		
		
		//OutputStream os = new FileOutputStream("dog2.jpg"); //경로 안잡으면 root web경로로 가버림
		OutputStream os = new FileOutputStream("dog2.jpg"); //경로 안잡으면 root web경로로 가버림
		//os.write(file); //생성됨
		
		/*다운로드 수치 1,2,3~~80퍼 이런거 만들때 */
		//%로 확인
		byte[] file2 = new byte[is.available()/100]; //한번에 읽어 들일수 있는 크기
		
		/*복사율을 표시하면서 progress-bar를 만들때 사용하여 보여줄 때 */
		int img = 0; //읽어 들이는 byte 수
		int check = 0; //읽은 횟수
		while(true) {
			img = is.read(file); //읽어들일수 있는 용량 만큼 읽는것
			if(img == -1) { //더이상 byte가 없을 경우 정지!
				break;
			}
			else {
				if(check < 80) { //80%밑으로만 복사 하는 것
					os.write(file,0,img);
				}
				else { //80% 이상인 경우는 정지 이미지 짤리는 것을 확인 가능함
					break;
				}
			}
			check++;
			if(check %2 ==0) { //진행율을 표시하는 기능
				System.out.println(check + "%");
			}
		}
		os.close();
		os.flush();
		is.close();
	}
}