package javatest;

public class java4 { //한번 public 만들어졌으면 외부에는 public을 못쓴다! 클래스 이름이 파일명이랑도 같아야한다!!!
	
	int a,b =0;
	public void java1() {
		this.a = 20;
		this.b = 30;
		java2(); //같은 클래스 에서 해당 메소드로 실행 시켜줌 인자값 태워서도 가능
	}
	
	public void java2() {
		int sum = this.a + this.b;
		System.out.println(sum);
	}
}

class java5{
	//이건됨
}
