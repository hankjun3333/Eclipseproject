package web;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
		Part bfile = request.getPart("bfile_nm"); //파일은 Part로 받아야 함!	
		//System.out.println(bfile_nm.getSubmittedFileName()); // 파일명
		String filenm = bfile.getSubmittedFileName(); //file은 part로 받아야 하고 변환 한번하고 String으로 받아줘야함!
		
		
		//날짜 -- file 업로드시 같은 이름일경우 덮어쓰기가 되버리기 때문에 그 현상을 막기 위해서 사용
		Date time = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timetext = sf.format(time);
		
		//첨부파일 용량을 확인해야함
		int filesize = (int) bfile.getSize();
				
		/*첨부 파일 있는 경우 부터 실행시키면됨*/
		//첨부파일 저장공간
		String savepath = request.getServletContext().getRealPath("/board/upload/");
		//업로드 시 사용하는 파일명 /*중복 안되게 시간을 넣어서 처리한다!! --매우중요한 백엔드의 역량!*/
		String filename = timetext + "_" + bfile.getSubmittedFileName();
		//실제 저장되는 형태 (필수 -최종 저장하는 형태)
		String uploadfile = savepath + filename;
		//[Stream 으로 첨부파일 처리]
		InputStream is = bfile.getInputStream(); //Stream 으로 변환
		FileOutputStream fs = new FileOutputStream(uploadfile); //스트림 -> 바이너리 -> 바이트 단위!
		
		/*이름 중복되지 않아야 함! (이름이 같으면 덮어 씌워져버림)*/
		/*가장많이 쓰는방ㅂ버은 날짜랑 같이 저장시킴 */
		 if(filenm.intern() == "") {
			 //System.out.println("첨부파일 없음");
		 }
		 else {
			 //System.out.println("첨부파일이 있음!");
			 byte[] buf = new byte[is.available()];
			 int size = 0;
			 while((size = is.read(buf)) != -1) {
				 fs.write(buf,0,size); /*버퍼 때 플러쉬 쓰면됨*/ //fs.flush();
				 
			 }
			 fs.close();
			 is.close();
		 }
		//경로 지정 DB에 저장되는 경로임!
		 String dbfile = "./upload/" + filename ;
		 
		//view 로 출력 -> view.jsp로 전달!
		request.setAttribute("dbfile", dbfile);
		RequestDispatcher ds = request.getRequestDispatcher("./view.jsp");
		ds.forward(request, response);
		
		String btext = request.getParameter("btext").intern();
		if(bfile.getSubmittedFileName().intern() == "") {
			
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
						+ "'0',?,?,?,?,?,1,now())";
				this.ps=con.prepareStatement(sql);
				this.ps.setString(1, btitle);
				this.ps.setString(2, buser);
				this.ps.setString(3, bpw);
				this.ps.setString(4, filenm);
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
