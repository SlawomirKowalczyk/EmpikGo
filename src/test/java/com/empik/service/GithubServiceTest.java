package com.empik.service;

import com.empik.model.GitHubEntity;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static com.empik.common.Constant.*;
import static com.empik.common.ExampleJson.GIT_HUB_JSON;

public class GithubServiceTest {
    private static GithubService githubService;

    @BeforeClass
    public static void setUp() {
        githubService = new GithubService();
    }

    @Test
    public void createEntity() {
        Map mapFromJson = githubService.getMapFromJson(GIT_HUB_JSON);
        GitHubEntity entity = githubService.createEntity(mapFromJson);

        Assert.assertEquals("Full name filed is empty", FULL_NAME, entity.getFullNameOfRepository());
        Assert.assertEquals("Description filed is empty", DESCRIPTION, entity.getDescriptionOfRepository());
        Assert.assertEquals("Clone Url field is empty", CLONE_URL, entity.getGitCloneUrlRepository());
        Assert.assertEquals("Stars field is empty", STARGAZERS_COUNT, entity.getNumberOfStargazersOfRepository().intValue());
        Assert.assertEquals("Created date field is empty", CREATED_AT, entity.getDateOfCreationRepository().toString());
    }

    @Test
    public void getMapFromJson() {
        Map mapFromJson = githubService.getMapFromJson(GIT_HUB_JSON);
        Assert.assertFalse("Repository details map is empty", mapFromJson.isEmpty());
    }
}