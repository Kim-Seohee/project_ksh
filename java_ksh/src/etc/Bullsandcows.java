package etc;

import java.util.Scanner;

public class Bullsandcows {

	public static void main(String[] args) {
		int arr1[] = {1, 4, 3};
		int arr2[] = new int[3];
		int i, j, k, l, m, n;
		int strike = 0, ball = 0;
		int min = 1, max = 9;
		// 중복되지 않는 3개의 랜덤 정수 arr1에 저장하기 (처음에 true로 출력되면 무한루프에 빠짐..왜?)
		boolean isDup = false;		
		for (;;) {
			for (l = 0; l < arr1.length; l += 1) {
				arr1[l] = (int)(Math.random() * (max - min + 1) + min);
			}
			for(l = 0; l < arr1.length - 1; l += 1) {
				for(m = l + 1; m < arr1.length; m += 1) {
					if(arr1[l] == arr1[m]) {
						isDup = true;
					}
				}
			}
			if(isDup == false) {
				break;
			}
		}
		for(n = 0; n < arr1.length; n += 1) {
			System.out.print(arr1[n] + " ");
		}
		System.out.println();
		
		for(;;) {
			strike = 0;
			ball = 0;
			Scanner scan = new Scanner(System.in);
			System.out.print("입력하세요: ");
			
			for (k = 0; k < arr2.length; k += 1) {
				arr2[k] = scan.nextInt();
			}
			
			for(i = 0; i < arr1.length; i += 1) {
				for(j = 0; j < arr2.length; j += 1) {
					if (i == j) {
						if(arr1[i] == arr2[j]) {
							strike += 1;
						}
					} else if (i != j) {
						if(arr1[i] == arr2[j]) {
							ball += 1;
						}
					}
				}
			}
			
			if(strike == 0) {
				if(ball == 0) {
					System.out.println("O");
				} else if(ball != 0) {
					System.out.println(ball + "B");
				}
			} else if(strike > 0 && strike < arr1.length) {
				if(ball == 0) {
					System.out.println(strike + "S");
				} else if(ball != 0) {
					System.out.println(strike + "S" + ball + "B");
				}
			} else if(strike == arr1.length) {
				System.out.println(strike + "S");
				System.out.println("정답입니다.");
				break;
			}
			
		}
		
	}

}
