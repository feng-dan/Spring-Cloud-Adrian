package kim.adrian.system.handler;

import com.adrian.common.entity.vo.Result;
import com.adrian.common.exception.ServiceException;
import com.adrian.common.handler.DefaultGlobalExceptionHandlerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName GlobalExceptionHandler
 * @Description
 * @Date 2020-01-03 12:45
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends DefaultGlobalExceptionHandlerAdvice {


}
