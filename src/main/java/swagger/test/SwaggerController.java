package swagger.test;

import entity.ResponseResult;
import entity.User;
import io.swagger.annotations.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.json.JsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

/**
 * @Author Ma Xiao Dong
 * @Date 2018/2/7
 * @Time 17:55
 * @Purpose
 */
@RestController
@RequestMapping("/api")
public class SwaggerController {
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/queryByUserId={userId}", method = RequestMethod.GET)
    public User queryByUserId(@PathVariable("userId") Long userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername("police");
        user.setPassword("i'm a policeman!");
        return user;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User",paramType = "body")
    @ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对", response = ResponseResult.class) })
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public User createUser(@ApiParam(value = "用户数据", required = true) @RequestBody User user) {
        user.setPassword("9d79wq7fsqewq");
        return user;
    }
   @ApiOperation(value = "测试", notes = "获取helloWorld")
   @RequestMapping("/helloword")
   String home() {
       return "HELLO WORLD";
   }
}