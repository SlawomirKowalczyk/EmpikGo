package com.empik.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class GitHubEntity {

    @JsonProperty("fullName")
    private String fullNameOfRepository;

    @JsonProperty("description")
    private String descriptionOfRepository;

    @JsonProperty("cloneUrl")
    private String gitCloneUrlRepository;

    @JsonProperty("stars")
    private Integer numberOfStargazersOfRepository;

    @JsonProperty("createdAt")
    private LocalDateTime dateOfCreationRepository;
}