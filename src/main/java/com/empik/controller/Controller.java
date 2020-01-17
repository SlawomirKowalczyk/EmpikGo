package com.empik.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

interface Controller {

    @GetMapping(("/{owner}/{repositoryName}"))
    ResponseEntity getRepositoryDetails(@PathVariable String owner, @PathVariable String repositoryName);
}