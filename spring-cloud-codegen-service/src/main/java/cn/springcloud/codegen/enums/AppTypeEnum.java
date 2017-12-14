package cn.springcloud.codegen.enums;

/**
 * @author xujin
 * @site www.xujin.org
 */
public enum AppTypeEnum {

    SPRING_BOOT("sc", "Spring Boot应用"),

    Spring_Cloud("sc","Spring Cloud应用");

    /**
     * key值
     */
    private String key;

    /**
     * 类型描述
     */
    private String description;

    private AppTypeEnum(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String key() {
        return key;
    }
    public String description() {
        return description;
    }

    public static AppTypeEnum keyOf(int key) {
        for(AppTypeEnum type : AppTypeEnum.values()) {
            if(type.key().equals(key) ) {
                return type;
            }
        }
        return null;
    }
}
