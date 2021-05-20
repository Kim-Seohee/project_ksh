package day15;

public class AnonymousTest {

	public static void main(String[] args) {
		// TvRemocon 클래스를 이용하여 객체를 만든 것과 같은 결과를 가진다
		// 단 해당 익명객체를 다시 사용하려면 코드를 복붙해야 한다.(비효율적, 재사용성이 낮음)
		// 구현 클래스 대신 익명 객체 사용 예제
		Remocon r = new Remocon() {
			@Override
			public void turnOn() { System.out.println("전원 켜짐"); }
			@Override
			public void turnOff() { System.out.println("전원 꺼짐"); }
			
		};
		r.turnOn();
	}

}

abstract class Parent{
	public abstract void print();
}
class Child extends Parent{
	@Override
	public void print() {
		System.out.println("안녕");
		
	}
}
class TempA{
	// private Parent p = new Child();
	// Parent 추상 클래스를 이용하여 새로운 익명 객체를 생성한 후, 생성한 익명 객체의 주소를 p에 저장
	private Parent p = new Parent(){
		int num = 10;
		public void print() {
			System.out.println("안녕");
		}
	};
}
interface Remocon{
	void turnOn();
	void turnOff();
}
class TvRemocon implements Remocon{
	public void turnOn() { System.out.println("전원 켜짐"); }
	public void turnOff() { System.out.println("전원 꺼짐"); }
}