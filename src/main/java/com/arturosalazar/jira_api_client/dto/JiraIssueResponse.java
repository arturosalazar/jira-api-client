package com.arturosalazar.jira_api_client.dto;

public class JiraIssueResponse {
    private String id;
    private String key;
    private String self;

    public JiraIssueResponse() {    }

    public JiraIssueResponse(String id, String key) {
        this.id = id;
        this.key = key;
        this.self = self;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }
}
