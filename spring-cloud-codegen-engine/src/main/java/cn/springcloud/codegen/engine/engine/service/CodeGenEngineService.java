package cn.springcloud.codegen.engine.engine.service;

import java.io.File;

import cn.springcloud.codegen.engine.generator.ProjectRequest;

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
     *  填充模板
     * @param dir 空工程目录的
     * @param extension 下载压缩包扩展 zip
     * @return
     */
    public File createDistributionFile(File dir, String extension);


    public String getWrapperScript(ProjectRequest request);



}
