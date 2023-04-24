package com.sungrow.wind.service.check;

import com.sungrow.wind.Application;
import com.sungrow.wind.common.BaseTest;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import com.sungrow.wind.common.BaseTest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;

/**
 * @author ZHENGDONG
 * @date 2020/12/22 15:39
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@Slf4j
public class UserServiceFeignClientTest extends BaseTest {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    @Autowired
    private RightService rightService;

    @Test
    public void testDynamic() {
//        DictitonaryQueryVO dictitonaryQueryVO = new DictitonaryQueryVO();
//        List<DictitonaryVO> vos = userServiceFeignClient.getUserInfo(URI.create("http://192.168.5.43:8080/iHybrid-H_Performance_API/dictitonary")
//                , dictitonaryQueryVO);

//        UserQuery query = new UserQuery();
//        query.setOrgCode("1111");
//        query.setDeptCode("7006");
//        List<UserInfo> vos = userServiceFeignClient
//                .userByDep(URI.create("http://124.196.4.219:8092/"),
//                        "1",query);
//        log.info("---------------》》》》》》{}" + vos);
    }

    @Test
    public void testDynamic2() {
        log.info("" + rightService.listBy(new DictitonaryQueryVO()));
    }

    @Value("${sys.token.root.url}")
    private String sysUrl;

    @Autowired
    private ExecutorService service;

    @SneakyThrows
    @Test
    public void testDynamic2333() {

        /*for(int i=0; i< 20000; i++) {
            service.execute(() -> userServiceFeignClient.exchangeTicket(URI.create(sysUrl), "1", "dasdasda"));
        }*/

        log.info("结束！！！");
        Thread.sleep(1000000);
        log.info("" + rightService.listBy(new DictitonaryQueryVO()));
    }
}