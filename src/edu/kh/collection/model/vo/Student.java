package edu.kh.collection.model.vo;

public class Student {
	
	// 필드
	private String name;
	private int age;
	private String region;
	private char gender; // (M/F)
	private int score;
	
	// 생성자
	
	public Student() {
		
	}

	public Student(String name, int age, String region, char gender, int score) {
		
		this.name = name;
		this.age = age;
		this.region = region;
		this.gender = gender;
		this.score = score;
	}

	// 메서드
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getRegion() {
		return region;
	}

	public char getGender() {
		return gender;
	}

	public int getScore() {
		return score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// toString() 오버라이딩 자동 완성
	// alt + shift + s + generate
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", region=" + region + ", gender=" + gender + ", score="
				+ score + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
