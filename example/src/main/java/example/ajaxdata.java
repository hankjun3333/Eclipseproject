package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/ajaxdata.do")
public class ajaxdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
    public ajaxdata() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		this.pw = response.getWriter();
		try {
			String key = request.getParameter("key").intern();
			if(key == null || key == "") {
				this.pw.write("key_error");
			}
			else if (key == "a123456") {
				//대표키 : user_list
				//이름 : user_name
				//성격 : analyze
				
				String user[][] = {
						{"김승균","박병준","이경선","장진호","최현제"},
						{"INFP","ENIP","EJNP","INTP","ENJP"}
				};
				JSONObject jo = new JSONObject();
				JSONArray ja = new JSONArray();
				
				int w = 0;
				do {
					int ww = 0;
					JSONObject jo2 = new JSONObject();
					while(ww<user.length) { //2
						System.out.println(user[ww][w]);
						if(ww==0) {
							jo2.put("user_name", user[ww][w]);
						}
						else if(ww==1) {
							jo2.put("analize", user[ww][w]);
						}
						ww++;
					}
					ja.add(jo2);
					
					w++;
				}while(w<user[0].length); //5
				
				jo.put("user_list", ja);
				System.out.println(jo);
				this.pw.write(jo.toString()); //데이터 출력 및 Front 전달
				this.pw.close();
				
			}
		}
		catch(NullPointerException n) {
			this.pw.write("error");
		}
		catch(Exception e) {
			
		}
	}

}