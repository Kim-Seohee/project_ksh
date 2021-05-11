package day11;

public class BoardTest {

	public static void main(String[] args) {
		Board board = new Board(1, "제목입니다", "내용입니다", "김서희", "2021-05-11", "공지");
		board.print();
		// cf)
		String str = "1";
		// int num1 = str; // 불가능
		double dnum = 1; // 정수 1이 자동타입변환이 되어서 가능
		int num2 = (int)1.0; // 실수 1.0이 강제타입변환이 되어서 가능

	}

}
