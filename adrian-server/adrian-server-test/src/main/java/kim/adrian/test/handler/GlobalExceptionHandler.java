package kim.adrian.test.handler;

import com.adrian.common.handler.DefaultGlobalExceptionHandlerAdvice;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName GlobalExceptionHandler
 * @Description
 * @Date 2020-01-03 12:45
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends DefaultGlobalExceptionHandlerAdvice {
}
