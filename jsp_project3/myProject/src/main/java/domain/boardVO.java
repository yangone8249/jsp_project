package domain;

public class boardVO {
	private int num;
	private String title;
	private String writer;
	private String regdate;
	private String detail;
	private int counter;
	private String image;
	
	
	// update  생성자
	public boardVO(int num, String title, String detail) {
		super();
		this.num = num;
		this.title = title;
		this.detail = detail;
	}
	// create 생성자
	public boardVO(String title, String writer, String detail) {
		super();
		this.title = title;
		this.writer = writer;
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "boardVO [num=" + num + ", title=" + title + ", writer=" + writer + ", regdate=" + regdate + ", detail="
				+ detail + ", counter=" + counter + ", image=" + image + "]";
	}
	public boardVO() {
		// 기본 생성자
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image_file) {
		this.image = image_file;
	}
}
