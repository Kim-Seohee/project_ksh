package day11;

public class MethodTest {

	public static void main(String[] args) {
		
		int res = sum(1, 2); // 메소드의 리턴값은 메소드를 호출한 위치로 간다.
		System.out.println(res);
		// System.out.println(print()); // 잘못된 경우
		//int num = print(); // 잘못된 경우
		int []arr = new int[] {1, 2, 3, 4, 5};
		System.out.println(sum2(arr));
		System.out.println(sum3(1, 2, 3));
		System.out.println(sum3(1, 2, 3, 4, 5));
	}
	
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	public static void print() {
		System.out.println(1);
	}
	public static int sum2(int []arr) {
		if(arr == null) { // 확인 필요
			return 0;
		}
		int res = 0;
		for(int tmp : arr) {
			res += tmp;
		}
		return res;
	}
	// p.252
	public static int sum3(int ...arr) { // 매개변수의 수가 가변인 경우, null 확인 불필요
		int res = 0;
		for(int tmp : arr) {
			res += tmp;
		}
		return res;
	}
}
