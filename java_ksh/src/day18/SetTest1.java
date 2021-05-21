package day18;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest1 {

	public static void main(String[] args) {
		/* Set의 메소드 예제 */
		HashSet<Integer> set = new HashSet<Integer>();
		// add(객체): set에 객체를 추가, 번지로 접근하는 메소드는 없음
		set.add(10);
		set.add(10);
		set.add(5);
		set.add(6);
		set.add(4);
		set.add(100);
		set.add(525);
		// size(): set의 크기
		System.out.println("set의 크기: " + set.size()); // 1, 중복 허용 X
		// contains(객체): 객체가 있는지 없는지 확인
		System.out.println("set에 10이 있습니까? " + set.contains(10));
		System.out.println("set에 11이 있습니까? " + set.contains(11));
		// isEmpty(): set이 비었는지 아닌지 확인
		System.out.println("set이 비어 있습니까? " + set.isEmpty());
		
		// set의 내용물 출력: Iterator 객체 사용
		Iterator<Integer> it = set.iterator(); // Iterator 옆 괄호에 Interger를 적어주면 (1)
		while(it.hasNext()) { // 다음에 선택할 객체가 있는지 없는지 boolean으로 알려줌
			Integer tmp = it.next(); // it.next() 앞 (Integer) 생략 가능 (2) // next(): set에 있는 값 하나를 가져오는 것
			System.out.print(tmp + " ");
		}
		System.out.println();
		// remove(객체): 객체와 일치하는 내용을 삭제하고 삭제 성공 여부를 알림
		System.out.println("set에 10의 값이 삭제 되었습니까? " + set.remove(10)); // true 리턴
		System.out.println("set에 10의 값이 삭제 되었습니까? " + set.remove(10)); // 이미 삭제했기 때문에 false를 리턴한다
		// clear(): 비움
		set.clear();
		System.out.println("set의 크기: " + set.size());

	}

}
