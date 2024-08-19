package Pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinksItem{

	@JsonProperty("method")
	private String method;

	@JsonProperty("rel")
	private String rel;

	@JsonProperty("href")
	private String href;

	public void setMethod(String method){
		this.method = method;
	}

	public String getMethod(){
		return method;
	}

	public void setRel(String rel){
		this.rel = rel;
	}

	public String getRel(){
		return rel;
	}

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}
}