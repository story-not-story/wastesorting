package school.wastesorting.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import school.wastesorting.domain.Result;
import school.wastesorting.enums.ErrorCode;
import school.wastesorting.exception.UserException;
import school.wastesorting.util.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof UserException) {
            return ResultUtil.fail(((UserException) e).getCode(), e.getMessage());
        }
        return ResultUtil.fail(ErrorCode.UNKNOWN_ERROR);
    }
}
