package board;

public class Board {
	/* 게시글(카페 게시글, 뉴스, 공지사항 등)에 필요한 멤버 변수를 선언하세요. 
	 * - 제목, 내용, 작성자, 등록시간, 조회수, 좋아요 수, 게시글 번호, 게시글 타입
	 * */
	private int num;
	private String title = ""; // new String();도 당연히 가능함, 빈 문자열도 String에서는 가능함
	private String contents = new String();
	private String writer = "";
	private String registerDate = "";
	private int views;
	private int like;
	private String type = "";
	
	// 생성자를 만들어보세요.
	public Board(int num, String title, String contents, String writer, String registerDate, String type) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.registerDate = registerDate;
		this.type = type;
	}
	/* 기능: 게시글 정보 출력하는 메소드
	 * 매개변수: 없음
	 * 리턴타입: 없음 => void
	 * 메소드명: print
	 * */
	public void print() {
		views += 1; // 조회수 증감 작업은 이 메소드 안에서 해 주는게 편하다.
		System.out.println("번호: " + num);
		System.out.println("제목: " + title);
		System.out.println("작성자: " + writer);
		System.out.println("조회수: " + views);
		System.out.println("좋아요: " + like);
		System.out.println("작성일: " + registerDate);
		System.out.println("내용: " + contents);
	}
	/* 기능: 게시글 정보를 요약(번호, 제목, 작성자, 작성일, 조회수)해서 출력하는 기능
	 * 매개변수: 없음
	 * 리턴타입: 없음
	 * 메소드명: summaryPrint
	 * */
	public void summaryPrint() {
		System.out.print(num + " ");
		System.out.print(title + " ");
		System.out.print(writer + " ");
		System.out.print(registerDate + " ");
		System.out.print(views + " ");
		System.out.println();
	}
	/* 기능: 제목과 내용을 수정하는 메소드 
	 * 매개변수: 수정할 제목, 내용 => String title, String contents
	 * 리턴타입: 없음 => void
	 * 메소드명: edit
	 * */
	public void edit(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
	
}
