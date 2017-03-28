package vip.ace.front.result;

import java.io.Serializable;

/**
 * Created by xcl on 2017/3/23.
 */
public class ResultBody implements Serializable{

    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public ResultBody() {
        this.code = ReusltInfoEnum.SUCCESS.getCode();
        this.message = ReusltInfoEnum.SUCCESS.getMessage();
    }

    public ResultBody(ResultInfo errorInfo) {
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
    }

    public ResultBody(Object result) {
        this();
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
