package sp1;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webpage22 {
	@RequestMapping("test.do")
	public String test(HttpServletRequest req, HttpServletResponse res) {
		int point = 5000;
		StringBuffer sb = new StringBuffer();
		sb.append("홍길동");
		sb.append("님 환영합니다.");
		sb.append("적립금" + point +"원");
		System.out.println(sb);
		String result = sb.toString();
		System.out.println(sb.toString());
		
		return null;
	}
	@RequestMapping("/test2.do") 
	public String test2(HttpServletRequest req, HttpServletResponse res) {
		int a[][][]= {
				{
				{1,2,3,4,5},
				{6,7,8,9,10}
				}
		};
		System.out.println(Arrays.deepToString(a));
		String data1[] = {"a","b","c","d"}; //본 데이터는 건들지 않으니!
		String data2[] = data1.clone(); /*한방에 복사하는 방법임!!*/
		System.out.println(Arrays.toString(data2));
		ArrayList<String> as1 = new ArrayList();
		as1.add("aa");
		ArrayList<String> as2 = (ArrayList<String>)as1.clone();
		return null;	
	}
	//쿠키 굽는 부분
	@RequestMapping("/test3.do") 
	public String test3(HttpServletRequest req, HttpServletResponse res) {
		//cookie 쿠키 - 통신임
		/*세션과 쿠키의 차이점?*/ //-0909메모장
		Cookie data = new Cookie("product", "세탁기"); //쿠키를 굽는작업
		Cookie data2 = new Cookie("product", "컴퓨터");
		/*res 통신이 들어감 여기서*/
		res.addCookie(data);
		res.addCookie(data2);
		/*쿠키를 불러오는 부분 test4.do*/
		return null;
	}
	//쿠키 값이나 이름 가져오는 것
	@RequestMapping("/test4.do") 
	public String test4(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] ck = req.getCookies(); //cookie 배열(원시형태 배열)
		System.out.println(ck.length);
		String cookie = ck[0].getName();
		String cookie2 = ck[0].getValue();
		System.out.println(cookie2);
		return null;
	}
	//쿠키 삭제하는 방법
	@RequestMapping("/test5.do") 
	public String test5(HttpServletRequest req, HttpServletResponse res) {
		Cookie[] ck = req.getCookies(); //클라이언트에 있는 쿠키 값을 가져오는 역할
		ck[0].setMaxAge(0); //쿠키 유효기간을 만료시켜버림 둘다 써줘야된다!
		res.addCookie(ck[0]); //클라이언트 웹브라우저로 보내버림(지우라고!)
		/*하나를 삭제하게 되면 배열 번호가 바뀌기때문에 기존 1번이엇던게 0번이 된다!*/
		return null;
	}
	//네트워크
	//네트워크
			@RequestMapping("/test6.do")
			public String test6(HttpServletRequest req, HttpServletResponse res) {
				//IPv4, IPv6, Gateway, NetMask, socket
				try {
					InetAddress ia[] = InetAddress.getAllByName("afreecatv.com");
					for(InetAddress i : ia) {
						//System.out.println(i.getHostAddress());
					}
					InetAddress my = InetAddress.getLocalHost();
					/*
					System.out.println(my.getHostAddress());
					System.out.println(my.getHostName());
					System.out.println(my.getAddress()); //byte[]
					System.out.println(my.getLocalHost());	//pc정보 / ip 같이 출력
					*/
					//Inet4Address my2 = (Inet4Address)InetAddress.getLocalHost();
					
					//InetAddress my3 = Inet6Address.getLocalHost();
					
					String ipv6 = "fe80::5dc1:3dc1:cfdb:2032%13";
					InetAddress my3 = Inet6Address.getByName(ipv6);
					System.out.println(my3.getLocalHost());
					//System.out.println(my3);
				}
				catch(Exception e) {
					
				}
				
				return null;			
			}
	
	
	
}
