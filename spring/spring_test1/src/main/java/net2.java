import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class net2 {
	//네트워크 기초 외부 이미지 및 동영상 크롤링!
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("웹에서 가져올 이미지 주소를 입력하세요 : ");
		String url = sc.nextLine();
		
		URL u = new URL(url); //URL(클래스) : 네트워크 경로를 말함!
		URLConnection con = u.openConnection(); //해당 경로를 연결!
		
		//-1이나오는건 보안상 막아놓은 것임! (연결하지 못함)
		int imgsize = con.getContentLength(); // indexOf 기능과 같음
		String imgtype = con.getContentType(); //파일 형식 jpeg 라던지
		long date = con.getDate(); //파일 업로드 날자
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//날짜 변환!
		String day = sdf.format(date);
		System.out.println(day);
		//해당 영상이나 이미지를 Stream을 이용해서 가져옴
		InputStream is = u.openStream();
		BufferedInputStream bi = new BufferedInputStream(is);
		//파일로 저~장~!
		byte[] data = new byte[bi.available()];
		FileOutputStream fo = new FileOutputStream("123.jpg"); 
		int imgdata = 0;
		while((imgdata=bi.read(data)) !=-1 ) {
			fo.write(data,0,imgdata);
			
		}
		fo.flush();
		fo.close();
		bi.close();
		is.close();
		System.out.println("해당 정보 다운로드 완료");
		
		
	}

}
