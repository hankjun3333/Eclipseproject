package batis;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.logging.LoggerFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	//selectList 데이터 많이 들고올때 , selectOne 데이터 한개
	
	//@ModelAttribute("review") datavo datavo
	//(별명명칭임) 1개 이상 사용시 1개만 사용하면 () 안써도됨
	
	
	@RequestMapping("data_selectall.do")
	public String data_selectall(@ModelAttribute("review") datavo datavo,Model m) throws Exception{
		
		SqlSession se = sqlsessionfactory.openSession();
		//입력값없이 그냥 로드하는경우
		List<datavo> all = se.selectList("reviewDB.selectall",null); //"" 값이 있으면 이렇게 넣고 없으면 비워놓으면됨
		//se.selectOne("reviewDB.counting","") 이게 자료형이 뭔지 먼저 파악해야됨!
		m.addAttribute("all",all);
		System.out.println(all.get(4).getRname());
		System.out.println(all.get(1).getRidx());
		
		return "";
	}	
	
	
	
	
	@RequestMapping("data_select.do")
	public String data_select(@ModelAttribute("review") datavo datavo) throws Exception{
		SqlSession se = sqlsessionfactory.openSession();
		//입력값없이 그냥 로드하는경우
		datavo dv = se.selectOne("reviewDB.counting",""); //"" 값이 있으면 이렇게 넣고 없으면 비워놓으면됨
		//se.selectOne("reviewDB.counting","") 이게 자료형이 뭔지 먼저 파악해야됨!
		System.out.println(dv.getCtn());
		return null;
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
	
}
