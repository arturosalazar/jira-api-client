package com.arturosalazar.jira_api_client.services;

import com.arturosalazar.jira_api_client.dto.JiraIssueDetailResponse;
import com.arturosalazar.jira_api_client.dto.JiraIssueRequest;
import com.arturosalazar.jira_api_client.dto.JiraIssueResponse;
import com.arturosalazar.jira_api_client.entities.JiraIssueEntity;
import com.arturosalazar.jira_api_client.repositories.JiraIssueRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JiraIssueService {

    @Value("${jira.domain}")
    private String jiraDomain;

    @Value("${jira.id}")
    private String jiraId;

    @Value("${jira.token}")
    private String jiraToken;

    private RestTemplate restTemplate;

    private JiraIssueRepository jiraIssueRepository;

    public JiraIssueService(RestTemplate restTemplate, JiraIssueRepository jiraIssueRepository){
        this.restTemplate = restTemplate;
        this.jiraIssueRepository = jiraIssueRepository;
    }

    public ResponseEntity<JiraIssueResponse> createIssue(JiraIssueRequest jiraIssueRequest){
        // Request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String authString = jiraId + ":" + jiraToken;
        // Convert auth string to Base 64 per Jira API Basic authentication requirements
        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
        headers.set("Authorization", "Basic " + encodedAuthString);

        // Request body
        String requestBody = String.format("""
                {
                  "fields": {
                    "project": {
                      "key": "SCRUM"
                    },
                    "summary": "%s",
                    "description": {
                      "type": "doc",
                      "version": 1,
                      "content": [
                        {
                          "type": "paragraph",
                          "content": [
                            {
                              "type": "text",
                              "text": "%s"
                            }
                          ]
                        }
                      ]
                    },
                    "issuetype": {
                      "name": "%s"
                    }
                  }
                }
                
                """, jiraIssueRequest.getSummary(), jiraIssueRequest.getDescription(), jiraIssueRequest.getIssueType());

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Request domain
        String requestDomain = jiraDomain + "/rest/api/3/issue";
        ResponseEntity<JiraIssueResponse> response = restTemplate.exchange(
                requestDomain,          // URL
                HttpMethod.POST,        // HTTP Method
                requestEntity,          // Request Entity (body and headers)
                JiraIssueResponse.class            // Expected Response Type
        );

        // If Jira Issue created, then save information to database
        if(response.getStatusCode().is2xxSuccessful()){
            // Use DTO to retrieve data from response
            JiraIssueResponse responseBody = response.getBody();

            JiraIssueEntity entity = new JiraIssueEntity();
            entity.setSummary(jiraIssueRequest.getSummary());
            entity.setDescription(jiraIssueRequest.getDescription());
            entity.setJiraIssueType(jiraIssueRequest.getIssueType());
            entity.setJiraKey(responseBody.getKey());
            entity.setJiraID(responseBody.getId());

            jiraIssueRepository.save(entity);
        }

        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());

        return response;

    }

    public List<JiraIssueDetailResponse> getJiraIssues() {
        List<JiraIssueDetailResponse> response = jiraIssueRepository
                .findAll()
                .stream()
                .map(entity -> new JiraIssueDetailResponse(entity))
                .collect(Collectors.toList());
        return response;
    }
}
