package day9;

public class Practice9_1 {

	public static void main(String[] args) {
		int []arr = new int[] {1,1,2,3,3,4,5};
		System.out.println("포커: " + poker(arr));
		for(int tmp : tripleList(arr)) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		System.out.println("트리플: " + triple(arr));
		for(int tmp : pairList(arr)) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		System.out.println("원 페어: " + onePair(arr));
		System.out.print("투 페어: ");
		if(twoPair(arr) != null) {
			for(int tmp : twoPair(arr)) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("풀하우스: " + fullHouse(arr));
		System.out.println("스트레이트: " + straight(arr));
		
	}
	/* 포커를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능	: 배열에서 4개의 같은 수가 존재하는지 아닌지 확인하는 메소드 / 
	 * 		  (강사님) 배열이 주어지면 배열에 포커가 있는지 확인하여 있으면 해당 숫자를 없으면 0을 알려주는 메소드
	 * 매개변수: 배열 => int []arr
	 * 		  (강사님) 배열 => int [] card
	 * 리턴타입: 4개의 같은 수가 존재하는지 아닌지 => boolean
	 * 		  (강사님) 포커의 숫자 => 정수 => int
	 * 메소드명: poker
	 * */
	public static int poker(int []card) {
		int count = 1;
		int num = 0;
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				num = card[i];
			} else {
				if(count == 4) {
					return num;
				}
				count = 1;
			}
		}
		if(count == 4) {
			return num;
		}
		return 0;
	}
	/* 트리플을 확인할 수 있는 메소드를 정리해보세요. 트리플이 있다면 해당 트리플의 숫자를
	 * 확인할 수 있는 메소드를 만들어야 합니다.
	 * 기능: 배열이 주어지면 배열에 트리플이 있는지 확인하여 있으면 트리플의 숫자를 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 트리플의 숫자들 => 정수 배열 => int[]
	 * 		  정수로 하는 경우 11, 13이면 1113
	 * 메소드명: tripleList
	 * */
	public static int[] tripleList(int []card) {
		int count = 1;
		int num = 0;
		int seq = 0;
		int []res = new int[2];
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				num = card[i];
			} else {
				if(count == 3) {
					res[seq] = num;
					seq += 1;
				}
				count = 1;
			}
		}
		if(count == 3) {
			res[seq] = num;
			seq += 1;
		}
	    if(res != null & res[1] != 0) {
	    	return res;
	    } else if(res != null & res[1] == 0) {
	    	int []tmp = new int[1];
	    	tmp[0] = res[0];
	    	return tmp;
	    }
	    return null;
	}
	/* 트리플 기능을 하도록 메소드를 정리하고 코드를 작성하세요.
	 * 기능: 배열에 트리플이 있으면 해당 숫자를 알려주고 없으면 0을 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 트리플인 숫자 => int
	 * 메소드명: triple
	 * */
	public static int triple(int []card) {
		int []tripleList = tripleList(card);
		if(tripleList != null && tripleList.length == 1) {
			return tripleList[0];
		}
		return 0;
	}
	/* 페어를 확인할 수 있는 메소드를 정리해보세요. 페어가 있다면 해당 페어의 숫자들을 알려주고,
	 * 없으면 null을 알려주는 기능을 정리하고 구현해보세요.
	 * 기능: 배열에 페어가 있으면 페어의 숫자들을 알려주고, 없으면 null을 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 배열 => int[]
	 * 메소드명: pairlist 
	 * */
	public static int[] pairList(int []card) {
		int count = 1;
		int num = 0;
		int seq = 0;
		int []res = new int[3];
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				num = card[i];
			} else {
				if(count == 2) {
					res[seq] = num;
					seq += 1;
				}
				count = 1;
			}
		}
		if(count == 2) {
			res[seq] = num;
			seq += 1;
		}
	    if(seq == 0) {
	    	return null;
	    }else {
	    	int []tmp = new int[seq];
	    	for(int i = 0; i <= seq - 1; i += 1) {
	    		tmp[i] = res[i];
	    	}
	    	return tmp;
	    }
	}
	/* 원페어를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능: 배열에 원페어가 존재하면 그 숫자를 출력하고 원페어가 아니면 0을 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 페어 숫자 => 정수 => int
	 * 메소드명: onePair
	 * */
	public static int onePair(int []card) {
		int []pairList = pairList(card);
		if(pairList != null & pairList.length == 1) { // 주의!!
			return pairList[0];
		}else {
			return 0;
		}
	}
	/* 투페어를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능: 배열에 투페어가 존재하면 그 숫자 두 개를 출력하고 투페어가 아니면 null을 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 배열 => int[]
	 * 메소드명: twoPair
	 * */
	public static int[] twoPair(int []card) {
		int []res = pairList(card);
		if(res == null || res.length == 1) { // 3개짜리도 투 페어이기 때문에 이 조건식
			return null;
		}
		return res;
	}
	/* 풀하우스를 확인할 수 있는 메소드를 정리해보세요
	 * 기능: 배열에 풀하우스가 존재하면(트리플 1 + 페어(투페어도 가능) 또는 트리플 2) 풀하우스 숫자를 출력하고 없으면 0을 알려준다.
	 * 예시 2 2 2 3 3 4 5 => 2
	 *     2 2 2 9 9 9 10 => 9
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 풀하우스의 숫자 => 정수 => int
	 * 메소드명: fullHouse
	 * */
	public static int fullHouse(int[] card) {
		// 트리플이 2개(tripleList)
		int []tripleList = tripleList(card);
		if(tripleList != null && tripleList.length == 2) {
			return tripleList[1];
		}
		// 트리플이 1개(triple) + 페어(pairList)
		int triple = triple(card);
		int []pairList = pairList(card);
		if(triple != 0 && pairList != null) {
			return triple;
		}
		return 0;
	}
	/* 스트레이트를를 확인할 수 있는 메소드를 정리해보세요.
	 * 1 10 11 12 13도 원래는 스트레이트임(마운틴), 여기에서는 제외 
	 * 백스트레이트: 1 2 3 4 5, 여기에서는 그냥 5스트레이트로 판단
	 * 기능: 배열에 스트레이트(5개 이상의 숫자가 연속)가 존재하면 그 숫자를 알려주고 아니면 0을 알려주는 메소드 /
	 *      배열에 스트레이트가 있으면 스트레이트 중 가장 큰 수를 알려주고 없으면 0을 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 스트레이트 중 가장 큰 수 => 정수 => int
	 * 메소드명: straight
	 * */
	public static int straight(int []card) {
		int count = 1;
		int num = 0;
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				continue;
			}
			if(card[i] + 1 == card[i + 1]) {
				count += 1;
				num = card[i + 1];
			}else {
				if(count >= 5) {
					return num;
				}
				count = 1;
			}
		}
		if(count >= 5) {
			return num;
		}
		return 0;
	}
}
