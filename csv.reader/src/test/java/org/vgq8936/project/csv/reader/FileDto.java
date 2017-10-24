package org.vgq8936.project.csv.reader;

import com.univocity.parsers.annotations.Parsed;

public class FileDto {

	@Parsed(index = 0)
	private String name;
	
	@Parsed(index = 1)
	private String age;
	
	@Parsed(index = 2)
	private String grade;
	
	@Parsed(index = 3)
	private String date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FileDto [name=" + name + ", age=" + age + ", grade=" + grade + ", date=" + date + "]";
	}

	
}
