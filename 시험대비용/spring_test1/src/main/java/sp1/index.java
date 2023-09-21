package sp1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//index url 만들거임 이게 컨트롤러가 되는거임
//implements Controller - override
public class index implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("test");
		
		String name = "홍길동"; /*이걸 뷰에 찍고 싶을때!*/
		ModelAndView mv = new ModelAndView();
		//request.setAttribute("name", name); 이건 서블릿 형태
		
		/*표현식 ${} 형태 출력 및 request.getAttribute("name") 가능*/
		mv.addObject("name",name); //mv.addObject("별명명칭",데이터값);
		System.out.println(name);
		//viewpage에 .jsp를 사용 안하는 이유는 dispatcher(나는 aaa)-servlet.xml에 이미 suffix로 셋팅하였음!
		mv.setViewName("/WEB-INF/viewpage/index"); //view 파일을 로드! /*웹경로를 잡아야됨*/
		/*aaa-servlet.xml 에서 경로 설정하면 여긴 index만 써도 되고*/
		/*aaa-servlet.xml에서 설정안했으면 여기서 경로 써줘야됨!!*/
		return mv;
	}
	
}
