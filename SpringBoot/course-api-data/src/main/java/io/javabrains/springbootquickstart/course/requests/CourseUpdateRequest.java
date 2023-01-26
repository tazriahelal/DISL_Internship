package io.javabrains.springbootquickstart.course.requests;

import org.springframework.lang.NonNull;

public class CourseUpdateRequest {

	@NonNull
	private String id;

	@NonNull
	private String name;
	
	private String description;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
