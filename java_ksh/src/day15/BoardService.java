package day15;

public interface BoardService {
	/* 기능: 게시글을 등록하는 메소드 => 게시글 제목, 내용, 작성자, 작성일이 주어지면 게시글을 등록하는 메소드
	 * 매개변수: 게시글 정보 => Board board
	 * 리턴타입: 없음 => void
	 * 메소드명: insertBoard
	 * */
	public void insertBoard(Board board); // 인터페이스에서는 접근제한자를 생략하면 기본으로 public이 들어감(default 아님)
	/* 기능: 게시글을 삭제하는 메소드 => 게시글 번호가 주어지면 해당 번호 게시글을 삭제한 후 삭제 여부를 알려주는 메소드
	 * 매개변수: 삭제할 게시글 번호 => int num
	 * 리턴타입: 삭제 여부 => boolean
	 * 메소드명: deleteBoard
	 * */
	public boolean deleteBoard(int num);
	/* 기능: 게시글을 수정하는 메소드 => 게시글 번호와 수정할 게시글정보(제목, 내용)이 주어지면 게시글을 수정하는 메소드
	 * 매개변수: 게시글 번호와 수정할 게시글 정보 => Board board
	 * 리턴타입: 없음 => void
	 * 메소드명: modifyBoard
	 * */
	public void modifyBoard(Board board);
	/* 기능: 게시글의 번호가 주어지면 게시글을 전달하는 메소드 => 게시글 번호가 주어지면 주어진 게시글에 대한 게시글 정보(제목, 내용, 작성자, 작성일)를 알려주는 메소드
	 * 매개변수: 게시글의 번호 => int num
	 * 리턴타입: 게시글 정보 => Board
	 * 메소드명: getBoard
	 * */
	public Board getBoard(int num);
	/* 기능: 게시글 전체 리스트를 가져오는 메소드 => 게시글 정보(제목, 내용, 작성자, 작성일)들을 가져오는 메소드
	 * 매개변수: 없음
	 * 리턴타입: 게시글 정보들 => Board []
	 * 메소드명: getBoardList
	 * */
	public Board[] getBoardList();
	/* 기능: 검색어가 들어간 게시글 리스트를 가져오는 메소드
	 * 매개변수: 검색어 => String search
	 * 리턴타입: 검색된 게시글 정보들 => Board []
	 * 메소드명: getBoardList
	 * */
	public Board[] getBoardList(String search); // 메소드 오버로딩
}

class Board{
	int num;
	String title;
	String contents;
	String writer;
	String registerDate;
}