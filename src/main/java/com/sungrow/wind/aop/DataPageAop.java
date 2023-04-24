package com.sungrow.wind.aop;

import com.github.pagehelper.PageHelper;
import com.sungrow.wind.vo.page.BasePageInfo;
import com.sungrow.wind.vo.page.PageParam;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ZHENGDONG
 * @date 2020/11/14 15:16
 */
@Aspect
@Component
public class DataPageAop {

    @Pointcut("execution(public * com.sungrow.wind.dao.postgre.*.list*Page(..))")
    public void maybePageMethod() {

    }

    @Before("maybePageMethod()")
    public void mayStartPageQuery(JoinPoint jionPoint) {
        Object[] args = jionPoint.getArgs();
        if (args != null && args.length > 0 && args[0] != null) {
            Object firstPara = args[0];
            PageParam pageParam = null;
            boolean hasInitedPageParam = firstPara instanceof BasePageInfo
                    && (pageParam = ((BasePageInfo) firstPara).getPageParam()) != null;
            if (hasInitedPageParam) {
                //参数合法那么当前线程开启分页查询
                pageParam.check();
                //, pageParam.finalOderBy()
                PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
            }

        }

    }
}
