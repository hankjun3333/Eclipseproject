import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client2 {

	public static void main(String[] args) {
		new client_chat().chat();

	}

}

class client_chat{
	private final String ip = "192.168.110.223"; //서버 ip
	final int port = 8009;
	Scanner sc = null; //메세지 입력
	Socket sk = null; //소켓 통신
	InputStream is = null; //서버에서 받아오는 역할(메세지를)
	OutputStream os = null; //서버로 보내는 역할(메세지를)
	String msg = null; //메세지 내용(Scanner 에서 입력한)
	String mid = null; //접속 아이디!
	String smsg = null; //서버에 메세지를 담는 변수
	String check = null; // exit활용하기 위한 것
	
	public void chat() {
		try {
			this.sc = new Scanner(System.in);
			System.out.println("아이디를 생성해 주세요");
			this.mid = this.sc.next();
			int ck = 0;
			
			while(true) { //접속 유지를 위한 반복문!
				this.sk = new Socket(this.ip,this.port);
				this.is = this.sk.getInputStream();
				this.os = this.sk.getOutputStream();
				if(ck==0) { //최초 서버에 입장 ,접속시 출력하는 부분
					this.msg = "["+this.mid+ "] : 님 입장하셨습니다." ;
				}
				else { // 사용자가 입력하는 메세지
					this.sc = new Scanner(System.in);
					System.out.println("메세지 내용을 입력해 주세요 : ");
					this.check = this.sc.nextLine().intern();
					this.msg = "["+this.mid+ "] :"+this.check ; // 서버로 발송할 문구!
				}	
				if(this.check == "exit") { //메세지에 exit 입력시 퇴장되는 것
					this.msg = "["+this.mid+ "] : 님 퇴장하셨습니다." ;
					this.os.write(this.msg.getBytes());
					this.os.flush();
					this.os.close();
					this.is.close();
					this.sk.close();
				}
				else { //서버로 발송을 함
					this.os.write(this.msg.getBytes());
					this.os.flush(); //메모리를 비워놓음
				}
				/* 서버에서 발송한 메세지를 출력함 */
				byte[] data = new byte[1024*2];
				int n = this.is.read(data);
				this.smsg = new String(data,0,n);
				System.out.println(this.smsg);
				ck++;
			}
		}
		catch(Exception e) {
			System.out.println("서버 접속 장애 발생하여 강제종료 됨니다");
		}
	}
}








