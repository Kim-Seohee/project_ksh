package day11;

public class SingletonTest {

	public static void main(String[] args) {
		/* 싱글톤: 전체 프로그램에서 하나의 클래스로 단 하나의 객체만 있어야 하는 경우에 만든 단 하나의 객체
		 * 1. 싱글톤을 만드려면 생성자의 접근제한자를 private으로 해서 외부에서 생성자를 호출할 수 없게 한다.
		 * 2. 클래스의 멤버 변수로 해당 클래스의 클래스 변수를 만든다.
		 * 3. 클래스 변수를 가져오는 메소드를 선언 및 구현
		 * */
		// 에러 발생: 생성자의 접근제한자가 private이어서 호출이 불가능
		// Singleton s = new Singleton();
		Singleton s1; // 이 때 Singleton 클래스 안에 Singleton 객체를 생성
		s1 = Singleton.getSingleton(); // 이미 만들어진 Singleton 객체를 가져옴
		Singleton s2 = Singleton.getSingleton(); // 이미 만들어진 Singleton 객체를 가져옴
		if(s1 == s2) { // 주소를 비교
			System.out.println("같은 객체입니다.");
		}
	}

}
class Singleton{
	// 2. 클래스의 멤버 변수로 해당 클래스의 클래스 변수를 만든다.
	private static Singleton singleton = new Singleton(); // 클래스 멤버 변수가 생성되고 그 변수에 객체를 만듦
	// 1. 생성자의 접근제한자를 private
	private Singleton() {}
	// 3. 클래스 변수를 가져오는 메소드를 선언 및 구현
	public static Singleton getSingleton() {
		return singleton;
	}
	
}