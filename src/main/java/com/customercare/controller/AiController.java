package com.customercare.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customercare.service.AIService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/customercare")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class AiController {

    @Autowired
    private   AIService service;

    @PostMapping
    public ResponseEntity<String >  getResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return ResponseEntity.ok(service.getResponseFromAssistant(query,conversationId));
    }


    @PostMapping(value = "/stream")
    public Flux<String> streamResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return this.service.streamResponseFromAssistant(query,conversationId) ;
    }



}
