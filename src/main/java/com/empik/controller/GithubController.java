package com.empik.controller;

import com.empik.service.GithubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/repositories")
public class GithubController implements Controller {
    private final GithubService githubService;

    @Override
    @GetMapping(("/{owner}/{repositoryName}"))
    public ResponseEntity getRepositoryDetails(@PathVariable String owner, @PathVariable String repositoryName) {
        ResponseEntity repositoryDetails = githubService.getRepositoryDetails(owner, repositoryName);
        log.info("Returned repository details ['owner' = " + owner + " 'repositoryName' = " + repositoryName + "]");
        return repositoryDetails;
    }
}