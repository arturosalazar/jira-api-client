package com.arturosalazar.jira_api_client.controllers;

import com.arturosalazar.jira_api_client.dto.JiraIssueDetailResponse;
import com.arturosalazar.jira_api_client.dto.JiraIssueRequest;
import com.arturosalazar.jira_api_client.dto.JiraIssueResponse;
import com.arturosalazar.jira_api_client.services.JiraIssueService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jira")
public class JiraIssueController {
    private JiraIssueService jiraIssueService;

    public JiraIssueController(JiraIssueService jiraIssueService) {
        this.jiraIssueService = jiraIssueService;
    }

    @PostMapping("/create")
    public ResponseEntity<JiraIssueResponse> handleCreateIssueRequest(@RequestBody @Valid JiraIssueRequest jiraIssueRequest){
        return jiraIssueService.createIssue(jiraIssueRequest);
    }

    @GetMapping("/issues")
    public List<JiraIssueDetailResponse> getAllJiraIssues(){
        // return jira issues from a service
        return jiraIssueService.getJiraIssues(); //dummy return item
    }
}
