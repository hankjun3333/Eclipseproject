
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
	
	public static void main(String[] args) {
		String ip = "192.168.110.224"; //서버의 ip
		int port = 8009; //서버의 포트!
		Socket sc = null;
		Scanner sn  =null;
		try {
			sc = new Socket(ip,port); //서버에 접속
			sn = new Scanner(System.in); 
			System.out.println("아이디 :");
			String mid = sn.next();
			InputStream is = sc.getInputStream();
			OutputStream os =sc.getOutputStream();
			os.write(mid.getBytes());
			System.out.println("서버 채팅서버 접속 완료");
			while(true) {
				sc = new Socket(ip,port); //서버 접속을 유지시킴
				InputStream is2 = sc.getInputStream();
				OutputStream os2 =sc.getOutputStream();
				
				//메세지를 Server 로 보내는 파트
				System.out.println("입력하실 내용을 적어주세요:");
				String msg = mid+"님 : "+ sn.nextLine();
				os.write(msg.getBytes());
				os.flush();
				
				//Server에서 client로 메세지를 받는 파트
				byte[] data = new byte[1024];
				int n = is.read(data);
				String smsg=new String(data,0,n);
				System.out.println(smsg);
			}
		}catch(Exception e) {
			System.out.println("Not Connection");
		}
	}
}
