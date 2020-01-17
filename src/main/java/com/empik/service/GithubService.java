package com.empik.service;

import com.empik.model.GitHubEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@CacheConfig(cacheNames = {"gitHub"})
@NoArgsConstructor
public class GithubService {

    @Cacheable
    public ResponseEntity getRepositoryDetails(String owner, String repositoryName) {
        Map map = getMapFromJson(getResponseBody(owner, repositoryName));
        return new ResponseEntity<>(createEntity(map), HttpStatus.OK);
    }

    Map getMapFromJson(String json) {
        Map jsonMap = new HashMap();
        try {
            jsonMap = new ObjectMapper().readValue(json, Map.class);
            log.debug("Convert json to map is pass");
        } catch (IOException ex) {
            log.error("Convert json to map is failed", ex);
        }
        return jsonMap;
    }

    private String getResponseBody(String owner, String repositoryName) {
        ResponseEntity<String> exchange = new RestTemplate().exchange(
                "https://api.github.com/repos/" + owner + "/" + repositoryName,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class);
        log.debug("Connect with url ['https://api.github.com/repos/' 'owner' = " + owner + " 'repositoryName' = " + repositoryName + "");
        log.info("Connect with github api and get response ['owner' = " + owner + " 'repositoryName' = " + repositoryName + "]");
        return exchange.getBody();
    }

    GitHubEntity createEntity(Map map) {
        final String FULL_NAME = "full_name";
        final String DESCRIPTION = "description";
        final String CLONE_URL = "clone_url";
        final String CREATED_AT = "created_at";
        final String STARGAZERS_COUNT = "stargazers_count";
        return GitHubEntity.builder()
                .fullNameOfRepository(map.get(FULL_NAME).toString())
                .descriptionOfRepository(map.get(DESCRIPTION).toString())
                .gitCloneUrlRepository(map.get(CLONE_URL).toString())
                .numberOfStargazersOfRepository((int) map.get(STARGAZERS_COUNT))
                .dateOfCreationRepository(CurrentDateTime.valueOf(map.get(CREATED_AT).toString())).build();
    }
}