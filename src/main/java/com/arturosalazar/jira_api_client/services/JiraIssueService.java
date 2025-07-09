package com.arturosalazar.jira_api_client.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JiraIssueService {

    private RestTemplate restTemplate;

    public JiraIssueService(RestTemplate restTemplate){
    }

    public void createIssue(){
        //Use Rest Template to create
    }
}
