package school.wastesorting.exception;

import school.wastesorting.enums.ErrorCode;

public class UserException extends RuntimeException {
    private Integer code;

    public UserException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
