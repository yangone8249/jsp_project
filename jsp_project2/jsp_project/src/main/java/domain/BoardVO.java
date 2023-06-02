package domain;

public class BoardVO {

	private int num;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int counter;
	
	public BoardVO() {}
	
	//register(title, writer, content)
	public BoardVO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	//list(num, title, writer, regdate)
	public BoardVO(int num, String title, String writer, String regdate) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
	}

	//detail(all)
	public BoardVO(int num, String title, String writer, String content, String regdate) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}
	
	//update(num, title, content)
	public BoardVO(int num, String title, String content) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
	}
	
	//getter/setter
	public int getnum() {
		return num;
	}

	public void setnum(int num) {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getregdate() {
		return regdate;
	}

	public void setregdate(String regdate) {
		this.regdate = regdate;
	}
}
