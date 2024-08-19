package Pojos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stream{

	@JsonProperty("courses")
	private List<String> courses;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	public void setCourses(List<String> courses){
		this.courses = courses;
	}

	public List<String> getCourses(){
		return courses;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}