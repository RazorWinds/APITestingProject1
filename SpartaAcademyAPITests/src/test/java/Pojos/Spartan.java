package Pojos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Spartan implements Pojo{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("stream")
	private String stream;

	@JsonProperty("university")
	private String university;

	@JsonProperty("graduated")
	private boolean graduated;

	@JsonProperty("degree")
	private String degree;

	@JsonProperty("course")
	private String course;

	@JsonProperty("links")
	private List<LinksItem> links;

	@JsonProperty("id")
	private int id;

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

	public void setStream(String stream){
		this.stream = stream;
	}

	public String getStream(){
		return stream;
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

	public void setCourse(String course){
		this.course = course;
	}

	public String getCourse(){
		return course;
	}

	public void setLinks(List<LinksItem> links){
		this.links = links;
	}

	public List<LinksItem> getLinks(){
		return links;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}