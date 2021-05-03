package day6;

import java.util.Calendar;

public class Enum3 {
	
	public static void main(String[] args) {
		// 열거형은 아니지만 열거형과 비슷하게 의미 전달을 하는 예제
		Calendar now = Calendar.getInstance(); // 실행 당시의 날짜와 시간을 알려줌
		int year = now.get(Calendar.YEAR); // 실행 당시의 연도, now.get(1)
		int month = now.get(Calendar.MONTH) + 1; // 실행 당시의 월(0부터 시작, 0~11), now.get(2)
		System.out.println(year + "년 " + month + "월");

	}

}
