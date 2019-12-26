package school.wastesorting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.wastesorting.domain.User;
import school.wastesorting.domain.Result;
import school.wastesorting.enums.ErrorCode;
import school.wastesorting.repository.UserRepository;
import school.wastesorting.service.UserService;
import school.wastesorting.util.ResultUtil;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/register", consumes = "application/json")
    public Result<User> register(@RequestBody User user){
        logger.info("register");
        User user1 = userRepository.findByName(user.getName());
        if (user1 != null) {
            return ResultUtil.fail(ErrorCode.USER_EXISTS);
        }
        user.setFlag(0);
        if (user.getFlag() != null) {
            user.setFlag(user.getFlag());
        }
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return ResultUtil.success();
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public Result<User> login(@RequestBody User user){
        logger.info("login");
        User trueUser = userRepository.findByName(user.getName());
        if(trueUser == null) {
            return ResultUtil.fail(ErrorCode.USER_NOT_FOUND);
        }
        else if(!trueUser.getPassword().equals(user.getPassword())) {
            return ResultUtil.fail(ErrorCode.PASSWORD_ERROR);
        }
        else {
            return ResultUtil.success();
        }
    }
}
