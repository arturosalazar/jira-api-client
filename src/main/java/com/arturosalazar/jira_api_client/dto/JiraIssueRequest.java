package com.arturosalazar.jira_api_client.dto;

import jakarta.validation.constraints.NotBlank;

public class JiraIssueRequest {
    @NotBlank(message = "Summary is required")
    private String summary;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Issue type is required")
    private String issueType;

    public JiraIssueRequest() {
    }

    // Convenience Constructor to help with tests
    public JiraIssueRequest(String summary, String description, String issueType) {
        this.summary = summary;
        this.description = description;
        this.issueType = issueType;
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

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }
}
