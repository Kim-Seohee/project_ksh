package accountbook;

/* 클래스명: AccountBook
 * - 수입 내역, 지출 내역을 관리하기 위한 가계부 클래스
 * */
public class AccountBook {
	// 멤버변수: Item 배열
	private Item []itemList; // 가계부 내역들
	private int count; // 저장된 내역들 갯수
	private int total; // 내역에 기입된 금액의 총량
		
	public AccountBook(int num) {
		itemList = new Item[num];
	}
	
	// 멤버메소드
	/* 기능: 수입/지출 내역이 주어지면 입력
	 * 매개변수: 수입 지출 내용 변수들*/
	public void entry(Item item) {
		itemList[count++] = item;
		// 수입이면 total에 +, 지출이면 -를 하고 싶은데 스트링에 ==를 쓰면 안될거같음
		// total += item.getCost();
	}
	/* 기능: 수입/지출 내역 수정(뭘 기준으로?)*
	 * 매개변수: 몇 번째 내역인지, 수정할 내용들 => int n,
	 */
	public void modify(int n, String type, String date, String paymentType, String category, int cost, String contents) {
		itemList[n - 1].update(type, date, paymentType, category, cost, contents);
	}
	/* 기능: 수입/지출 내역 삭제
	 * 매개변수: 몇 번째 내역을 삭제할 것인지 => int n
	 * */
	public void delete(int n) {
		if(n < count) {
			itemList[n - 1] = null;
		}
		count--;
	}
	/* 기능: 수입/지출 내역 간략하게 확인*
	 * 매개변수: 몇 번째 내역인지 => int n
	 */
	public void summary(int n) {
		System.out.println(itemList[n - 1].getType() + " " + itemList[n - 1].getCost());
	}
	/* 기능: 수입/지출 내역 상세 확인*
	 * 매개변수: 몇 번째 내역인지 => int n
	 */
	public void detail(int n) {
		System.out.println("수입/지출: " + itemList[n - 1].getType());
		System.out.println("날짜: " + itemList[n - 1].getDate());
		System.out.println("결제 타입: " + itemList[n - 1].getPaymentType());
		System.out.println("분류: " + itemList[n - 1].getCategory());
		System.out.println("금액: " + itemList[n - 1].getCost());
		System.out.println("내용: " + itemList[n - 1].getContents());
	}
}
