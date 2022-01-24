package aki.server.utils;

public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(200, "success"),
    /* 参数错误 */
    PARAM_IS_INVALID(1001, "参数无效");

    private Integer code;
    private String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }
    public String message() {
        return this.message;
    }
}