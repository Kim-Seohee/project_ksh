package day11;

public class MethodOverloadingTest {

	public static void main(String[] args) {
		Point2 pt = new Point2();
		pt.print();
		pt.move(4, 5);
		pt.print();
		Point2 pt2 = new Point2(10, 20);
		pt.move(pt2);
		pt.print();
		// println도 메소드 오버로딩임
		System.out.println(1);
		System.out.println("1");
		System.out.println('1');
		
		Point2 pt3 = new Point2();
		Point2 pt4 = new Point2(0, 0);
	}

}
class Point2 {
	private int x, y;
	public Point2() {
		this(0, 0); // 이미 만들어져 있는 해당 클래스의 생성자 호출
	}
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point2(Point2 pt) { // 복사 생성자
		this(pt.x, pt.y);
	}
	public void print() {
		System.out.println("(" + x + ", " + y + ")");
	}
	/* 기능: 이동할 x, y 좌표가 주어지면 해당 좌표로 이동하는 메소드
	 * 매개변수: x, y 좌표 => int x, int y
	 * 리턴타입: 없음 => void
	 * 메소드명: move
	 * */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/* 기능: 이동할 좌표가 Point2의 객체로 주어지면 해당 좌표로 이동하는 메소드
	 * 매개변수: Point2의 객체 => Point2 pt
	 * 리턴타입: 없음 => void
	 * 메소드명: move
	 * */
	public void move(Point2 pt) { // pt도 Point2로 만들어졌기 때문에 pt.x로 접근할 수 있다(getter 없이도)
		x = pt.x;
		y = pt.y;
	}
}