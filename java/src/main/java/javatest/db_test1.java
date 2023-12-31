package javatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//응용편
/*
 java + Database =rdms =mysql 
  
 */
//Library 추가가 필요 하다! : MysqlConnectJava maven repository 가서 mysql 검색하면
public class db_test1 {

	public static void main(String[] args) {
		
		 Date today = new Date();
		 System.out.println(today);
		 SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat time = new SimpleDateFormat("H:m:ss");
		 SimpleDateFormat datetime = new  SimpleDateFormat("yyyy-MM-dd H:m:ss");
		 System.out.println(time.format(today));
		 
		
		//db current_timestamp 할줄모르면,못쓰면 이거 코드로 찍어야 된다
		//String times = new timezone().now_time(1);
		//System.out.println(times);
		Scanner sc = new Scanner(System.in);
		Connection ct = null; //메인 클래스니까 필드에 있는 것을 못씀! 안으로 끄집어와야됨
		try {
			dbconfig db = new dbconfig();
			ct = db.info();
			System.out.println(ct.toString()); //db 접속 확인

			System.out.println("제목을 입력하세요 : ");
			String title = sc.nextLine(); //Scanner에 입력된 내용 값 받아서 처리
			
			//DB문법 - 
			
			String insert = "insert into webmail values('0','홍길동','hong@nate.com','"+ title +"','서울산업대 에이핑크 화이팅',now())";
			PreparedStatement ps = ct.prepareStatement(insert); //데이터 다다다닥 쳐주는 애임
			/*
			 excute() : select 문법에만 사용!!
			 excuteUpdate() : insert , update , delete, alter 문법에 사용,create도 여기! 
			  
			 */
			int oksign = ps.executeUpdate(); //sql의 Query에 대한 값은 숫자로 처리한다!
			
			//1 아니면 0인데
			if(oksign == 1) { //정상 저장됨
				System.out.println("저장이 잘 되었습니다.");
				ps.close();
				ct.close();
				sc.close();
			}
			else { //비정상! 저장오류,sql문법오류,db접속오류,컬럼에 대한 범위 오류 4가지 중 1가지 
				System.out.println("sql 문법 오류로 인하여 저장 되지 않았습니다.");
			}
		}
		catch(Exception e) {
			System.out.println("db 정보가 올바르지 않습니다.");
		}
		
	}

}

class dbconfig22{ //Database 접속 환경 설정 class
	//Connection은 : Interface를 사용을 한 것이다!
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

