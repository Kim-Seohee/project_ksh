package day18;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest3 {

	public static void main(String[] args) {
		/* 중복되지 않은 6개의 수를 랜덤으로 생성하여 저장한 후 출력하는 코드를 작성하세요.
		 * 단 숫자의 범위는 1~45*/
		// HashSet 객체 생성
		HashSet<Integer> set = new HashSet<Integer>();
		// 중복되지 않은 6개의 수를 랜덤으로 생성하여 set에 저장
		int min = 1, max = 45;
		while(set.size() < 6) {
			Integer r = (int)(Math.random() * (max - min + 1) + min);
			set.add(r);
			// set.add((int)(Math.random() * (max - min + 1) + min));
		}
		// 출력
		System.out.print("로또: ");
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

}
