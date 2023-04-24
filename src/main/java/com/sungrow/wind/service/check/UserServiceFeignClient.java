package com.sungrow.wind.service.check;

import com.sungrow.wind.common.FeignCustomizedConfiguration;
import com.sungrow.wind.entity.SysFunction;
import com.sungrow.wind.entity.User;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import com.sungrow.wind.entity.SysFunction;
import com.sungrow.wind.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * @author ZHENGDONG
 * @date 2020/11/30 11:01
 */
///sso/login/sys/token
//RightService
@FeignClient(
        value="127.0.0.1",
        url = "http://124.196.4.219:8090"
        //,
        //path="/sys",
        //configuration = FeignCustomizedConfiguration.class
)
public interface UserServiceFeignClient {

//    @RequestMapping(method= RequestMethod.GET, path="/sys/getUseInfo")
//    UserInfo getUserInfo(URI uri, @RequestParam String token);
//
//    @RequestMapping(method= RequestMethod.POST, path="/sys/getUserByDeptCode")
//    List<UserInfo> userByDep(URI uri,@RequestParam String token,@ModelAttribute UserInfo user);

    @RequestMapping(method= RequestMethod.POST, path = "/api/sso/ticket/exchange")
    User exchangeTicket(URI uri, @RequestParam String systemCode, @RequestParam String ticket);

    @RequestMapping(method= RequestMethod.GET, path = "/api/user/v1/functions")
    List<SysFunction> getUseRoleFunction(URI uri, @RequestParam String systemCode, @RequestParam String userName);

    @GetMapping(path="/api/user/v1/query")
    List<UserInfo> userByDep(URI uri,@RequestParam String systemCode, @ModelAttribute UserQuery query);

}
