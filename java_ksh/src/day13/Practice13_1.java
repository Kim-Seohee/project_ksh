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