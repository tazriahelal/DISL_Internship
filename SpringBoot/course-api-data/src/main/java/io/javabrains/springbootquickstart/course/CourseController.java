package io.javabrains.springbootquickstart.course;

import io.javabrains.payload.ResponsePayload;
import io.javabrains.springbootquickstart.course.requests.CourseUpdateRequest;
import io.javabrains.springbootquickstart.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.management.RuntimeErrorException;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	//get all courses corresponding to topic
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	//get course corresponding to course id
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	//Add topic to course class & save to database
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public Course addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		return courseService.addCourse(course);
	}

	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public Course updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {		
		course.setTopic(new Topic(topicId, "", ""));
		return courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
	@RequestMapping("/courses")
	public List<Course> getCourse() {
		return courseService.getAllCourses();
	}
}
