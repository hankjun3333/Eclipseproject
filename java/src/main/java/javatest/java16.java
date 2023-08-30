package javatest;



/*인터페이스 활용! - 부품같은 개념*/
//interface는 일반 메소드를 활용할 수 있음!!
public class java16 {

	public static void main(String[] args) {
		new box6().a1();
		new box6().b1();
		/*interface 안에 외부클래스를 객체 및 인스턴스 생성후 그 클래스의 메소드를 호출!*/
		inter1.zzz h = new inter1.zzz();
		h.zzjj();

	}

}
//extends => abstract 쓰거나 외부 클래스 로드할때 상속받을때 사용
//그 외 인터페이스는 implements 무족권 Override 써야 함! (강제성)
//인터페이스는 동시에 여러개 한꺼번에 implements 가능!
class box6 implements inter1,inter2{
	@Override
	public void a1() {
		//this.sc = new Scanner(System.in); //Scanner의 클래스를 가져오는 것이기 떄문에 
		//inter1.sc = new Scanner(System.in);
		String a = this.sc.nextLine(); // --이런식으로 호출!
		
		System.out.println(this.name); //inter1 필드값 상속받자마자 this로 바로 가져올수있음!
		System.out.println(this.level);
	}

	@Override
	public void b1() {
		System.out.println(this.name); //inter2에는 없는데 inter1의 필드값 전역변수을 호출도 가능함 
		
	}

	@Override
	public String b2() {
		// TODO Auto-generated method stub
		return null;
	}
	
}