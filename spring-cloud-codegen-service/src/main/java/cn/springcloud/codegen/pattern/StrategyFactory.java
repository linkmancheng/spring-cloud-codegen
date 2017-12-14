package cn.springcloud.codegen.pattern;

import java.util.HashMap;
import java.util.Map;

import cn.springcloud.codegen.enums.AppTypeEnum;

/**
 * 策略工厂
 * @author xujin
 * @site www.xujin.org
 */
public class StrategyFactory {

    private static StrategyFactory factory = new StrategyFactory();

    private StrategyFactory(){
    }
    private static Map<String ,Strategy> strategyMap = new HashMap<>();
    static{
        strategyMap.put(AppTypeEnum.SPRING_BOOT.key(), new GeneratorSpringBootStrategy());
    }
    public Strategy creator(String key){
        return strategyMap.get(key);
    }
    public static StrategyFactory getInstance(){
        return factory;
    }
}
