package com.arturosalazar.jira_api_client.dto;

import com.arturosalazar.jira_api_client.entities.JiraIssueEntity;

import java.time.LocalDateTime;


public class JiraIssueDetailResponse {
    private Long id;

    private String summary;
    private String description;
    private String jiraIssueType;
    private String jiraID;
    private String jiraKey;

    private LocalDateTime createdAt;

    public JiraIssueDetailResponse() {    }

    public JiraIssueDetailResponse(JiraIssueEntity jiraIssueEntity) {
        this.id = jiraIssueEntity.getId();
        this.summary = jiraIssueEntity.getSummary();
        this.description = jiraIssueEntity.getDescription();
        this.jiraIssueType = jiraIssueEntity.getJiraIssueType();
        this.jiraID = jiraIssueEntity.getJiraID();
        this.jiraKey = jiraIssueEntity.getJiraKey();
        this.createdAt = jiraIssueEntity.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJiraIssueType() {
        return jiraIssueType;
    }

    public void setJiraIssueType(String jiraIssueType) {
        this.jiraIssueType = jiraIssueType;
    }

    public String getJiraID() {
        return jiraID;
    }

    public void setJiraID(String jiraID) {
        this.jiraID = jiraID;
    }

    public String getJiraKey() {
        return jiraKey;
    }

    public void setJiraKey(String jiraKey) {
        this.jiraKey = jiraKey;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
