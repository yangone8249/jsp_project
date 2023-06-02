package domain;

public class memberVO {

	/*
	 * num int auto id varchar password var email var age int regdate var default
	 * now() lastLogin var
	 */
	private int num;
	private String id;
	private String password;
	private String email;
	private int age;
	private String regdate;
	private String lastLogin;

	public memberVO() {
	}

	// 회원가입 생성자
	public memberVO(String id, String password, String email, int age) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.age = age;
	}

	// 로그인 생성자
	public memberVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getregdate() {
		return regdate;
	}

	public void setregdate(String regdate) {
		this.regdate = regdate;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
}
