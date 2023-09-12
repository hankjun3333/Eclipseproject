import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server2 {

	public static void main(String[] args) {
		new chat().chatserver();
	}

}
class chat{
	private int port = 8009; //서버 포트 오픈
	ServerSocket sk = null; //서버 소켓 오픈
	Socket so = null; //소켓통신
	Scanner sc = null; //메세지 입력
	InputStream is = null; //client에서 메세지를 받는 역할
	OutputStream os = null; //client로 메세지를 발송하는 역할
	String mid = null; //관리자 아이디 입력변수
	String msg = null; //메세지 입력 (서버가 입력한 메세지)
	String cmsg = null; //client가 입력한 메세지
	String check = null; //exit 확인용
	
	public void chatserver() {
		try {
			this.sk = new ServerSocket(this.port);
			this.sc = new Scanner(System.in);
			System.out.println("아이디를 생성하세요 : ");
			this.mid = sc.next();
			System.out.println("채팅방 개설 되었습니다. ");
			
			for(;;) { //접속 유지를 위한 무한루프
				this.so = this.sk.accept();
				this.is = this.so.getInputStream();
				this.os = this.so.getOutputStream();
				
				//client의 내용을 받아오는 역할
				byte[] data = new byte[1024*2];
				int n = this.is.read(data);
				this.msg = new String(data,0,n);
				System.out.println(this.msg);
				
				//메세지를 client로 보내는 역할
				this.sc = new Scanner(System.in);
				System.out.println("메세지를 입력하세요");
				this.check = this.sc.nextLine();
				
				if(this.check.equals("text")) {
					System.out.println("채팅 종료");
					this.os.close();
					this.is.close();
					this.so.close();
					this.sk.close();
				}
				else {
					this.cmsg = "["+this.mid +"] : " + this.check;
					this.os.write(this.cmsg.getBytes()); //보내기 완료!
					this.os.flush(); //메모리를 비움
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
