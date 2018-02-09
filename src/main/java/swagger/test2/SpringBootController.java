package swagger.test2;

import entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Ma Xiao Dong
 * @Date 2018/2/8
 * @Time 14:26
 * @Purpose
 */
@RestController
@RequestMapping("/user")
@Api(value = "Shop")
public class SpringBootController {
    @ApiOperation(value = "获取helloWorld", notes = "简单SpringMVC请求")
    @RequestMapping("/")
    String home() {
        return "HELLO WORLD";
    }

    @ApiOperation(value = "获得A+B", notes = "根据url的classNo和url的studentName获得请求参数的字符串相加，RestFul风格的请求")
    @ApiImplicitParams({@ApiImplicitParam(name = "classNo", value = "班级编号", required = true, dataType = "String",paramType = "path"),
    })
    @RequestMapping(value = "/class/{classNo}/to/{studentName}", method = RequestMethod.GET)
    String world(@PathVariable("classNo") String classNo, @PathVariable("studentName") String studentName) {
        return classNo + "  " + studentName;
    }
    @ApiOperation(value = "新建用户", notes = "新建一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户数据", required = true, paramType = "body", dataType = "User")
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ApiParam(value = "用户数据", required = true) @RequestBody User user) {
        System.out.println("user : " + user.getUserId() + " " + user.getUsername());
        return "success 新建user : " + user.getUserId() + " " + user.getUsername();
    }
}
