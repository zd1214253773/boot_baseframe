package com.sungrow.wind.service.check;

import com.sungrow.wind.invoker.RightServiceFallBackFactory;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ZHENGDONG
 * @date 2020/11/30 11:01
 */
@FeignClient(
        value="124.196.7.85",
        url = "http://127.0.0.1:8080/iHybrid-H_Performance_API",
        path="/dictitonary",
        fallbackFactory = RightServiceFallBackFactory.class
        //,
        //configuration = FeignCustomizedConfiguration.class
)
public interface RightService {

    @RequestMapping(method= RequestMethod.GET, path="/listBy")
    List<DictitonaryVO> listBy(@ModelAttribute DictitonaryQueryVO queryVO);
}
