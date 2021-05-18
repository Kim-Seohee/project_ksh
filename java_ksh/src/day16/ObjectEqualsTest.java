package day16;

public class ObjectEqualsTest {

	public static void main(String[] args) {
		String str1 = new String("abcd");
		String str2 = str1;
		System.out.println("str2 = str1");
		System.out.println("두 문자열 주소 비교: " + (str1 == str2));
		System.out.println("str2 = new String(\"abcd\")");
		str2 = new String("abcd");
		System.out.println("두 문자열 주소 비교: " + (str1 == str2));
		System.out.println("두 문자열 비교: " + str1.equals(str2));
		
		Num n1 = new Num();
		Num n2 = new Num(); // new를 통해 만들어진 객체는 주소가 다 다르다.
		System.out.println("n1과 n2 주소 비교: " + (n1 == n2));
		System.out.println("n1과 n2가 같다: " + (n1.equals(n2)));
		n2.setNum(10);
		System.out.println("n1과 n2가 같다: " + (n1.equals(n2)));
	}
}

class Num{
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	/* 
	@Override
	public boolean equals(Object obj) { // 매개변수로 다양한 클래스가 올 수 있다.(다형성)
		if(obj == null) { // 객체가 만들어지지 않았으면 비교할 필요가 없다.
			return false;
		}
		// 매개변수 obj를 Num 클래스의 객체로 타입변환이 가능하지 않다면 
		// false를 리턴한다: 다른 클래스의 객체와 비교할 필요가 없어서
		if(! (obj instanceof Num)) {
			return false;
		}
		// 매개변수의 num와 내 num가 같은지를 비교
		Num tmp = (Num)obj;
		if(num == tmp.num) {
			return true;
		}
		return false;
	}
	*/

	@Override
	public int hashCode() {
		// 20개씩 하나의 그룹으로 묶어준다.
		return num / 20;
	}

	@Override
	public boolean equals(Object obj) {
		// 주소가 같으면 같은 값을 공유하기 때문에 무조건 true이다.
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// 클래스가 같지 않은 경우 false이다.
		if (getClass() != obj.getClass())
			return false;
		// 위의 코드와 반대로 작성함.
		Num other = (Num) obj;
		if (num != other.num) // num은 일반변수
			return false;
		return true;
	}
	
}
class Test{
	Name name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		// 밑의 부분이 Num 클래스에서와 다름, name이 참조변수이기 때문에 조금 더 복잡함
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) // Name의 equals로 비교, Name에 equals를 오버라이딩 하지 않았으면 주소를 비교하게 됨.
			return false;
		return true;
	}
	
}

class Name{
	String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
