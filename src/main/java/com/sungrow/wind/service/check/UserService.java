package com.sungrow.wind.service.check;

import com.sungrow.wind.common.FeignCustomizedConfiguration;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ZHENGDONG
 * @date 2020/11/30 11:01
 */
///sso/login/sys/token
//RightService
//UserServiceFeignClient
public interface UserService {
    UserInfo token(String token);

//    List<UserInfo> userByDep(String hospitalId,String depId);
}
