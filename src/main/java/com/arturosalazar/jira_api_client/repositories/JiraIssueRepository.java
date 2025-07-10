package com.arturosalazar.jira_api_client.repositories;

import com.arturosalazar.jira_api_client.entities.JiraIssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JiraIssueRepository extends JpaRepository<JiraIssueEntity, Long> {
}
