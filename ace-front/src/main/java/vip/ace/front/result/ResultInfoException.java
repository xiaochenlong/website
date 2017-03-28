package vip.ace.front.result;

/**
 * Created by xcl on 2017/3/23.
 */
public class ResultInfoException extends Exception{

    private ResultInfo errorInfo;


    public ResultInfoException (ResultInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ResultInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ResultInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
