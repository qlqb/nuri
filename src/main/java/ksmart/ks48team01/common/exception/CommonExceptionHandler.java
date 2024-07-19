package ksmart.ks48team01.common.exception;

import groovy.util.logging.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handle(Exception e) {
        return "error/errorCommon";
    }
}
