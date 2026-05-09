package com.customercare.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.customercare.tools.EmailTool;
import com.customercare.tools.TicketDatabaseTool;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class AIService {

	@Autowired
    private  ChatClient chatClient;

	@Autowired
    private  TicketDatabaseTool ticketDatabaseTool;
	@Autowired
    private  EmailTool emailTool;

    @Value("classpath:/ai-prompt.st")
    private Resource systemPromptResource;

    public String getResponseFromAssistant(String query, String conversationId) {

        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                .tools(ticketDatabaseTool, emailTool)
                .system(systemPromptResource)
                .user(query)
                .call()
                .content();


    }

    public Flux<String> streamResponseFromAssistant(String query, String conversationId) {


        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                .tools(ticketDatabaseTool, emailTool)
                .system(systemPromptResource)
                .user(query)
                .stream().content();

    }


}
