package kr.green.test.pagination;

public class Criteria {
	//현재 페이지
	private int page; 
	//한 페이지 당 컨텐츠 갯수
	private int perPageNum;
	// 검색에 필요한 변수
	private int type;
	private String search;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	//Criteria 디폴트 생성자 : 현재 페이지를 1페이지로, 한 페이지에 10개의 컨텐츠
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
//		this.type = 0; // int 초기값은 초기화를 안 해도 0임
		this.search = "";
	}
	//getter and setter
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		//현재 페이지 번호를 음수로 설정하려 할 때
		if(page <= 0) {
			this.page = 1;
		}
		else
			this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
		}
		else
			this.perPageNum = perPageNum;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", type=" + type + ", search=" + search + "]";
	}
	/* 쿼리문에서 limit에 사용되는 인덱스를 계산하는 getter */
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
}
