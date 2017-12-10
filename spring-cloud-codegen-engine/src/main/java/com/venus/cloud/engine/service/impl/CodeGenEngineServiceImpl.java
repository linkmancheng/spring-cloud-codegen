package com.venus.cloud.engine.service.impl;

import java.io.File;

import com.venus.cloud.engine.service.CodeGenEngineService;
import com.venus.cloud.generator.CommandLineHelpGenerator;
import com.venus.cloud.generator.ProjectGenerator;
import com.venus.cloud.generator.ProjectRequest;
import com.venus.cloud.metadata.DependencyMetadataProvider;
import com.venus.cloud.metadata.InitializrMetadataProvider;
import com.venus.cloud.util.TemplateRenderer;
import org.springframework.stereotype.Service;

@Service
public class CodeGenEngineServiceImpl implements CodeGenEngineService {

    private final ProjectGenerator projectGenerator;
    private final DependencyMetadataProvider dependencyMetadataProvider;
    private final CommandLineHelpGenerator commandLineHelpGenerator;

    public CodeGenEngineServiceImpl(InitializrMetadataProvider metadataProvider,
                          TemplateRenderer templateRenderer,
                          ProjectGenerator projectGenerator,
                          DependencyMetadataProvider dependencyMetadataProvider) {
        this.projectGenerator = projectGenerator;
        this.dependencyMetadataProvider = dependencyMetadataProvider;
        this.commandLineHelpGenerator = new CommandLineHelpGenerator(templateRenderer);
    }

    @Override
    public File generateProjectStructure(ProjectRequest request) {
        return projectGenerator.generateProjectStructure(request);
    }

    @Override
    public File createDistributionFile(File dir, String extension) {
        return projectGenerator.createDistributionFile(dir, extension);
    }

    @Override
    public String getWrapperScript(ProjectRequest request) {
        String script = "gradle".equals(request.getBuild()) ? "gradlew" : "mvnw";
        return request.getBaseDir() != null
            ? request.getBaseDir() + "/" + script : script;
    }
}
