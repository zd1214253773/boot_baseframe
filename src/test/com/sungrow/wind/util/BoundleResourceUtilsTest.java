package com.sungrow.wind.util;

import com.sungrow.wind.common.BaseTest;
import com.sungrow.wind.constant.LanguageConstant;
import com.sungrow.wind.common.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author ZHENGDONG
 * @date 2020/12/8 17:53
 */
@Slf4j
public class BoundleResourceUtilsTest extends BaseTest {

    @Test
    public void getMesg() {
        log.info(LanguageUtils.getMesg(LanguageConstant.MESG_ERR_CIRCULA, "#{1.5}", "3123"));
    }

}