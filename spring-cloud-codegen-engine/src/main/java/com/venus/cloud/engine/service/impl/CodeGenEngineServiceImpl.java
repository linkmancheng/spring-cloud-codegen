package com.venus.cloud.engine.service.impl;

import java.io.File;
import java.util.Map;

import com.venus.cloud.engine.service.CodeGenEngineService;
import io.spring.initializr.generator.CommandLineHelpGenerator;
import io.spring.initializr.generator.ProjectGenerator;
import io.spring.initializr.generator.ProjectRequest;
import io.spring.initializr.metadata.DependencyMetadataProvider;
import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.util.TemplateRenderer;
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
}
