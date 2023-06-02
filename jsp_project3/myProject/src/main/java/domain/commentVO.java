package domain;

public class commentVO {
/* 

	cno int not null auto_INCREMENT,
	bno int DEFAULT 0,
	writer varchar(100) DEFAULT "unknown",
	content varchar(1000) not null,
	regdate datetime DEFAULT now(),
	primary key(cno));
 */
	private int cno;
	private int bno;
	private String writer;
	private String content;
	private String regdate;
	
	
	//post(bno, writer, content)
		public commentVO(int bno, String writer, String content) {
			super();
			this.bno = bno;
			this.writer = writer;
			this.content = content;
		}
	//modify(cno, content)
		public commentVO(int cno, String content) {
			super();
			this.cno = cno;
			this.content = content;
		}
	
	
	//list(bno, cno, writer, content, regdate)
	public commentVO(int cno, int bno, String writer, String content, String regdate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "commentVO [cno=" + cno + ", bno=" + bno + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
}
