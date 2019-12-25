package school.wastesorting.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void createTwo() {
    }

    @Test
    void getMoney() {
        /*try {

        } catch (UserException e) {
            Assert.assertEquals(e.getMessage(), ErrorCode.LITTLE_MONEY.getMessage());
            Assert.assertEquals(e.getCode(), ErrorCode.LITTLE_MONEY.getCode());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}