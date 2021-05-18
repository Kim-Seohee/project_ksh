package day16;

import java.util.Scanner;

public class TryTest4 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요. */
		// Scanner를 통해 두 정수와 산술 연산자를 입력받음
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 산술 연산자를 입력하세요(예: 1 + 2): ");
		
		try {
			int num1 = scan.nextInt();
			char op = scan.next().charAt(0);
			// String op = scan.next();
			int num2 = scan.nextInt();
			double res = 0.0;
		
		// 조건문을 이용하여 산술연산자에 따라 연산을 함

			switch(op) {
			case '+' : // case "+" :
				res = num1 + num2;	break;
			case '-' : // case "-" :
				res = num1 - num2;	break;
			case '*' :
				res = num1 * num2;	break;
			case '%' :
					res = num1 % num2;	break;
			case '/' :
				res = (double)num1 / num2;	break;
			default : 
				throw new Exception("잘못된 연산자입니다."); // 잘못된 연산자를 입력했을 때 예외를 발생시킴
				
			}
			System.out.println(num1 + " " + op + " " + num2 + " = " + res);
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch(Exception e) {
			System.out.println(e.getMessage()); // 예외 상황을 출력할 때 이용하면 편하다.
		}
		System.out.println("프로그램을 종료합니다.");
		/* 
		if(op == '+')
			System.out.println("" + num1 + " " + op + " " + num2 + " = " + (num1 + num2) );
		if(op == '-')
			System.out.println("" + num1 + " " + op + " " + num2 + " = " + (num1 - num2) );
		if(op == '*')
			System.out.println("" + num1 + " " + op + " " + num2 + " = " + (num1 * num2) );
		try {
			if(op == '/')
				System.out.println("" + num1 + " " + op + " " + num2 + " = " + ((double)num1 / num2) );
			if(op == '%')
				System.out.println("" + num1 + " " + op + " " + num2 + " = " + (num1 % num2) );
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		*/
		scan.close();
	}


}
