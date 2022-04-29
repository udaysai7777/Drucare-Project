package com.starter.spring.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@RequestMapping("/hello")
	public String getHello() {
		return "Hello Good Morning";
	}
	@RequestMapping("/hi")
	public String getHi() {
		return "Hi Good morning ,Good Afternoon,Good Day";
	}

	private TopicService topicservice;
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
	return topicservice.getAllTopics();
			}
	@GetMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicservice.getTopic(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic);
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicservice.updateTopic(id,topic);
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicservice.deleteTopic(id, topic);
		
	}
}

	
	


	
	


