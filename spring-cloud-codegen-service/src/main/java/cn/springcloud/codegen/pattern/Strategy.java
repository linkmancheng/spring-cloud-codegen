package cn.springcloud.codegen.pattern;

import java.io.File;

import cn.springcloud.codegen.enums.AppTypeEnum;

/**
 * 使用策略模式决定生成代码
 * @author xujin
 * @site www.xujin.org
 */
public interface Strategy {

    /**
     *
     * @param key
     * @param appTypeEnum
     * @return
     */
    public File generateByKey (String key , AppTypeEnum appTypeEnum );

}
