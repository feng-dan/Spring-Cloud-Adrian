package kim.adrian.system.exception;

import com.adrian.common.exception.ErrorType;
import lombok.Getter;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianServerSystemErrorType
 * @Description
 * @Date 2020-01-11 11:09
 */
@Getter
public enum AdrianServerSystemErrorType implements ErrorType {
    FAILED_TO_ADD_USER("060000", "新增用户失败"),
    MODIFY_USER_FAILED("061000","修改用户失败"),
    FAILED_TO_DELETE_USER("062000","删除用户失败")




    ;
    private String code;
    private String mesg;

    AdrianServerSystemErrorType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}
