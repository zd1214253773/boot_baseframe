package com.sungrow.wind.util;

import com.sungrow.wind.constant.Constant;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZHENGDONG
 * @date 2020/11/19 10:05
 */
public class StringUtils {

    /**
     * 判断字符串是否为空“”or null.
     *
     * @param target
     * @return
     */
    public static boolean isEmpty(Object target) {
        return org.springframework.util.StringUtils.isEmpty(target);
    }

    public static boolean isNotEmpty(Object target) {
        return !org.springframework.util.StringUtils.isEmpty(target);
    }

    public static boolean hasText(String target) {
        return org.springframework.util.StringUtils.hasText(target);
    }


    public static String replace(String inString, String oldPattern, @Nullable String newPattern) {
        return org.springframework.util.StringUtils.replace(inString, oldPattern, newPattern);
    }

    public static boolean equalsIfNull(String t1, String t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null) {
            return t1.equals(t2);
        }
        return false;
    }

    public static String trim(String target) {
        if (target != null) {
            return target.trim();
        }
        return null;
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线
     *
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 转大写
     *
     * @param str
     * @return
     */
    public static String upperCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        return str.toUpperCase();
    }

    public static String subStr(String targetStr, int maxLength) {
        if (targetStr == null) {
            return targetStr;
        }
        if (maxLength >= targetStr.length()) {
            return targetStr;
        }
        return targetStr.substring(0, maxLength - 1);
    }

    public static String wrapper(String targetStr, String wrapperStr) {
        if (targetStr == null) {
            return targetStr;
        }
        return wrapperStr + targetStr + wrapperStr;
    }

    public static String trimIfEndWith(String targetStr, char trimEndChar) {
        if (targetStr == null) {
            return targetStr;
        }
        return org.springframework.util.StringUtils.trimTrailingCharacter(targetStr, trimEndChar);

    }

}
