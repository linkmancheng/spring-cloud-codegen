package com.venus.cloud.codegen.controller;

/**
 * <p>Title: Nepxion Skeleton Generator</p>
 * <p>Description: Nepxion Skeleton Generator For Freemarker</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @email 1394997@qq.com
 * @version 1.0
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.venus.cloud.codegen.entity.SkeletonGroup;
import com.venus.cloud.codegen.example.server.java.MyApplicationClassGenerator;
import com.venus.cloud.codegen.example.service.resources.MybatisGeneratorXmlGenerator;
import com.venus.cloud.codegen.property.SkeletonProperties;
import com.venus.cloud.codegen.transport.SkeletonConfigTransport;
import com.venus.cloud.codegen.transport.SkeletonDataTransport;

@RestController
@Api(tags = { "脚手架接口" })
public class SkeletonController {
    public static final String SPRING_CLOUD_SKELETON = "spring-cloud-skeleton-";

    @Value("${skeleton.generate.path}")
    private String skeletonGeneratePath;

    private SkeletonDataTransport dataTransport;
    private SkeletonConfigTransport configTransport;

    @PostConstruct
    private void initialize() {
        dataTransport = new SkeletonDataTransport() {
            @Override
            public void generate(String path, SkeletonProperties skeletonProperties) throws Exception {
                new MyApplicationClassGenerator(path, "server", skeletonProperties).generate();
                new MybatisGeneratorXmlGenerator(path, "service", skeletonProperties).generate();
            }
        };

        configTransport = new SkeletonConfigTransport();
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @ApiOperation(value = "下载脚手架", notes = "下载脚手架Zip文件的接口，返回Zip文件的byte数组方式", response = byte[].class, httpMethod = "POST")
    public ResponseEntity<Resource> download(@RequestBody @ApiParam(value = "配置文件内容，可拷贝src/main/resources/skeleton-data.properties的内容", required = true) String config) throws UnsupportedEncodingException {
        byte[] bytes = dataTransport.download(skeletonGeneratePath, SPRING_CLOUD_SKELETON, config);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("charset", "utf-8");
        //设置下载文件名
        String filename = URLEncoder.encode("generate", "UTF-8");
        headers.add("Content-Disposition", "attachment;filename=\"" + filename + "\"");

        Resource resource = new InputStreamResource(new ByteArrayInputStream(bytes));

        return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/x-msdownload")).body(resource);

    }

    @RequestMapping(value = "/getMetaData", method = RequestMethod.GET)
    @ApiOperation(value = "获取元数据接口", notes = "获取根据配置文件进行界面驱动的元数据接口", response = List.class, httpMethod = "GET")
    public List<SkeletonGroup> getMetaData() {
        return configTransport.getMetaData();
    }
}