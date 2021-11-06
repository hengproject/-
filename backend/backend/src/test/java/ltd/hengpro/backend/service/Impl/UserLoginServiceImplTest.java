package ltd.hengpro.backend.service.Impl;

import ltd.hengpro.backend.dto.UserDto;
import ltd.hengpro.backend.service.UserLoginService;
import ltd.hengpro.backend.vo.UserLoginVo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserLoginServiceImplTest {
    @Autowired
    UserLoginService userLoginService;

    @Test
    void login() throws Exception {
        UserLoginVo userLoginVo = new UserLoginVo();
        userLoginVo.setUsername("ysh0");
        userLoginVo.setPassword("200108");
        UserDto login = userLoginService.login(userLoginVo);
        System.out.println(login);
    }
    @Test
    @Transactional
    void register(){
        UserLoginVo userLoginVo = new UserLoginVo("ysh666", "133133133");
        String register = userLoginService.register(userLoginVo);
        System.out.println(register);
    }

    @Test
    void containsUser(){
        boolean ysh = userLoginService.containUser("ysh");
        System.out.println(ysh);
    }

    @Test
    @Transactional
    void delete(){
        userLoginService.deleteUserLoginById("5");
    }

    @Test
    @Transactional
    void registerNormalUser(){
        UserLoginVo userLoginVo = new UserLoginVo("test_normal_user", "20010829asdaw31");
        boolean b = userLoginService.registerNormalUser(userLoginVo);
        System.out.println(b);
    }
}