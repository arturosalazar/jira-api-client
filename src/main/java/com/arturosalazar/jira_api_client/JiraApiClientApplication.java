package com.arturosalazar.jira_api_client;

import com.arturosalazar.jira_api_client.config.ProjectConfig;
import com.arturosalazar.jira_api_client.dto.JiraIssueRequest;
import com.arturosalazar.jira_api_client.services.JiraIssueService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JiraApiClientApplication {

	final private JiraIssueService jiraIssueService;

	public JiraApiClientApplication(JiraIssueService jiraIssueService){
		this.jiraIssueService = jiraIssueService;
	}

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		SpringApplication.run(JiraApiClientApplication.class, args);
	}

}
