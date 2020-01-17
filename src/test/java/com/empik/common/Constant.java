package com.empik.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
    private static final String OWNER = "rzwitserloot";
    private static final String REPOSITORY_NAME = "lombok";
    public static final String FULL_NAME = OWNER + "/" + REPOSITORY_NAME;
    public static final String DESCRIPTION = "Very spicy additions to the Java programming language.";
    public static final String CLONE_URL = "https://github.com/" + OWNER + "/" + REPOSITORY_NAME + ".git";
    public static final String CREATED_AT = "2009-06-08T19:46:41";
    public static final int STARGAZERS_COUNT = 8788;
}