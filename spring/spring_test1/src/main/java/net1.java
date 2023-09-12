import java.net.InetAddress;

public class net1 {
//네트워크 기초 자바에서 바로 사용가능!
	public static void main(String[] args) throws Exception{
		//InetAddress : IPnetworkAddress의 줄임말 
		//getByName : 접속할 도메인 주소명을 말함
		InetAddress ia = InetAddress.getByName("localhost");
		System.out.println(ia);
		
		try {
			InetAddress ia2[] = InetAddress.getAllByName("naver.com");
			System.out.println(ia2.length);
			int w = 0;
			while(w<ia2.length) {
				System.out.println(ia2[w]);
				w++;
			}
		}
		catch(Exception e) {
			
		}
	}

}
