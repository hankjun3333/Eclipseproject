package example_home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class example_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public example_login() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		System.out.printf("%s %s",id,pw);
	}

}
