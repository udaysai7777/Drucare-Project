package com.Course.Topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics=	Arrays.asList(new Topic("A101","Spring","Detailed Information"),
			new Topic("A102","Java","Detailed Information"),
		   new Topic("A103","Html","Detailed Information"));

public List<Topic> getAllTopics(){
	return topics;
}
}