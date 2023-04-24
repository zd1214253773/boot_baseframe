package com.sungrow.wind.util;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.sungrow.wind.global.data.Result;
import com.sungrow.wind.service.check.UserInfo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author ZHENGDONG
 * @date 2020/11/26 19:44
 */
public class NumberUtils {

    public static final Double ZERO_DOUBLE = new Double(0);

    public static final int DEFAUT_DIV_SCALE = 2;

    public static final int DEFAUT_DIV_SCALE_4 = 4;

    public static boolean isDouble(String target) {
        if (StringUtils.isNotEmpty(target)) {
            try {
                Double.valueOf(target);
                return true;
            } catch (Throwable e) {
                return false;
            }

        }
        return false;
    }

    public static boolean isInteger(String target) {
        if (StringUtils.isNotEmpty(target)) {
            try {
                Integer.valueOf(target);
                return true;
            } catch (Throwable e) {
                return false;
            }

        }
        return false;
    }

    public static boolean isLong(String target) {
        if (StringUtils.isNotEmpty(target)) {
            try {
                Long.valueOf(target);
                return true;
            } catch (Throwable e) {
                return false;
            }

        }
        return false;
    }

    public static double add(double v1,double v2){
        return NumberUtil.add(v1,v2);
    }

    public static double divUp(double v1,double v2){
        return NumberUtil.div(v1,v2,DEFAUT_DIV_SCALE, RoundingMode.HALF_UP);
    }

    public static double divUpScale(double v1,double v2,int scale){
        if (v2==0) return 0;
        return NumberUtil.div(v1,v2,scale, RoundingMode.HALF_UP);
    }

    public static double divDown(double v1,double v2){
        return NumberUtil.div(v1,v2,DEFAUT_DIV_SCALE, RoundingMode.HALF_DOWN);
    }
    public static String formatPercentage(Object v){
        if(v==null){
            v="0";
        }
        DecimalFormat df = new DecimalFormat("0.00%");
        String r = df.format(new BigDecimal(v.toString()));
        return r;
    }

    public static void main(String[] args) {
        System.out.println("89.76".substring("89.76".lastIndexOf(".")));
        String ss = JSON.toJSONString(Result.success(new UserInfo()));

        System.out.println(JSONPath.read(ss,"data"));
    }

    /*public static boolean isDoubleIf(String target, boolean carryPercet) {
        if (StringUtils.isNotEmpty(target)) {
            try {
                Double.valueOf(target);
                return true;
            } catch (Throwable e) {
                return false;
            }

        }
        return false;
    }
*/
}
