package day4;

public class Continue {

	public static void main(String[] args) {
		int i;
		// 2를 출력하지 않음
		for(i = 1; i <= 5; i += 1) {
			if(i == 2) {
				continue;
			}
			System.out.println(i);
		}
		
		for(i = 1; i <= 5; i += 1) {
			if(i != 2) {
				System.out.println(i);
			}
		}

	}

}
