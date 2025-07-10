package com.arturosalazar.jira_api_client.controllers;

import com.arturosalazar.jira_api_client.dto.JiraIssueRequest;
import com.arturosalazar.jira_api_client.services.JiraIssueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jira")
public class JiraIssueController {
    private JiraIssueService jiraIssueService;

    public JiraIssueController(JiraIssueService jiraIssueService) {
        this.jiraIssueService = jiraIssueService;
    }

    @PostMapping("/create")
    public void handleCreateIssueRequest(@RequestBody JiraIssueRequest jiraIssueRequest){
        jiraIssueService.createIssue(jiraIssueRequest);
    }
}
