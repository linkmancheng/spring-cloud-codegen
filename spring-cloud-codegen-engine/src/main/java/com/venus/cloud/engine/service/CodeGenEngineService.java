package com.venus.cloud.engine.service;

import java.io.File;

import io.spring.initializr.generator.ProjectRequest;

/**
 * @author xujin
 */
public interface CodeGenEngineService {

    /**
     * 生成工程结构 Maven或者Gradle
     * @param request
     * @return
     */
    public File generateProjectStructure(ProjectRequest request);
}
