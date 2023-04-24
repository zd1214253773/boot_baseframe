package com.sungrow.wind.util;

import com.sungrow.wind.constant.Constant;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHENGDONG
 * @date 2020/12/9 11:10
 */
public class FormatUtils {
    private static Map<Integer, String> LENGTH_MAP_ZERO_STR = new HashMap<>();

    static {
        LENGTH_MAP_ZERO_STR.put(1, "0");
        LENGTH_MAP_ZERO_STR.put(2, "00");
        LENGTH_MAP_ZERO_STR.put(3, "000");
        LENGTH_MAP_ZERO_STR.put(4, "0000");
    }

    public static DecimalFormat generateDecimalFormat(Integer validLength) {
        return new DecimalFormat(getDecimalFormatStr(validLength));
    }

    /**
     * 根据有效位数生成FORMAT
     * @param validLength
     * @param formula
     * @return
     */
    public static DecimalFormat generateDecimalFormat(Integer validLength, String formula) {
        String formatStr = getDecimalFormatStr(validLength);
        if (formula.indexOf(Constant.PERCENT) > 0) {
            formatStr = formatStr + Constant.PERCENT;
        }
        return new DecimalFormat(formatStr);
    }

    private static String getDecimalFormatStr(Integer validLength) {
        int cnt = validLength != null ? validLength : 2;
        String formatStr = Constant.ZERO_STR;
        if(LENGTH_MAP_ZERO_STR.get(cnt) != null) {
            formatStr = formatStr + Constant.DOT + LENGTH_MAP_ZERO_STR.get(cnt);
        }
        return formatStr;
    }

    public static  <E> void replaceAll(List<E> list, E oldObject, E newObject) {
        for (int i = 0; i < list.size(); i++) {        //遍历
            if (oldObject.equals(list.get(i))) {       //如果list中存在与oldObject相同的值，则用newObject替换
                list.set(i, newObject);                //设置索引为i的值为newObject
            }
        }
    }

}
