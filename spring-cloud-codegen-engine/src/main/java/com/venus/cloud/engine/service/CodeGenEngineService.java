package com.venus.cloud.engine.service;

import java.io.File;

import com.venus.cloud.generator.ProjectRequest;

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

    /**
     *
     * @param dir 空工程目录的
     * @param extension 下载压缩包扩展 zip
     * @return
     */
    public File createDistributionFile(File dir, String extension);


}
