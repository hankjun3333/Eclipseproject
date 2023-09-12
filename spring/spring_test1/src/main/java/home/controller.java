package home;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
			System.out.println(member2);
			req.setAttribute("member", member2);
			req.setAttribute("part", part);
			
						
		}
		catch(Exception e) {
			
		}
		return "/WEB-INF/jsp/sphome";
	}
	@GetMapping("/sphome_delete.do")
	public String mb_delete(HttpServletRequest req , HttpServletResponse res) {
		PrintWriter pw = null;
		res.setContentType("text/html;charset=utf-8");
		
		try {
			pw = res.getWriter();
			String no = req.getParameter("idx");
			mb_delete md = new mb_delete();
			int result = md.delete_ok(no);
			if(result==1) {
				pw.write("<script>"
						+ "alert('삭제가 잘되었음');"
						+ "location.href='./sphome.do';"
						+ "</script>");
			}
			else {
				pw.write("<script>"
						+ "alert('삭제가 잘못되었음');"
						+ "location.href='./sphome.do';"
						+ "</script>");
			}
		}
		catch(Exception e) {
			pw.write("<script>"
					+ "alert('정상접근이 아님');"
					+ "history.go(-1);"
					+ "</script>");
		}
		
		return null;
	}
	@GetMapping("/sphome_modify.do")
	public String mb_modify(HttpServletRequest req, Model m) {
		String no = req.getParameter("idx");
		ArrayList<String> arr = new ArrayList<String>();
		try {
			mb_modify mb2 = new mb_modify();
			arr = mb2.mb_modify(no);
			m.addAttribute("list",arr);
		}
		catch(Exception e) {
			
		}
		return "/WEB-INF/jsp/sphome_modify";
	}
	@PostMapping("/sphome_modifyok.do")
	public String mb_modifyok(HttpServletRequest req, HttpServletResponse res) {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = null;
		String midx = req.getParameter("midx");
		String mid = req.getParameter("mid");
		String memail = req.getParameter("memail");
		String mtel = req.getParameter("mtel");
		String mage = req.getParameter("mage");
		
			modifyok mo = new modifyok();
			int result = mo.modify_ok(mid, memail, mtel, mage,midx);
			String msg = "";
			if(result==1) {
				msg = "<script>"
						+ "alert('정상적으로 수정됨');"
						+ "location.href='./sphome.do';"
						+ "</script>";
			}
			else {
				msg = "<script>"
						+ "alert('수정이 안됨');"
						+ "history.go(-1);"
						+ "</script>";
			}
			
			try {
				pw = res.getWriter();
				pw.write(msg);
			
		}
		catch(Exception e) {
			pw.write("<script>"
					+ "alert('잘못된 접근');"
					+ "history.go(-1);"
					+ "</script>");
		}
		
		return null;
	}
	

}
