package school.wastesorting.enums;

public enum ErrorCode {
    SUCCESS(0, "success"),
    LUCKMONEY_NOT_FOUND(1, "luckymoney is not found"),
    PARAM_ERROR(2, "param error"),
    UNKNOWN_ERROR(-1, "unknown error"),
    LITTLE_MONEY(3, "little money"),
    MUCH_MONEY(4, "much money");
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
