package com.customercare.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class EmailTool {

    @Tool(description = "This tool helps to send email to support team .")
    public void sendEmailToSupportTeam(@ToolParam(description = "Email id associated with ticket for contact information.") String email, @ToolParam(description = "Short descriptoin of ticket summary.") String message){
        
        System.out.println("email send");
        System.out.println("email id : "+email);
        System.out.println("message : "+message);


    }

}
