package day4;

public class For9 {

	public static void main(String[] args) {
		/* 무한루프: 반복문이 끝나지 않는 경우를 무한루프라고 한다.
		 * */
		int i = 1;
		// i > 5 조건식이면 한 번도 동작하지 않는다.
		for( ; i < 5; ) { // 조건식이 있어도 무한루프에 빠질 수 있다.
			System.out.println("Hello world!");
		}
//		System.out.println("Hi"); // 무한루프가 앞에 존재하면 에러가 난다.
	}

}
