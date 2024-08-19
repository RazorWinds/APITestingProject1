package Pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Spartan implements Pojo{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("university")
	private String university;

	@JsonProperty("graduated")
	private boolean graduated;

	@JsonProperty("degree")
	private String degree;

	@JsonProperty("course")
	private Course course;

	@JsonProperty("id")
	private int id;

	@JsonProperty("courseId")
	private int courseId;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setUniversity(String university){
		this.university = university;
	}

	public String getUniversity(){
		return university;
	}

	public void setGraduated(boolean graduated){
		this.graduated = graduated;
	}

	public boolean isGraduated(){
		return graduated;
	}

	public void setDegree(String degree){
		this.degree = degree;
	}

	public String getDegree(){
		return degree;
	}

	public void setCourse(Course course){
		this.course = course;
	}

	public Course getCourse(){
		return course;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCourseId(int courseId){
		this.courseId = courseId;
	}

	public int getCourseId(){
		return courseId;
	}
}