package school.wastesorting.enums;

public enum ErrorCode {
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(-1, "unknown error"),
    /**
     * 成功
     */
    SUCCESS(0, "success"),
    /**
     * 用户名或密码错误
     */
    PASSWORD_ERROR(1, "username or password is wrong"),
    /**
     * 用户名未注册
     */
    USER_NOT_FOUND(2, "please register first"),
    /**
     * 验证码错误
     */
    CAPTCHA_ERROR(3, "captcha is wrong"),
    /**
     * 用户名已存在
     */
    USER_EXISTS(4, "username already exists"),
    /**
     * 类目不存在
     */
    CATEGORY_NOT_FOUND(5, "category is not found"),
    /**
     * 物品已存在
     */
    THING_EXISTS(6, "thing already exists"),
    /**
     * 搜索不到物品
     */
    THING_NOT_FOUND(7, "thing cannot be found");
    private Integer code;
    private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
