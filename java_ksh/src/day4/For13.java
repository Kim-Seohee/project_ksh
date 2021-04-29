package day4;

public class For13 {

	public static void main(String[] args) {
		/* 구구단 전체를 출력하는 코드를 작성하세요.
		 * */
		int i, j;
		for(i = 2; i <= 9; i += 1) {
			for(j = 1; j <= 9; j += 1) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
		}

	}

}
 