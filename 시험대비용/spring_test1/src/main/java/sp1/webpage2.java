package sp1;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class webpage2 {
	PrintWriter pw = null;

	@RequestMapping("air_list.do")
	//required = false : GET,POST 해당 변수값에 값이 없을 경우 해당 요구사항을 예외처리 하게 됩니다.
	//@RequestParam(required=false) 기본은 true인데
	//page가 확인이 안되면 사용을 안하겠다 이런식으로 처리가능!!
	public String air_list(Model m ,@RequestParam(required=false) String page) {
		//System.out.println(page);
		String p = page;
		air_list al = new air_list(); //여기선 intern이 안먹는다 값을 받아야??사용가능?
		int vpage = 0; //페이지 번호 1번일때 지정!
		if(p==null || p == "null" || p.equals("1") || p == "") {
			vpage = 0;
		}
		else { //1번 페이지 외에 작동 되는 부분
			vpage =(Integer.parseInt(p) * 2)-2; //2n-2 ,3n-3 , 4n-4 2개/3개/4개씩출력
			//10개씩출력하려면 10n-10
		}
		
		try {
			//데이터 전체 리스트 view로 보내기!
			List<ArrayList<String>> total_list = al.person_list(vpage);
			m.addAttribute("total_list",total_list);
			
			//총 갯수값 view로 보내기!
			int total_person = al.total_sum("air_person");
			m.addAttribute("total_person",total_person);
			
		}
		catch(Exception e) {
			System.out.println("db문법오류");
		}
		return "/air_list";
	}
		
	//0919
	@PostMapping("/air_personok.do")
	public String air_personok(Model m,
			@RequestParam String pid,
			@RequestParam String pname,
			@RequestParam String passport,
			@RequestParam int ptel,
			@RequestParam String acode,
			@RequestParam String a_corp,
			@RequestParam int pcount,
			@RequestParam int totalprice
			) throws Exception {
		//simplify sp = new simplify();
		//a_corp = a_corp.split();
		air_list al = new air_list();
		int result = al.insert(pid, pname, passport, ptel, acode, a_corp, pcount, totalprice);
		if(result ==1) {
			System.out.println("저장잘됨");
			m.addAttribute("msg","저장이 깔끔하게 되셨군요"); 
		}
		else if(result==3){
			m.addAttribute("msg","코드를 막짰군요!");
		}
		else {
			m.addAttribute("msg","result가 0이 나왔군요");
		}
		return "/WEB-INF/viewpage/air_personok";
	}
	
	//db정보 받아서 air_person.do에 출력해줌
	@RequestMapping("/air_person.do")
	public String air_person(HttpServletRequest req) {
		
		air_list al = new air_list();
		req.setAttribute("al_list",al.select());
		return "/WEB-INF/viewpage/air_person";
	}
	
	
	
	//0918 스프링식 RequestParam
	@PostMapping("air_reserveok.do")
	public String reserve(Model m ,
			@RequestParam String acode,
			@RequestParam String a_corp,
			@RequestParam String a_contry,
			@RequestParam String a_sdate,
			@RequestParam int a_avail,
			@RequestParam int amoney,
			@RequestParam String start_day,
			@RequestParam String end_day
			) throws Exception {
		simplify sp = new simplify();
		
		/* simplify 클래스를 활용해서 return 받아서 처리! */
		a_sdate = sp.day(a_sdate);
		start_day = sp.day(start_day);
		end_day = sp.day(end_day);
		
		air_reserveok as = new air_reserveok();
		int result = as.reserve_insert(acode, a_corp, a_contry, a_sdate, a_avail, amoney, start_day, end_day);
		
		if(result == 0) {
			m.addAttribute("msg","비정상 데이터로 인하여 정보등록안됨");
		}
		else {
			m.addAttribute("msg","성공적으로 데이터 입력됨");
		}
		/*
		String acode = req.getParameter("acode");
		String a_corp = req.getParameter("a_corp");
		String a_contry = req.getParameter("a_contry");
		String a_sdate = req.getParameter("a_sdate");
		
		int a_avail = Integer.parseInt(req.getParameter("a_avail"));
		int amoney = Integer.parseInt(req.getParameter("amoney"));
		String start_day = req.getParameter("start_day");
		String end_day = req.getParameter("end_day");
		
		String a_sdate2 = a_sdate.replaceAll("T", " ");
		String start_day2 = start_day.replaceAll("T", " ");
		String end_day2 =end_day.replaceAll("T", " ");
		air_reserveok re = new air_reserveok();
		int result = re.reserve_insert(acode, a_corp, a_contry, a_sdate2,a_avail, amoney, start_day2, end_day2);
		if(result > 0) {
			System.out.println("저장됨");
		}
		else {
			System.out.println("저장안됨!");
		}
		*/
		
		return "/WEB-INF/viewpage/air_reserveok";
	}
	
	
	//0914 로그인 api
	@PostMapping("kakao_loginok.do")
	public String kakaos(HttpServletRequest req, Model m) throws Exception{ //thread쓸거기때문에
		String part = req.getParameter("part").intern();
		login_etc le = null;
		
		if(part == "kakao") {
			String kakao_id = req.getParameter("kakao_id");
			String kakao_email = req.getParameter("kakao_email");
			String kakao_nick = req.getParameter("kakao_nick");
			le =new login_etc(kakao_id,kakao_email,kakao_nick,part); // 즉시실행하자마자 쓰레드 run을 돌릴거임 여기서 핸들링을 할거임
			
		}
		else {
			String mname = req.getParameter("mname");
			String mpass = req.getParameter("mpass");
			le =new login_etc(mname,mpass,"",part); 
		}
		le.join(); //Thread 작업이 끝날때 까지 아래 코드를 활성화 하지않음
		
		int result =le.result();
		if(result ==1) {
			System.out.println("정상가입됨");
		}
		else {
			System.out.println("프로세스 오류임");
		}
		
		return null;
	}
		
	//0912 MultipartFile mfile <view file name값이랑 맞추어야 됨 파라미터랑! >중요!
	@PostMapping("/fileok.do")
	public void upload(MultipartFile mfile,HttpServletRequest req , Model m) throws Exception{ //void라서 response 못씀 io라서 throws Exception씀
		String filename = mfile.getOriginalFilename();
		System.out.println(filename);
		long filesize = mfile.getSize();
		String url = req.getServletContext().getRealPath("/fileup/") + filename ; //웹경로파악
		
		/*파일 저장*/
		File f = new File(url); // 일반 IO
		FileCopyUtils.copy(mfile.getBytes(),f); // FileCopyUtils 스프링 전용 파일업로드 클래스 - 스트림 써도됨
		System.out.println("업로드 파일 정상적으로 진행완료!");
	}
	
	
	
	/*product 테이블 가져오기 - JSTL로 뷰페이지 출력 파트*/
	@RequestMapping("/product_list.do")
	public String pd_list(HttpServletRequest req, Model m) {
		
		try {
			//System.out.println(ct2);
			product_list pl = new product_list();
			pl.pd_data();
			req.setAttribute("product_data", pl.pd_data());
			
			int listea = pl.data_ea();
			req.setAttribute("listea", listea);
			
		}
		catch(Exception e) {
			
		}
		return "/WEB-INF/jsp/product_list";
	}
	
	/*상품 삭제파트*/
	@GetMapping("/product_delete.do")
	public void del_product(HttpServletRequest req, HttpServletResponse res) {
		PrintWriter pw = null;
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		try {
			this.pw = res.getWriter();
			String no = req.getParameter("idx");
			product_delete pd = new product_delete();
			int result = pd.delete_ok(no);
			if(result ==1) { //정상적인 sql 작동
				this.pw.write("<script>"
						+ "alert('정상적으로 삭제 되었습니다.');"
						+ "location.href='./product_list.do';"
						+ "</script>");
			}
			else { // 0 sql문법이 올바르게 작동되지 않는경우!
				this.pw.write("<script>"
						+ "alert('올바른 데이터 값이 아님');"
						+ "location.href='./product_list.do';"
						+ "</script>");				
			}
			
		}
		catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('잘못된 접근방식 입니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		
	}
	//jsp 내용을 이제 받을거임( 수정된 내용! )
	@PostMapping("product_modifyok.do")
	//페이지가 잇으면 res안써도되는데 컨트롤에서 view없는상태에서 진행하는건 res잇어야함
	public String ok_modify(HttpServletRequest req, HttpServletResponse res) {
		PrintWriter pw = null;
		res.setContentType("text/html;charset=utf-8");
		String pidx = req.getParameter("pidx");
		String pcode = req.getParameter("pcode");
		String pname = req.getParameter("pname");
		String pmoney = req.getParameter("pmoney");
		String psale = req.getParameter("psale");
		String puse = req.getParameter("puse");
		
		product_ok ok = new product_ok();
		int result = ok.modify_sql(pidx, pcode, pname, pmoney, psale, puse);
		String msg = "";
		if(result==1) { //ok사인 난거임
			msg = "<script>alert('정상적으로 수정완료됨');"
					+ "location.href='./product_list.do';"
					+ "</script>";
		}
		else {
			msg = "<script>alert('수정 내용이 올바르지않음');"
					+ "history.go(-1);"
					+ "</script>";
		}
		try {
			this.pw = res.getWriter();
			this.pw.write(msg);
		}
		catch(Exception e) {
			System.out.println("올바른 값이 전달되지않음!");
		}
		return null;
	}
	
	
	//상품 수정파트 !!! 여긴 JSTL로 할거임!
	@GetMapping("/product_modify.do")
	public String view_product(HttpServletRequest req, Model m) {
		String idx = req.getParameter("idx");
		try {
			product_modify pm  = new product_modify();
			ArrayList<String> data = pm.view_ok(idx);
			//System.out.println(data);
			m.addAttribute("data",data);
			System.out.println(data);
		}
		catch(Exception e) {
			System.out.println("잘못접근!");
		}
		
		return "/WEB-INF/jsp/product_modify";
	}
	
	
	
	
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
	//Controller 에서 배열을 JSP(뷰페이지)로 출력하는 형태!
	@GetMapping("/spring5ok.do")
	public String datalist(HttpServletRequest req , Model m) {
		try {
			
		dbconfig db = new dbconfig();
		Connection ct = db.info();
		//System.out.println(ct.toString());
		}
		catch(Exception e) {
			
		}
		
		String data[] = {"이순신","홍길동","강감찬","이산","한석봉"};
		
		ArrayList<String> al = new ArrayList<String>(Arrays.asList(data));
		//m.addAttribute("person_list",al); //현재상태는 표현식가지곤 출력이어려움
		
		/* 일반 JSP방식으로 출력하려면 */ //-- 이게 젤 구닥다리
		//req.setAttribute("person_list", al);
		//return "/WEB-INF/jsp/spring5ok"; 일반 jsp뷰
		
		/*표현식 방법으로 출력하려면*/ //--jstl 그나마 덜 구닥다리
		m.addAttribute("person_list",al);
		m.addAttribute("person_delete","10");
		/*표현식 값을 javascript로 전달(Front-end) Node형태로 출력!*/ //-- 요즘추세
		
		return "/WEB-INF/jsp/spring5_2ok"; //표현식 jsp뷰
	}
	//사용자 리스트 출력 Mysql 이용
	@RequestMapping("/spring6ok.do")
	public String userlist(HttpServletRequest req, Model m) {
		String search = req.getParameter("search");
		String tel = req.getParameter("tel");
		String part = req.getParameter("part");
		System.out.println(tel);
		List<ArrayList<String>> member_data = null;
		try {
			//System.out.println(search);
			// 단어 검색이 없을경우 기본적으로 검색이 없을경우는 조건을 이정도는 설정해주는게 좋다!
			if(search == "" || search == null || search=="null") { 
				user_list ul = new user_list();
				member_data = ul.listdata();
				//System.out.println("test");
			}
			else { //검색 단어가 있을경우
				user_list ul = new user_list();
				member_data = ul.listdata(search,part);
			}
			//JSP 형태로 view 출력
			/*회원 가입 카운팅 숫자*/
			req.setAttribute("total", new user_list().total_member());
			req.setAttribute("member_data", member_data);
			req.setAttribute("part", part); //검색 카테고리 형태 설정
			
		}
		catch(Exception e) {
			//System.out.println(e);
		}
		//return null;
		return "/WEB-INF/jsp/member_list";
	}
	
}



