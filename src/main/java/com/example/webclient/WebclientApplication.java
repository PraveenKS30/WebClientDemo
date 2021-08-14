package com.example.webclient;

import com.example.webclient.service.ResponseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebclientApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(WebclientApplication.class, args);
		ResponseService resp = applicationContext.getBean(ResponseService.class);
		resp.getClientResp();
	}

}
