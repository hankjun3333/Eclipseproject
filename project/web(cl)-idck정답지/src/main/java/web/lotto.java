package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto")
public class lotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public lotto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no1 = request.getParameter("no1");
		String no2 = request.getParameter("no2");
		String no3 = request.getParameter("no3");
		String no4 = request.getParameter("no4");
		String no5 = request.getParameter("no5");
		String no6 = request.getParameter("no6");
		
		System.out.printf("%s %s %s %s %s %s",no1,no2,no3,no4,no5,no6);
	}

}
