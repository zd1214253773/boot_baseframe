package com.sungrow.wind.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ZHENGDONG
 * @date 2020/12/1 9:03
 */

public class SystemUtils {
    public static String getHostIp() {
        String ip = null;

        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            //log.error("获取ip异常", e.toString());
        }

        return ip;
    }
}
