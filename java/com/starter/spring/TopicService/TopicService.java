package com.starter.spring.topic;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	public List<Topic> getAllTopics(){
		
		List<Topic> topics=new ArrayList<>();				
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
		
	}
	public Topic getTopic(String id) {
		//return topicRepository.stream().filter(t-> t.findById(id).equals(id)).findFirst().get();
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}
	public void updateTopic(String id,Topic topic) {
		topicRepository.save(topic);
				
			}
		
		
	
	public void deleteTopic(String id, Topic topic) {
		//topics.removeIf(t->t.getId().equals(id));
		topicRepository.deleteById(id);
	}

}

	


















		


