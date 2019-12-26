package school.wastesorting.enums;

public enum ErrorCode {
    UNKNOWN_ERROR(-1, "unknown error"),
    SUCCESS(0, "success"),
    PASSWORD_ERROR(1, "username or password is wrong"),
    USER_NOT_FOUND(2, "please register first"),
    CAPTCHA_ERROR(3, "captcha is wrong"),
    USER_EXISTS(4, "username already exists");
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
