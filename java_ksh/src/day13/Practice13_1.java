package day13;

public class Practice13_1 {

	public static void main(String[] args) {
		P p = new C();
		C c = (C)p; // 가능
		
		P p2 = new P();
		// C c2 = (C)p2; // 예외 발생
		
	}

}
class P{
	
}
class C extends P{
	
}
class D{
	public void print(){}
	public void print(int num){}
	/* public void print(){ // 중복된 메소드명 오류
		int num = 0;
	} */
}