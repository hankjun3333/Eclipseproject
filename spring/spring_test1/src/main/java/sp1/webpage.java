package sp1;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //인터페이스를 해당 클래스 안에 있는 모든 메소드에 적용하는 것!
public class webpage {
	//로그인
	//RequestMapping : 가상 파일명 GET,POST 모두 사용 (service)
	//GetMapping : GET 전송
	//POSTMApping : POST 전송
	//PutMapping : Database - insert랑 같은 것 -ajax전용
	//PatchMapping :database 에서 update 전용 ajax 전용 
	//DeleteMapping : db에서 삭제 전용 (ajax)
	
	ModelAndView mv = null;
	/*void로 만들면 view 로 쏴줄수 없다!*/
	//Controller에서는 전부다 return 메소드로 맵핑을떄려벌인다!
	/*
	 ModelAndView (구식= Controller를 interface로 사용) 
	 vs Model (신식- String 형태로 변환 ,addAttribute 사용) :
	 Model : 어노테이션을 사용하여 적용한다는 뜻 + 데이터를 담기 위한것
	 View 에서 Model에 담겨진 데이터를 자동으로 바인딩 해준다는 것 (화면출력) ${}형태로
	  
	 * 
	 ModelAndView : return 시 jsp는 같은 이름으로 처리를 해야함! login.jsp = login.do
	 setViewName 을 사용하지 않을경우 webpage.xml 의 prefix 에 해당 view 경로를 적어줘야함 
	 (보안 상 jsp 강제 입력이 되지 않습니다.) 
	  setViewName을 사용 시 - 웹 webpage.xml에 prefix는 / 로 처리를 하고
	  해당 괄호 안에 view 경로를 필수로 적어줘야함 
	 */
	@PostMapping("/login.do")
	public ModelAndView loginok(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("test");
		String mid = req.getParameter("mid");
		String mpass = req.getParameter("mpass");
		this.mv = new ModelAndView();
		mv.addObject("userid",mid);
		mv.addObject("userpw",mpass);
		return mv;
	}
	
	//상품 검색 (문자 자료형으로 return 사용 하여 해당 페이지로 view를 출력!!)
	@GetMapping("/search.do")
	public String search(HttpServletRequest req, HttpServletResponse res, Model m) {
		//System.out.println("로그아웃 페이지");
		String sh = req.getParameter("product");
		m.addAttribute("word",sh);
		
		return "/WEB-INF/viewpage/product";
	}
	
	/*리스폰스를 사용시 해당 view를 찾지 못하는 상황 발생함*/
	//아이디 및 패스워드 찾기 
	//-- void 형태! response를 뺴야 함!-단점은?
	//void 는 response를 절대 쓰면안됨!
	@PostMapping("/idsearch.do")
	public void joinok(Model m,HttpServletRequest req){
		String names = req.getParameter("person");
		//System.out.println(names);
		m.addAttribute("user",names);
		System.out.println(m.getAttribute("user"));
	}
}
