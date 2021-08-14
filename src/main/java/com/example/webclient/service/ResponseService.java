package com.example.webclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ResponseService {

    //simplest way of creating webclient
     WebClient webclient = WebClient.create();


    public void getClientResp(){
        WebClient.ResponseSpec responseSpec = webclient.get()
                .uri("https://reqres.in/api/users?page=2")
                .retrieve();

        //As a reactive API, the request is not actually sent until something attempts to read or wait for the response.
        // to invoke the request, we are trying to read the response using bodyToMono
        //It’s possible to pass different classes here to parse content automatically into an appropriate format
        String responseBody = responseSpec.bodyToMono(String.class).block();

        System.out.println(responseBody);

        /* points to be noted

        RESPONSE CODE :

        Note that we’re not checking the status here ourselves.
        When we use .retrieve(), the client automatically checks the status code for us,
        providing a sensible default by throwing an error for any 4xx or 5xx responses.
         */

    }

    public void getClientRespWithHeaders(){
        /* This data is easily available within the WebClient API too, using the .toEntity() API,
        which gives us a ResponseEntity, wrapped in a Mono
         */
        ResponseEntity<String> response = webclient.get()
                .uri("https://reqres.in/api/users?page=2")
                .retrieve()
                .toEntity(String.class)
                .block();

        System.out.println(response.getHeaders());
        System.out.println(response);
    }
}
