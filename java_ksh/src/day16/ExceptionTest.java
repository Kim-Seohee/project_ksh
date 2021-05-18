package day16;

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			throw new Exception("예외");
		}
		// 예외가 발생하면 Exception 클래스를 이용하여 객체 e를 선언하고
		// 발생한 예외 객체를 e에 저장
		catch(Exception e) {
			// getMessage(): 생성자에서 넣어준 문자열을 가져오는 메소드
			System.out.println(e.getMessage());
			// printStackTrace(): 예외가 발생한 위치를 출력해주는 메소드. 빨간색이 뜬다고 예외가 발생한 게 아니다!! 그냥 위치를 출력해준 것
			e.printStackTrace();
		}
		System.out.println("종료");
	}

}
