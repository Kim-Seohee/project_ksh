package day13;

public class InheritanceTest {

	public static void main(String[] args) {
		Child c = new Child(1, 2, 3);
		c.print(); // 부모 클래스의 메소드를 사용할 수 있다.
		c.print2();
		String s;
	}
}
class Parent{
	private int num1;
	protected int num2;
	public int num3;
	// 멤버변수의 접근제한자는 default를 피하는 것이 좋다.
	
	public void print() {
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("num3: " + num3);
	}

	public Parent(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	// 파이널 메소드
	public final void menu() {
		System.out.println("메뉴입니다.");
	}
}
class Child extends Parent {
	public int num4;
	
	public Child(int num1, int num2, int num3) {
		super(num1, num2, num3);
	}
	public void print2() {
		System.out.println(getNum1()); // getter 사용
		System.out.println(num2);
		System.out.println(num3);
	}
	// 오버라이드/오버라이딩
	// 접근제한자를 좁힐 수는 없다. (교재 317페이지)
	// 부모 클래스의 메소드가 public이면 private이나 protected로 수정할 수 없다.
	@Override // Annotation
	public void print() { 
		super.print();
		System.out.println("num4: " + num4);
	}
	// 오버로드/오버로딩
	public void print(int num1) {
		super.print();
		System.out.println("num4: " + num4);
	}
	// 부모 클래스에 있는 menu 메소드가 final이기 때문에 오버라이딩이 되지 않는다.
	// public void menu() {}
}
// final 클래스 String을 통해 자식 클래스를 만들 수 없다.
// class SubString extends String {}