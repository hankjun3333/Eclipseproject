package sp1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller2 {
	@RequestMapping("sp1ok.do")
	public String member(HttpServletRequest req, Model m) {
		
		
		return null;
	}
}
