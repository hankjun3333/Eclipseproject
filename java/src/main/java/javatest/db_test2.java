package javatest;

import java.sql.*;
import java.util.*;

/*
 * 모르겠으면 앞에있는 코드 보면서 연습하기!
 Java + Database 응용편! 
  게시판을 작성을 하는 프로세서를 제작합니다!
  문의 제목, 고객명 , 패스워드는 6자리 이상! 이며 , 문의 내용
  단, 패스워드는 암호화 하지 않고 제작합니다!. 패스워드 6자리 이하 입력시 db에 저장 안됩니다!
  
  
 */
public class db_test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection ct = null;
		try {
			dbconfig2 db = new dbconfig2();
			ct = db.info();
			//System.out.println(ct.toString());
			System.out.println("제목을 입력하세요");
			String a = sc.nextLine(); //제목
			System.out.println("고객명을 입력하세요");
			String b = sc.nextLine(); //고객명
			System.out.println("패스워드 6자리 이상 입력해주세요");
			String c = sc.nextLine(); //패스워드 부분
			while(c.length()<6) { //loop도 되고 재귀함수 써도 된다! 일반적으론 무한루프 씀!
				System.out.println("패스워드 6자리 이상 입력해주세요");
				c = sc.nextLine(); 
			}
			
			System.out.println("문의 내용을 입력해주세요");
			String d = sc.nextLine().intern(); //문의 내용
			
			String insert = "insert into data values('0','"+a+"','"+b+"', password("+ c +')'+",'"+d+"')";
			PreparedStatement ps = ct.prepareStatement(insert);
			int oksign = ps.executeUpdate();
			if(oksign ==1) {
				System.out.println("정상적으로 잘 저장되었습니다.");
				ps.close();
				ct.close();
				sc.close();
			}
			else {
				System.out.println("저장을 똑바로 하시오");
			}
			
		}
		catch(Exception e) {
			System.out.println("db정보 저장실패");
		}

	}

}
class dbconfig2{
	
	public static Connection info() throws Exception{
		String db_drive = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/web";
		String db_user = "hong";
		String db_pass = "a123456"; 
		Class.forName(db_drive);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		return con;
	}
}