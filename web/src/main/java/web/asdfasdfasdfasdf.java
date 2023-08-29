package practicehome;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
      fileSizeThreshold = 1024 * 1024 * 1,
      maxFileSize =  1024 * 1024 * 10,
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
      
      String title = request.getParameter("btitle").intern();
      String writer = request.getParameter("bwriter").intern();
      String pw = request.getParameter("bpw").intern();
      Part file = request.getPart("file");
      String content = request.getParameter("bcontent").intern();
      
      String filenm = file.getSubmittedFileName().intern();
      
      PrintWriter pw2 = response.getWriter();
      
      if(title ==""||writer==""||pw==""||content=="") {
         pw2.write("<script>"
               + "alert('모든 항목을 제데로입력해주세요.');"
               + "history.go(-1);"
               + "</script>");
      }else {
         try {
            dbconfig db = new dbconfig();
            Connection con = db.info();
            
            String sql = "insert into board values("
                  + "'0',?,?,?,?,?,now(),0);";
            
            this.ps = con.prepareStatement(sql);
            this.ps.setString(1, title);
            this.ps.setString(2, writer);
            this.ps.setString(3, pw);
            this.ps.setString(4, filenm);
            this.ps.setString(5, content);
            
            int oksign = this.ps.executeUpdate();
            
            String msg = "";
            
            if(oksign > 0) {
               msg = "디비 저장 성공!";
            }
            else {
               msg ="DB 저장 실패,,,,";
               System.out.println("sql 쿼리 오류인듯");
            }
            pw2.write("<script>"
                  + "alert('"+msg+"');"
                        + "location.href='./list.html';"
                        + "</script>");
         }
         catch(Exception e) {
            System.out.println("db error ㅠㅠㅠ");
            System.out.println(e);
            
         }
      }
   }

}