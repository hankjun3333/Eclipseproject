package javatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class work4 {
	public static void main(String[] args) {
		try {
			new data().membership();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

class data{
	Scanner sc = null;
	Connection ct = null;
	String insert = null;
	String id = "";
	String pass = "";
	String name = "";
	String tel = "";
	String email = "";
	String num = "";
	public void membership() throws Exception{
		this.sc = new Scanner(System.in);
		dbconfig db = new dbconfig();
		this.ct = db.info();
		System.out.println("1.일반회원은 - 일반" + "\n" + "2.사업자 회원은 - 사업자");
		String client_ck = sc.nextLine().intern();
		while(true) {
			if(client_ck == "일반" || client_ck =="사업자" ) {
				System.out.println("id를 입력해주세요");
				id = sc.nextLine().intern();
				while(true) {
					if(id == "" || id == null) {
						System.out.println("아이디가 공백입니다 작성해주시죠");
						id = sc.nextLine().intern();
					}
					else {
						break;
					}
				}
				System.out.println("비밀번호를 입력해주세요");
				pass = sc.nextLine().intern();				
				while(true) {
					if(pass == "" || pass == null) {
						System.out.println("패스워드가 공백입니다 작성해주시죠");
						pass = sc.nextLine().intern();
					}
					else {
						break;
					}
				}
				System.out.println("이름 또는 회사명을 입력해주세요");
				name = sc.nextLine().intern();				
				while(true) {
					if(name == "" || name == null) {
						System.out.println("이름 또는 회사명이 공백입니다 작성해주시죠");
						name = sc.nextLine().intern();
					}
					else {
						break;
					}
				}
				System.out.println("전화번호 또는 휴대전화번호 (숫자만 입력!)");
				tel = sc.nextLine().intern();
				while(true) {
					
			        boolean isNumeric = tel.chars().allMatch(Character::isDigit); // true (숫자일 경우)
			        //System.out.println("숫자인지 여부: " + isNumeric);
			        if(isNumeric == true && tel !="") {
			        	System.out.println("숫자가 정상적으로 입력이 되었습니다.");
			        	break;
			        }
			        else if(tel == "" || tel == null){
			        	System.out.println("공백입니다 숫자만 입력하여 주세요");
			        	tel = sc.nextLine().intern();
			        }
			        else {
			        	System.out.println("숫자만 입력하여 주세요");
			        	tel = sc.nextLine().intern();
			        }
				}
				
				System.out.println("이메일을 입력해주세요");
				email = sc.nextLine().intern();				
				while(true) {
					if(email == "" || email == null) {
						System.out.println("이메일이 공백입니다 작성해주시죠");
						email = sc.nextLine().intern();
					}
					else {
						break;
					}
				}
				if(client_ck == "일반") {
					this.num = String.valueOf(0); // 일반회원은 사업자 등록번호 0으로 변환해서 db에 등록
					
				}
				else {
					System.out.println("사업자 등록번호 10자리를 입력해주세요!");
					num = sc.nextLine().intern();
					while(true) {
						if(num.length()==10) {
							System.out.println("사업자등록번호 10자리가 정상적으로 입력되었음");
							break;
						}
						else {
							System.out.println("사업자 등록번호 10자리를 제대로 입력해주세요");
							num = sc.nextLine().intern();
						}
					}
				}

				this.insert = "insert into client values('0','"+id+"',password('"+pass+"'),'"+name+"','"+tel+"','"+email+"','"+num+"',now())";
				PreparedStatement ps = ct.prepareStatement(this.insert); //데이터 다다다닥 쳐주는 애임
				int oksign = ps.executeUpdate();
				if(oksign ==1) {
					System.out.println("에이핑크 정은지 화이팅");
					System.out.println("db에 깔쌈하게 저장됬군요!");
					ps.close();
					ct.close();
					sc.close();
					
				}
				else {
					System.out.println("저장이 실패하였음");
				}
				break;
				
			}
			else {
				System.out.println("일반 또는 사업자를 입력해주세요!!");
				client_ck = sc.nextLine().intern();
			}
		}
	}
}
