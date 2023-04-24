package com.sungrow.wind.common;

import com.sungrow.wind.Application;
import com.sungrow.wind.global.RequestHeader;
import com.sungrow.wind.global.RequestHeader;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 继承AbstractTransactionalJUnit4SpringContextTests
 * 事务进行自动回滚
 * @author ZHENGDONG
 * @date 2020/11/23 17:54
 */
@SpringBootTest(classes= Application.class)
@RunWith(SpringRunner.class)
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Before
    public void before() {
        //mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
        RequestHeader.addHeader(RequestHeader.getDefault());
    }
}
