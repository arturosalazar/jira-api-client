package com.arturosalazar.jira_api_client.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    }

    public void createIssue(){
        //Use Rest Template to create
        System.out.println("Jira Domain: " + jiraDomain);
        System.out.println("Jira ID: " + jiraId);
        System.out.println("Jira Token: " + jiraToken);
    }
}
