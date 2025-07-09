package com.arturosalazar.jira_api_client.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class JiraIssueService {

    @Value("${jira.domain}")
    private String jiraDomain;

    @Value("${jira.id}")
    private String jiraId;

    @Value("${jira.token}")
    private String jiraToken;

    private RestTemplate restTemplate;

    public JiraIssueService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void createIssue(){
        // Request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String authString = jiraId + ":" + jiraToken;
        // Convert auth string to Base 64 per Jira API Basic authentication requirements
        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
        headers.set("Authorization", "Basic " + encodedAuthString);

        // Request body
        String requestBody = """
                {
                  "fields": {
                    "project": {
                      "key": "SCRUM"
                    },
                    "summary": "Example Task Summary",
                    "description": {
                      "type": "doc",
                      "version": 1,
                      "content": [
                        {
                          "type": "paragraph",
                          "content": [
                            {
                              "type": "text",
                              "text": "This is a simple task created via the Jira API."
                            }
                          ]
                        }
                      ]
                    },
                    "issuetype": {
                      "name": "Task"
                    }
                  }
                }
                
                """;

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Request domain
        String requestDomain = jiraDomain + "/rest/api/3/issue";
        ResponseEntity<String> response = restTemplate.exchange(
                requestDomain,          // URL
                HttpMethod.POST,        // HTTP Method
                requestEntity,          // Request Entity (body and headers)
                String.class            // Expected Response Type
        );

        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());

    }
}
