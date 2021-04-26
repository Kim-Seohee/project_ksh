package day1;

public class Println {

	public static void main(String[] args) {
		/* System.out.println(): ()안에 있는 내용을 콘솔에 출력하는 메소드(기능), 내용을 출력 후 엔터를 침(줄바꿈)
		 * System.out.println(문자열);
		 * System.out.println(정수);
		 * System.out.println(실수);
		 * System.out.println(논리형);
		 * System.out.println(문자);
		 * */
		System.out.println("Helllo");
		System.out.println(1);
		System.out.println(3.14);
		System.out.println(true);
		System.out.println('A');
		
		System.out.print("Helllo"); // 줄바꿈이 되지 않음
		
		System.out.println(1 + 2 + 3);
		System.out.println("1" + 2 + 3); // 문자열"1" + 정수2 -> 문자열"12", 문자열 "12" + 정수3 -> 문자열"123"
		System.out.println("1" + (2 + 3)); // 문자열"1"과 정수2를 먼저 더하는 것이 아니라 정수2와 정수3을 먼저 더한 후 앞의 문자열"1"과 더함, 15 출력
		System.out.println(1 + 2 + "3");
	}

}
