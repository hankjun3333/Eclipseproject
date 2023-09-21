package batis;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//
@Controller
public class webpage {
	
	@Autowired //xml에 등록된 bean에 대한 id 값을 가져올 때 사용하는 어노테이션 클래스
	BasicDataSource datasource;
	//xml에 아이디에 이름을 로드하여 해당 sql 정보를 class에 전달하게 됩니다.
	//@ModelAttribute :parameter 메소드 형태를 구성하게 됨 vo나 dto형태로 구성이 원칙임
	//해당 name 값을 vo 나 dto에 동일하게 셋팅을 하면 database 필드명과 도 동일할 경우
	//요청한 값을 모두 db에 저장시킬 수 있습니다.
	
	@Inject // xml에 대한 데이터를 가져올때 사용하는 의존성 주입!
	private SqlSessionFactory sqlsessionfactory;
	@Resource // @Autowired의 확장판
	private SqlSessionTemplate sqlsession;
	
	//해당 페이지에 데이터 갯수가 출력 되도록 mybatis 사용하시오
	
	//selectList 데이터를 범위 안에서 모두 가져올때! 
	//selectOne 데이터 한개asd

	/*리뷰 수정완료페이지*/
	@PostMapping("data_modify.do")
	public void modifyok(@ModelAttribute("review") datavo datavo){
		PrintWriter pw = null;
		try {
			
			SqlSession se2 = sqlsessionfactory.openSession();
			
			//값을 두개를 보내야 하니 datavo로 보내서 거기서 처리해야하므로 매핑에서 #{rtext}동일하게사용!
			int result = se2.update("reviewDB.review_update",datavo);
			System.out.println(result);
			
			if(result>0) {
			pw.write("<script>"
					+ "alert('정상수정됨');"
					+ "location.href='./review_list.do';"
					+ "</script>");	
				System.out.println("정상 수정됨");
			}
			else {
				System.out.println("문법오류임");
			}
			se2.close();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}
	/*리뷰 수정전페이지*/
	@RequestMapping("review_modify.do")
	public String review_view(HttpServletRequest req, Model m, @RequestParam(required=false)String ridx) {
		SqlSession se = null;
		try {
			se = sqlsessionfactory.openSession();
			datavo vo = se.selectOne("reviewDB.selectone",ridx);
			ArrayList<String> onedata = new ArrayList<String>();
			onedata.add(vo.getRidx());
			onedata.add(vo.getRname());
			onedata.add(vo.getRpass());
			onedata.add(vo.getRtext());
			onedata.add(vo.getRindate());
			m.addAttribute("one",onedata);
			se.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			se.close();
		}
		return "/WEB-INF/jsp/review_view";
	}
	
	//리뷰 삭제!
	@RequestMapping("review_delete.do")
	public String review_del(HttpServletResponse res , @RequestParam(required=false)String ridx) {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = null;
		try {
			pw = res.getWriter();
			SqlSession se = sqlsessionfactory.openSession();
			int a = se.delete("reviewDB.review_delete",ridx);
			if(a>0) {
				pw.write("<script>"
						+ "alert('정상적으로 삭제 완료됨');"
						+ "location.href='./review_list.do';"
						+ "</script>");
			}
			else {
				pw.write("<script>alert('잘못된 접근임');"
						+ "history.go(-1);"
						+ "</script>");
			}
			System.out.println(a);
			
			se.close();
		}
		catch(Exception e) {
			System.out.println("올바른 접근 방식 아님");
		}
		
		
		return null;
	}	
	//리뷰 리스트 출력
	//defaultValue 는 숫자 형태의 자료형 일 때 사용
	@RequestMapping("review_list.do") //model을 안쓰겟다
	/* return이 없는 상황에선 res를 활용 */ //void이기떄문에 return못해줌
	public void review_list(@RequestParam(required = false)String search, @RequestParam(defaultValue = "0") int ridx, HttpServletRequest req, HttpServletResponse res){
		List<datavo> data = null;
		try {
			SqlSession se = sqlsessionfactory.openSession();
			
			String ct = se.selectOne("reviewDB.counting");
			
			if(ridx<2) {
				ridx=0;
			}
			else {
				ridx = (ridx*2)-2;
			}
			if(search ==null || search =="null" || search =="") {
				data = se.selectList("reviewDB.selectall",ridx);
				
				
			}
			else {
				data = se.selectList("reviewDB.selectsearch",search);
				
			}
			req.setAttribute("ct", ct);
			req.setAttribute("data", data);
			req.setAttribute("search", search);
			//System.out.println(data.get(2).getRname());
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/review_list.jsp");
			dispatcher.forward(req, res);
			
		}
		catch(Exception e) {
			System.out.println("db접속 오류발생");
			System.out.println(e);
		}
		finally {
			if(ridx<2) {
				ridx =1;
			}
		}
		
	}
	
	//@ModelAttribute("review") datavo datavo
	//(별명명칭임) 1개 이상 사용시 1개만 사용하면 () 안써도됨
	@RequestMapping("data_select.do")
	public String data_select(@ModelAttribute("review") datavo datavo) throws Exception{
		SqlSession se = sqlsessionfactory.openSession();
		//입력값없이 그냥 로드하는경우
		datavo dv = se.selectOne("reviewDB.counting",""); //"" 값이 있으면 이렇게 넣고 없으면 비워놓으면됨
		//se.selectOne("reviewDB.counting","") 이게 자료형이 뭔지 먼저 파악해야됨!
		System.out.println(dv.getCtn());
		se.close();
		return "";
	}
	
	@RequestMapping("data_insert.do")
	public String data_insert(@ModelAttribute("review") datavo datavo)  throws Exception{
		
		SqlSession se = sqlsessionfactory.openSession();
		
		int a = se.insert("reviewDB.review_insert",datavo);
		
		if(a > 0) {
			System.out.println("정상적으로 리뷰가 등록되었습니다.");
			
		}
		else {
			System.out.println("sql 문법오류");
		}
		se.close();
		return "/WEB-INF/jsp/login";
	}
	
	
	
	@RequestMapping("login.do")
	public String logins() { //BasicDataSource
		try {
			Connection con = datasource.getConnection();
			String sql = "select count(*)as cnt from air_reserve";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String result = rs.getString("cnt");
			System.out.println(result);
			con.close();
			rs.close();
			ps.close();
		}
		catch(Exception e) {
			System.out.println("db접속 오류");
		}
		return "/WEB-INF/jsp/login";
	}
	
	/*연습하는부분임--------------------------------------------*/
	
	@GetMapping("review_use.do")
	public String review_use(@ModelAttribute("review") datavo datavo) {
		
		SqlSession se = sqlsessionfactory.openSession();
		System.out.println(se);
		try {
		
		int a = se.update("reviewDB.review_use2",datavo);
		System.out.println(a);
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		se.close();
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	/*연습하는부분임--------------------------------------------*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
