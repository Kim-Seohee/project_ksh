package etc;

public class StudentTest {

	public static void main(String[] args) {
		Student st = new Student(1, 1, 1, "홍길동");
		st.print();
	}
}
class Student{
	private int grade; //학년
	private int classNum; //반
	private int num; //번호
	private String name; //이름
	//기본생성자
	public Student() {}
	//생성자
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	//학생 정보 출력 메소드
	public void print() {
		System.out.println("학년: " + grade);
		System.out.println("반: " + classNum);
		System.out.println("번호: " + num);
		System.out.println("이름: " + name);
	}
	//게터, 세터
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}