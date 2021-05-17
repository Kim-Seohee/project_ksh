package day15;

public class AbstractTest {

	public static void main(String[] args) {
		// 클래스 A의 객체 a를 생성
		A a = new A();
		// 추상 클래스 B의 객체 b를 생성
		// B b = new B(); // 오류 발생
		// 추상 클래스 B를 상속받은 클래스 C의 객체 c를 생성
		C c = new C();
		// 클래스 C를 이용하여 객체를 생성한 후 추상 클래스 B의 객체에 저장
		B b1 = new C();
	}

}

class A{}
abstract class B{
	abstract void print();
}
class C extends B{ // 추상 클래스를 상속받은 일반 클래스

	@Override
	void print() {
		
	}
	
}
class D{} // A와 D는 전혀 별개의 클래스이므로 타입 변환이 불가능