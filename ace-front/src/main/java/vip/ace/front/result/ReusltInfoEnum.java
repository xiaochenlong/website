package vip.ace.front.result;

/**
 * Created by xcl on 2017/3/23.
 */
public enum ReusltInfoEnum implements ResultInfo{

    SUCCESS("1", "success"),
    NOT_FOUND("-1", "service not found");

    private String code;

    private String message;

    ReusltInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
