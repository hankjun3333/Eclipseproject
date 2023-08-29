package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig( //필수 조건임 첨부 파일시! + enctype에서 myltipart/form 해줘야 됨!
	//업로드 한 파일의 크기를 측정하는 것! 단, 첨부파일 크기보다 클 경우 temp 디렉토리에 저장됨
	fileSizeThreshold = 1024 * 1024 * 1, // == 1MB
	//업로드 가능한 최대 크기 즉, 첨부파일의 갯수를 모두 합한 용량
	maxFileSize = 1024 * 1024 * 10, //10MB
	//전체 multipart의 크기를 말함
	maxRequestSize = 1024 * 1024 * 100 //100MB

)
public class board2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public board2() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String bid = request.getParameter("bid");
		String buser = request.getParameter("buser");
		String btitle = request.getParameter("btitle");
		String bpw = request.getParameter("bpw");
		String bfile_originname = request.getParameter("bfile_originname");
		String bfile_servername = request.getParameter("bfile_servername");
		String btext = request.getParameter("btext");
		String bsearch = request.getParameter("bsearch");
		Part file = request.getPart("mfile"); //파일은 Part로 받아야 함!
		System.out.println(file.getName()); //html name 속성이름
		System.out.println(file.getSize()); // 파일 용량 ==0 해서 첨부됬는지 판단해도됨! int로 받자
		System.out.println(file.getContentType()); //이걸 많이씀!
		System.out.println(file.getSubmittedFileName()); // 파일명을 출력!
		if(file.getSubmittedFileName().intern() == "") {
			System.out.println("첨부파일 없음");
		}
		else {
			System.out.println("첨부파일이 있음!");
		}
		
	}

}
