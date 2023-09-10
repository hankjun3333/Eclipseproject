package home;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	@GetMapping("/sphome.do")
	public String member(HttpServletRequest req, Model m) {
		ArrayList<ArrayList<String>> member2 = null;
		String search = req.getParameter("search");
		String part = req.getParameter("part");
		try {
			if(search == null || search == "" || search=="null") {
				member mb = new member();
				member2 = mb.mb_list();
			}
			else{
				member mb = new member();
				member2 = mb.mb_list(search,part);
			}
			req.setAttribute("member", member2);
			req.setAttribute("part", part);
			
						
		}
		catch(Exception e) {
			
		}
		return "/WEB-INF/jsp/sphome";
	}

}
