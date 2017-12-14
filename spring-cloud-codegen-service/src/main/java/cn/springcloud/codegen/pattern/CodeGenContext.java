package cn.springcloud.codegen.pattern;

import java.io.File;

import cn.springcloud.codegen.enums.AppTypeEnum;

/**
 * 代码生成器执行上下文
 * @author xujin
 * @site  www.xujin.org
 */
public class CodeGenContext {

    private Strategy strategy;

    public File generateProject(String key , AppTypeEnum appTypeEnum) {
        strategy = StrategyFactory.getInstance().creator(key);
        return strategy.generateByKey(key , appTypeEnum);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
