package domain;

public class PagingVO {
	
	private int pageNo; // 페이지 번호들 1~10
	private int qty; // 한페이지에 보여줄 게시글 수 => 10개
	
	// 검색관련 멤버변수 추가하기.
	private String type;
	private String keyword;
	
	public PagingVO() {//페이지네이션을 클릭하기 전 기본값으로 지정.
		this(1,10); //2번째 생성자를 자동으로 받음.
	}
	
	public int getPageStart() {
		return (this.pageNo-1)*10; //시작 limit번지 구하는 공식.
	}
	
	//타입을 배열처리한다. (제목 + 내용) 처럼 2가지 정보를 같이 검색하기위해 사용.
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}
	
	public PagingVO(int pageNo, int qty) { //생성자
		this.pageNo = pageNo;
		this.qty = qty;
	}
	
	
	//getter, setter 설정
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
