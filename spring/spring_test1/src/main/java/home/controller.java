package home;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	@RequestMapping("/sphome.do")
	public String member(HttpServletRequest req, Model m) {
		ArrayList<ArrayList<String>> member = null;
		try {
			member mb = new member();
			member = mb.mb_list();
			req.setAttribute("member", member);			
		}
		catch(Exception e) {
			
		}
		return "sphome";
	}
}
