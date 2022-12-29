package edu.kh.collection.model.vo;

import java.util.Objects;

public class Member {
	
	private String id;
	private String pw;
	private int age;
	
	
	public Member() {
		
	}


	public Member(String id, String pw, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
	}


	public String getId() {
		return id;
	}


	public String getPw() {
		return pw;
	}


	public int getAge() {
		return age;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	// Object.equals() 오버라이딩 
	// - 현재 객체와 매개변수로 전달받은 객체의 필드가 같은지 비교하는 형태로 오버라이딩
	// 어렵다 말이 어려워
	// Object.hashCode() 오버라이딩
	
	//set 사용할 때, 무적건 사용
	
	@Override
	public int hashCode() {
		return Objects.hash(age, id, pw);
	}


	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(pw, other.pw);
	}

	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", age=" + age + "]";
	}
	
	
	
	
	
	

}
