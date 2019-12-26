package school.wastesorting.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import school.wastesorting.domain.Result;
import school.wastesorting.enums.ErrorCode;
import school.wastesorting.exception.UserException;
import school.wastesorting.util.ResultUtil;

/**
 * Demo class
 *
 * @author hujun
 * @date 2019/12/26
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof UserException) {
            return ResultUtil.fail(((UserException) e).getCode(), e.getMessage());
        }
        logger.error(e.getMessage());
        return ResultUtil.fail(ErrorCode.UNKNOWN_ERROR);
    }
}
