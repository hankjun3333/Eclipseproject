package web;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//파일 업로드 기능 어노테이션 써야 됨
@MultipartConfig(
		//업로드 한 파일의 크기를 측정하는 것! 단, 첨부파일 크기보다 클 경우 temp 디렉토리에 저장됨
		fileSizeThreshold = 1024 * 1024 * 1, // == 1MB
		//업로드 가능한 최대 크기 즉, 첨부파일의 갯수를 모두 합한 용량
		maxFileSize = 1024 * 1024 * 10, //10MB
		//전체 multipart의 크기를 말함
		maxRequestSize = 1024 * 1024 * 100 //100MB
)

public class file extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public file() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//웹 경로를 알아야함! 기존까지는 소스경로
		//웹전송시 콘솔에 경로 뜸 그걸 복사하셈!
		//getServletContext().getRealPath() => WEB Server의 프로젝트 경로를 말함!.
		String url = request.getServletContext().getRealPath("/upload/"); //    /upload/ 경로 잘해줘야된다 슬러쉬
		//System.out.println(url); 
		
		//Interface로 파일을 받아서 처리하도록 함!
		Part file1 = request.getPart("imgfile"); //Part 인터페이스임
		//System.out.println(file1);
		
		//파일명을 출력할 때 사용함
		String filename = file1.getSubmittedFileName();
		long filesize = file1.getSize(); //int 범위를 벗어나서 long
		String filetype = file1.getContentType(); //파일 타입 나옴
		//System.out.println(filename);
		//FileReader fr = new FileReader(file1); //현재 file1이 서버에 저장된게 아니라 아직은 사용 못함
		
		file1.write(url + filename); //라이브러리 인터페이스 쓸땐 close 안해도됨 인터페이스 안에있음 //실제 서버디렉토리에서 만들어야 됨!!!!
		
		PrintWriter pw = response.getWriter();
		pw.write("<script>alert('정상적으로 파일 업로드 되었습니다.');</script>");
		pw.close();
		
		InputStream is = new FileInputStream(url+filename);
		System.out.println(is.available());
		is.close();
	}

}
