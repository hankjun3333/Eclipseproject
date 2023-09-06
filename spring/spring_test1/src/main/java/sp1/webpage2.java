package sp1;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class webpage2 {
	PrintWriter pw = null;
	@PostMapping("/spring1ok.do")
	//spring1.html 에 넘어온 값을 view를 통해서 핸들링하는 방법!
	public String product(HttpServletRequest req, HttpServletResponse res, Model m) throws org.springframework.web.HttpRequestMethodNotSupportedException {
		String pdcode ="";
		String pdname ="";
		/* spring1ok.do 강제 접속시 */
		try {
			if(pdcode=="" || pdname=="") {
				pdcode = req.getParameter("pdcode").intern();
				pdname = req.getParameter("pdname").intern();
				m.addAttribute("code",pdcode);
				m.addAttribute("name",pdname);
			
			}
			
		}
		catch(Exception e) {
			System.out.println("파라미터 오류발생");
		}
		
		return "/WEB-INF/jsp/spring1ok";
	}
	@PostMapping("/spring2ok.do")
	public String agree(HttpServletRequest req ,Model m) { //response 없는건 따로 찍을게 없으니 없어도됨
		//input 타입에서 text이런거 말고 checkbox , radio 에서는 intern() 떄리면 nullpointException 절대 intern쓰면안됨!
		//checkbox에서 받을땐 주의하자 intern떄리면안됨
		String ag = req.getParameter("mail"); /*체크박스는 인턴을 빼야 예외처리 없이 진행가능함*/
		if(ag==null) {
			ag = "N";
			//System.out.println(ag);
		}
		
		String ad = req.getParameter("ad").intern(); /* 라디오버튼 얘는 인턴 써야됨 안쓰면 전부 동의함으로 나옴*/
		if(ad=="N") {
			System.out.println("동의안함");
		}
		else {
			System.out.println("동의함");
		}
		return null; //jsp 만들면됨
	}
	@PostMapping("/spring3ok.do")
	public String user(HttpServletRequest req ,Model m) {
		String mid = req.getParameter("mid");
		String mname = req.getParameter("mname");
		userdata ud = new userdata(mid, mname);
		System.out.println(ud.getMid()); //즉시 실행을 이용하여 게터 메소드 사용!! //세터는 파라미터 늘려서 한방에 this로 받는다!
		System.out.println(ud.getMname());
		return null;
	}
	/*실제 메일서비스 사용할 거임 - naver.com 메일 서버 */
	@PostMapping("/spring4ok.do")
	public String mail(HttpServletRequest req, Model m) {
		String uname = req.getParameter("uname");
		String umail = req.getParameter("umail");
		String utitle = req.getParameter("utitle");
		String utext = req.getParameter("utext");
		
		/*실제 메일 API 서버 정보!*/
		String host = "smtp.naver.com";
		String user = "hankjun3333@naver.com";
		String password = "";
		String to_mail = "hankjun3333@naver.com";
		
		/*API 포트 번호 및 TLS 정보를 셋팅!*/
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.port", 587);
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		//SMTP 서버에 로그인을 시키기 위한 작업! (암호화해야함)
		Session session = Session.getDefaultInstance(props,new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(user, password);
			}
			
		});
		try {
			/*MimeMessage : okcall 발생하고 id랑 pw , 포트가 모두 맞을경우 okcall sign 뜸*/
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(umail,uname));//사용자명(보낸이)
			//받는메일주소!
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to_mail)); //회신메일
			msg.setSubject(utitle); //제목
			msg.setText(utext); //내용
			Transport.send(msg); // 발송!
			System.out.println("메일 발송이 정상적으로 되었음!");
			/*IO 이용해서 첨부파일도 가능함!*/
		}
		catch(Exception e) {
			System.out.println("메일 서버 통신 오류");
		}
		
		return null;
	}
}



