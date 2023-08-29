package app;
/* javatest 패키지 중 java9과 연계됨!*/
//외부 패키지 의 외부 클래스는 default 클래스 이므로!!!
//다른 패키지에서 해당 클래스를 직접 호출할수 없다
//외부 패키지에서 외부 클래스 까지 적용할려면 상속, public에서 외부클래스를 상속받은 후 사용해야 함!
//외부에서 해당 public class를 호출하면 외부 class까지 로드하여 실행 시킬수 있음
public class app1 extends app_box1{
	/* package app(app1.java) 와 연계하는 프로세서! */
	public static void main(String[] args) {
		System.out.println("외부 패키지 class입니다!");
		
	}

	@Override
	public void abc() {
		// TODO Auto-generated method stub
		super.abc();
	}



}
class app_box1{
	public void abc() {
		System.out.println("외부 class 중 abc 메소드!");
	}
}
