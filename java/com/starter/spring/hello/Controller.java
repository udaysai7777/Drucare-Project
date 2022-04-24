package com.starter.spring.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Controller {

@RequestMapping("/hi")	
public String sayhello() {
return "Hello";
}
}
