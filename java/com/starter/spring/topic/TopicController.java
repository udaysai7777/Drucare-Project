package com.starter.spring.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@RequestMapping("/topic")
	public List<Topic> getAllTopics()
	{
		return Arrays.asList(new Topic("3","Cricket","all about detailed information"),
				new Topic("6","Cinema","all about detailed information"),
				new Topic("9","java","all about detailed information"),
				new Topic("12","spring","all about detailed information"));
	}

}
