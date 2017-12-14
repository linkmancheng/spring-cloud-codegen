package cn.springcloud.codegen.pattern;

import java.io.File;

import cn.springcloud.codegen.enums.AppTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author xujin
 * @site www.xujin.org
 */
public class GeneratorSpringBootStrategy implements Strategy {

    @Override
    public File generateByKey(String key, AppTypeEnum appTypeEnum) {
        return null;
    }
}
