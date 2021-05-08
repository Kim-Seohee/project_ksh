package day9;

public class CardGame {

	public static void main(String[] args) {
		/* 카드 게임: 실제 포커 게임은 모양과 숫자를 다 고려해야 하지만 여기에서는 숫자만 고려, 카드는 7장, 카드는 1 ~ 13이 4개씩(하트 다이아 세잎 스페이스)
		 * - 포커: 같은 숫자가 4개
		 * - 풀하우스: 트리플 1 + 페어(투페어도 가능) 또는 트리플 2
		 * - 스트레이트: 연속된 숫자가 5개 이상
		 * - 트리플: 같은 숫자가 3개
		 * - 투 페어: 같은 숫자가 2개씩 2개 => 페어가 2개
		 * - 페어: 같은 숫자가 2개
		 * - 탑: 위의 모든 조건이 없는 경우 가장 큰 수
		 * */
		/* 배열에 같은 숫자 3개가 있으면 있는 숫자들을 배열에 저장하여 알려주는 코드를 작성하세요.
		 * [1,1,1,2,3,4,5]
		 * */
		
		// 카드가 주어지면 해당 카드의 가장 큰 등급을 출력하는 코드를 작성하세요
		// 아래와 같이 풀하우스, 트리플, 페어로 판별 가능한 경우
		// 풀하우스 하나만 출력합니다.
		// 아래는 1풀하우스입니다라고 출력
		// {1,1,1,2,2,8,9};
		
		int []arr = new int[] {1,2,2,3,4,5,6};

		System.out.println("포커: " + poker(arr));
		
		System.out.println("트리플: " + triple(arr));
		
		System.out.println("원페어: " + onePair(arr));

		System.out.print("투페어: ");
		int []res1 = twoPair(arr);
		if(res1 == null) {
			System.out.println(0);
		}else {
			for(int tmp1 : res1) {
				System.out.print(tmp1 + " ");
			}
			System.out.println();
		}
		
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
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				if(count == 4) {
					// 따로 저장하지 않고 바로 return해도 된다
					return card[i]; // return이 실행되면 메소드를 빠져나가는 것, 밑의 return에 도달하지 않음
				}
			}else {
				count = 1;
			}
		}
		return 0;
	}
	/* public static int poker(int []card) {
		int count = 1;
		int pokerNum = 0;
		int num = 0;
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				num = card[i];
			} else {
				if(count == 4) {
					pokerNum = num;
				}
				count = 1;
			}
		}
		if(count == 4) {
			pokerNum = num;
		}
		
		return pokerNum;
	} */
	
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
		int res = 0;
		int []triple = new int[2];
		int num = 0;
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				num = card[i];
			} else {
				if(count == 3) {
					triple[res] = num;
					res += 1;
				}
				count = 1;
			}
		}
		if(count == 3) {
			triple[res] = num;
			res += 1;
		}
		if(res == 0) { // 트리플이 없으면
			return null;
		}else if(res == 2) {
			return triple;
		}else {
			int []tmp = new int[1]; // 트리플이 한 개만 있으면 한 개 짜리 배열에 출력
			tmp[0] = triple[0];
			return tmp;
		}
	}
	/* public static int[] tripleList(int []card) {
		int count = 1;
		int res = 0;
		int []triple = new int[2];
		int num = 0;
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				num = card[i];
			} else {
				if(count == 3) {
					triple[res] = num;
					res += 1;
				}
				count = 1;
			}
		}
		if(count == 3) {
			triple[res] = num;
			res += 1;
		}
		
		return triple;
	} */
	
	/* 트리플 기능을 하도록 메소드를 정리하고 코드를 작성하세요.
	 * 기능: 배열에 트리플이 있으면 해당 숫자를 알려주고 없으면 0을 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 트리플인 숫자 => int
	 * 메소드명: triple
	 * */
	public static int triple(int []card) { // 이미 만든 메소드를 활용하자
		int [] res = tripleList(card);
		// 트리플이 아닌 경우
		if(res == null || res.length == 2) {
			return 0;
		}
		return res[0];
	}
	/* public static int triple(int []card) {
		int count = 1;
		int res = 0;
		int []triple = new int[2];
		int num = 0;
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				num = card[i];
			} else {
				if(count == 3) {
					triple[res] = num;
					res += 1;
				}
				count = 1;
			}
		}
		if(count == 3) {
			triple[res] = num;
			res += 1;
		}
		
		if(res == 0 || res == 2) {
			return 0;
		}else {
			return triple[0];
		}
	} */
	
	/* 페어를 확인할 수 있는 메소드를 정리해보세요. 페어가 있다면 해당 페어의 숫자들을 알려주고,
	 * 없으면 null을 알려주는 기능을 정리하고 구현해보세요.
	 * 기능: 배열에 페어가 있으면 페어의 숫자들을 알려주고, 없으면 null을 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 배열 => int[]
	 * 메소드명: pairlist 
	 * */
	public static int[] pairlist(int []card) {
		int []pair = new int[3]; // 페어의 숫자들
		int count = 1;
		int num = 0; // 같은 숫자
		int res = 0; // 페어의 개수
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				num = card[i];
			} else {
				if(count == 2) {
					pair[res] = num;
					res += 1;
				}
				count = 1;
			}
		}
		if(count == 2) {
			pair[res] = num;
			res += 1;
		}
		if(res == 0) {
			return null;	
		}else if(res < 3) {
			int []tmpArr = new int[res];
			for(int i = 0; i < res; i += 1) {
				tmpArr[i] = pair[i];
			}
			return tmpArr;
		}
		return pair;
		
	}
	/* public static int[] pairlist(int []card) {
		int []pairNum = new int[3];
		int count = 1;
		int res = 0;
		int num = 0;
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] == card[i + 1]) {
				count += 1;
				num = card[i];
			} else {
				if(count == 2) {
					pairNum[res] = num;
					res += 1;
				}
				count = 1;
			}
		}
		if(count == 2) {
			pairNum[res] = num;
			res += 1;
		}
		
		if(res == 0) {
			return null;
		}else if(res == 3) {
			return pairNum;
		}else if(res == 2) {
			int []tmp2 = new int[2];
			for(int i = 0; i < tmp2.length; i += 1) {
				tmp2[i] = pairNum[i];
			}
			return tmp2;
		}else {
			int []tmp = new int[1];
			tmp[0] = pairNum[0];
			return tmp;
		}
	} */
	
	/* 원페어를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능: 배열에 원페어가 존재하면 그 숫자를 출력하고 원페어가 아니면 0을 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 페어 숫자 => 정수 => int
	 * 메소드명: onePair
	 * */
	public static int onePair(int []card) {
		int []res = pairlist(card);
		if(res != null && res.length == 1) {
			return res[0];
		}
		return 0;
	}
	/* public static int onePair(int []card) {

		int []res = pairlist(card);
		if(res == null || res.length == 2 || res.length == 3) {
			return 0;
		}
		return res[0];
	} */
	
	/* 투페어를 확인할 수 있는 메소드를 정리해보세요.
	 * 기능: 배열에 투페어가 존재하면 그 숫자 두 개를 출력하고 투페어가 아니면 null을 알려주는 메소드
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 배열 => int[]
	 * 메소드명: twoPair
	 * */
	public static int[] twoPair(int []card) {
		int []res = pairlist(card);
		if(res == null || res.length == 1) {
			return null;
		}
		return res;
	}
	/* public static int[] twoPair(int []card) {
		int []res = pairlist(card);
		if(res.length == 2) { // 틀림. 페어가 3개여도 투페어임!!
			int []tmp = new int[2];
			tmp[0] = res[0];
			tmp[1] = res[1];
			return tmp;
		}
		return null;
	} */
	
	/* 풀하우스를 확인할 수 있는 메소드를 정리해보세요
	 * 기능: 배열에 풀하우스가 존재하면(트리플 1 + 페어(투페어도 가능) 또는 트리플 2) 풀하우스 숫자를 출력하고 없으면 0을 알려준다.
	 * 예시 2 2 2 3 3 4 5 => 2
	 *     2 2 2 9 9 9 10 => 9
	 * 매개변수: 배열 => int []card
	 * 리턴타입: 풀하우스의 숫자 => 정수 => int
	 * 메소드명: fullHouse
	 * */
	public static int fullHouse(int []card) {
		int []triple = tripleList(card);
		// 트리플이 없으면 풀하우스가 될 수 없기 때문에 0을 리턴
		if(triple == null) {
			return 0;
		}
		// 트리플이 2개이면 풀하우스
		// tripleList를 이용
		if(triple.length == 2) { // triple != null 조건을 추가하지 않아도 된다(위에 있기 때문에)
			if(triple[0] > triple[1]) { // 더 큰 수를 return
				return triple[0];
			}
			return triple[1];
		}
		// 트리플이 2개가 아니면
		// 트리플이 1개, 페어가 1개 이상이면 풀하우스
		// triple과 pairList를 이용
		int []pair = pairlist(card);
		if(pair != null) { // 여기까지 내려오면 트리플은 무조건 있기 때문에 페어가 null이 아니면
			return triple[0];
		}
		// 아니면 풀하우스가 아님
		return 0;
	}
	/* public static int fullHouse(int []card) {
		// 트리플이 2개이면 풀하우스
		// tripleList를 이용
		int []tripleList = tripleList(card);
		if(tripleList != null && tripleList.length == 2) {
			return tripleList[1];
		}
		// 트리플이 2개가 아니면
		// 트리플이 1개, 페어가 1개 이상
		// triple과 pairList를 이용
		int triple = triple(card);
		int []pairList = pairlist(card);
		if(triple != 0) {
			if(pairList != null && pairList.length >= 1) {
				return triple;
			}
		}
		// 아니면 풀하우스가 아님
		return 0;
	} */
	/* public static int fullHouse(int []card) {
		int []tripleNum = tripleList(card);
		int triple = triple(card);
		int onePair = onePair(card);
		int []twoPair = twoPair(card);
		if(tripleNum != null && tripleNum.length == 2) {
			return tripleNum[1];
		}
		if(triple != 0) {
			if(onePair != 0 || twoPair != null) {
				return triple;
			}
		}
		return 0;
	} */
	
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
		// 스트레이트가 마지막 숫자를 포함할 때
		if(count >= 5) {
			return num;
		}
		return 0;
	}
	/* public static int straight(int []card) {  // 1 2 2 3 3 4 5 같은 경우 판별하지 못하는 코드
		int count = 1;
		int num = 0;
		for(int i = 0; i < card.length - 1; i += 1) {
			if(card[i] + 1 == card[i + 1]) {
				count += 1;
				num = card[i + 1];
			} else {
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
	} */
	
}
