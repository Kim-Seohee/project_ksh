package day16;

public class ThrowsTest {

	public static void main(String[] args) {
		try {
			test();	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void test() throws Exception, ArithmeticException{ // Exception은 실행 예외가 아니므로 throws 이후를 생략할 수 없다. 여러개 적고 싶으면 콤마로 구분해서 적어주면 된다.
		throw new Exception("test 메소드에서 예외 발생");
	}
}
