package com.example.webclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ResponseService {

    //simplest way of creating webclient
     WebClient webclient = WebClient.create();


    public void getClientResp(){
        WebClient.ResponseSpec responseSpec = webclient.get()
                .uri("https://reqres.in/api/users/2")
                .retrieve();

        String responseBody = responseSpec.bodyToMono(String.class).block();

        System.out.println(responseBody);

    }
}
