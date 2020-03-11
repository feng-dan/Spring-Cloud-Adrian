package kim.adrian.auth.properties;

import lombok.Data;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianValidateCodeProperties
 * @Description 参数配置化-验证码相关配置
 * @Date 2020-01-07 11:12
 */
@Data
public class AdrianValidateCodeProperties {
    /**
     * 验证码有效时间，单位秒
     */
    private Long time = 120L;
    /**
     * 验证码类型，可选值 png和 gif
     */
    private String type = "png";
    /**
     * 图片宽度，px
     */
    private Integer width = 130;
    /**
     * 图片高度，px
     */
    private Integer height = 48;
    /**
     * 验证码位数
     */
    private Integer length = 4;
    /**
     * 验证码值的类型
     * 1. 数字加字母
     * 2. 纯数字
     * 3. 纯字母
     */
    private Integer charType = 2;
}
