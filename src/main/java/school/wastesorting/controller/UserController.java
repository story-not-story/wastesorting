package school.wastesorting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.wastesorting.domain.User;
import school.wastesorting.domain.Result;
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


    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public Result<User> register(@RequestBody User user){
        logger.info("register");
        user.setFlag(0);
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        return ResultUtil.success(userRepository.save(user));
    }


}
