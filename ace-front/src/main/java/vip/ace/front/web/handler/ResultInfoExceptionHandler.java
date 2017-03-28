package vip.ace.front.web.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vip.ace.front.result.ResultBody;
import vip.ace.front.result.ResultInfo;
import vip.ace.front.result.ResultInfoException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xcl on 2017/3/23.
 */
@RestControllerAdvice
public class ResultInfoExceptionHandler {

    @ExceptionHandler(value = ResultInfoException.class)
    public ResultBody errorHandlerOverJson(HttpServletRequest request,ResultInfoException exception) {
        ResultInfo errorInfo = exception.getErrorInfo();
        ResultBody result = new ResultBody(errorInfo);
        return result;
    }
}
