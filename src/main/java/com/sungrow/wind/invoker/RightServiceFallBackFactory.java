package com.sungrow.wind.invoker;

import com.sungrow.wind.service.check.RightService;
import com.sungrow.wind.service.check.RightService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author ZHENGDONG
 * @date 2021/3/4 15:04
 */
@Component
public class RightServiceFallBackFactory implements FallbackFactory {


    @Override
    public Object create(Throwable cause) {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {RightService.class},
                new DefaultFallBackInvocationHandler(cause));
    }

}
