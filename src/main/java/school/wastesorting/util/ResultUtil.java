package school.wastesorting.util;

import school.wastesorting.enums.ErrorCode;
import school.wastesorting.domain.Result;

public class ResultUtil {
    public static Result success(Object list) {
        Result result = new Result();
        result.setCode(ErrorCode.SUCCESS.getCode());
        result.setMessage(ErrorCode.SUCCESS.getMessage());
        result.setData(list);
        return result;
    }

    public static  Result success() {
        return success(null);
    }

    public static Result fail(ErrorCode errorCode){
        Result result = new Result();
        result.setCode(errorCode.getCode());
        result.setMessage(errorCode.getMessage());
        return result;
    }

    public static Result fail(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
