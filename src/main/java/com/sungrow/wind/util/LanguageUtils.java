package com.sungrow.wind.util;

import com.sungrow.wind.global.RequestHeader;
import com.sungrow.wind.global.RequestHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author ZHENGDONG
 * @date 2020/12/8 17:29
 */
public class LanguageUtils {

    //private ResourceBundle messageSource = new MessageSource();
    private static final Map<String, Locale> LOCAL_MAP = new HashMap<>();
    public static final String MESSAGE = "message";

    static {
        LOCAL_MAP.put("zh_CN", Locale.CHINA);
        LOCAL_MAP.put("en_US", Locale.US);
        LOCAL_MAP.put("zh-CN", Locale.CHINA);
        LOCAL_MAP.put("en-US", Locale.US);
    }

    public static String getMesg(String mesgKey, Object... prams) {

        return getMesgWithlanguageCode(mesgKey, RequestHeader.getHeader().getXLanguageId(), prams);
    }

    public static String getMesgWithlanguageCode(String mesgKey, String languageCode, Object... prams) {

        String msg = ResourceBundle.getBundle(MESSAGE, LOCAL_MAP.getOrDefault(languageCode, Locale.CHINA)).getString(mesgKey);
        return MessageFormat.format(msg, prams);
    }
}
