import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

public static void main(String[] args) {
		
		int  port = 8009;   //TCP, UDP 포트 번호
		ServerSocket ss = null; //서버 소켓은 TCP로 통신을 하겟단 소리임
		Socket sc = null; //소켓통신으로 접속 허용
		Scanner sn = null; 
		try {
			//TCP 
			ss = new ServerSocket(port); //해당 포트를 오픈  
			System.out.println("서버오픈");	
			sn=new Scanner(System.in);
			System.out.println("환영합니다");
			System.out.println("채팅서버 오픈");
			while(true) {
				
				sc = ss.accept(); //접속 허용을 해줌(반복문으로 접속 계속 유지!)
				/*값을 받아서 처리 - client 에서! server쪽으로 */
				InputStream is = sc.getInputStream();
				/*값을 보내는 처리 - server 쪽에서 client 쪽으로*/
				OutputStream os = sc.getOutputStream();
				//byte 형태로 받아야 함! 스트림이니까
				byte[] data = new byte[1024];
				int n =is.read(data); // 읽어 들여서 출력 //client 단어를 읽음!
				String message = new String(data,0,n); //byte를 문자로 변환!
				System.out.println(message); //해당 서버에 출력!
				
				sn=new Scanner(System.in);
				System.out.println("관리자 Message : "); //서버에서 클라이언트로 발송하는형태
				String msg = "관리자 :" + sn.nextLine();
				os.write(msg.getBytes()); //바이트 단위로 전송!
				os.flush(); //메모리를 비워줘야됨!
			}
		}catch(Exception e) {
			System.out.println("Server Open error");
		}
	}

}
