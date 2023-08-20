package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

// I/O 응용편 

/*
  응용문제 1번
  해당 데이터를 파일로 저장 후 출력하는 프로세서를 제작하시오.
  "hong","kim","park","lee"
  "25","30","44","26"
  "홍길동","김유신","박찬호","이순신"
  
  파일에 저장 형태는 다음과 같습니다.
  홍길동 : hong(25)
  김유신 : kim(30)
  박찬호 : park(44)
  이순신 : lee(26)
  단, 파일명은 member_list.txt 로 저장되어 있어야 합니다.
  
 */
public class file14 {

	public static void main(String[] args) {
		try {
			data d = new data();
			d.abc();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
/*
  	String user[][] = {
				{"홍길동","김유신","박찬호","이순신"},
				{"hong","kim","park","lee"},
				{"25","30","44","26"}
		};
	
  
  
 */
class data{
	String user[][] = {
			{"홍길동","김유신","박찬호","이순신"},
			{"hong","kim","park","lee"},
			{"25","30","44","26"}
	};
	FileReader fr = null;
	FileWriter fw = null;
	
	public void abc() throws Exception{
		
		this.fr = new FileReader("D:\\project\\web\\src\\main\\webapp\\member_list.txt");
		int i,j;
		String name="";
		for(i=0; i<user[0].length; i++) {//4
			for(j=0; j<user.length; j++) { //3
				//System.out.println(user[j][i]);
				if(j==0&& i==0) {
					name = user[0][0]+" : "+user[1][0]+"("+user[2][0]+")";
					System.out.println(name);
					
				}
				else if(j==1 && i==1) {
					name = user[0][1]+" : "+user[1][1]+"("+user[2][1]+")";
					//System.out.println(name);
					
				}
				else if(j==2 && i==2) {
					name = user[0][2]+" : "+user[1][2]+"("+user[2][2]+")";
					//System.out.println(name);
				}
				else if(j==3 && i==3){
					name = user[0][3]+" : "+user[1][3]+"("+user[2][3]+")";
					//System.out.println(name);
				}

			}
		}
		fw.write(name);
		fw.close();
	}
}






