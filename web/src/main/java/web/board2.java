package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 1,
	maxFileSize = 1024 * 1024 * 10,
	maxRequestSize = 1024 * 1024 * 100 
)
public class board2 extends HttpServlet {

	PreparedStatement ps = null;
	private static final long serialVersionUID = 1L;

    public board2() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String btitle = request.getParameter("btitle").intern();
		String buser = request.getParameter("buser").intern();
		String bpw = request.getParameter("bpw").intern();
		//String bfile_nm = request.getParameter("bfile_nm").intern();
		Part bfile_nm = request.getPart("bfile_nm"); //파일은 Part로 받아야 함!	
		//System.out.println(bfile_nm.getSubmittedFileName());
		String filename = bfile_nm.getSubmittedFileName(); //file은 part로 받아야 하고 변환 한번하고 String으로 받아줘야함!
		String btext = request.getParameter("btext").intern();
		if(bfile_nm.getSubmittedFileName().intern() == "") {
			
				System.out.println("첨부파일 없음");
		} 
		else {
				System.out.println("첨부파일이 있음!");
		}
		PrintWriter pw = response.getWriter();
		if(btitle ==""||buser == ""|| bpw=="" ||btext=="") {
			pw.write("<script>"
					+ "alert('올바른 정보가 전달되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		else {
			try {
				
				dbconfig db = new dbconfig();
				Connection con = db.info();
				
				String sql = "insert into board values("
						+ "'0','kingid',?,?,?,?,?,1,now())";
				this.ps=con.prepareStatement(sql);
				this.ps.setString(1, btitle);
				this.ps.setString(2, buser);
				this.ps.setString(3, bpw);
				this.ps.setString(4, filename);
				this.ps.setString(5, btext);
				
				int oksign = this.ps.executeUpdate();
				String msg = "";
				if(oksign >0) {
					msg = "db저장 완료";
				}
				else {
					msg= "db 저장실패";
				}
				pw.write("<script>"
						+ "location.href='./list.html';"
						+ "</script>");
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		/*
		 * Part file = request.getPart("mfile"); //파일은 Part로 받아야 함!
		 * System.out.println(file.getName()); //html name 속성이름
		 * System.out.println(file.getSize()); // 파일 용량 ==0 해서 첨부됬는지 판단해도됨! int로 받자
		 * System.out.println(file.getContentType()); //이걸 많이씀!
		 * System.out.println(file.getSubmittedFileName()); // 파일명을 출력!
		 * if(file.getSubmittedFileName().intern() == "") {
		 * System.out.println("첨부파일 없음"); } else { System.out.println("첨부파일이 있음!"); }
		 */
		
	}

}