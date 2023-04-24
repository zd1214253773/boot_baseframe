package com.sungrow.wind.util;

import com.sungrow.wind.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZHENGDONG
 * @date 2020/11/21 9:09
 */
@Slf4j
public class ExpressionUtils {
    public static final String FORMULA_CAL = "#\\{[0-9\\.]*+\\}";

    public static final Pattern PATTERN = Pattern.compile(ExpressionUtils.FORMULA_CAL);

    public static Double calculator(String exp) {
        try {
            JEP jep = new JEP();
            Node parse = jep.parse(exp);
            Object evaluate = jep.evaluate(parse);
            System.out.println(evaluate);
            if (evaluate instanceof Double) {
                Double res = (Double) evaluate;
                if (res.isInfinite() || res.isNaN()) {
                    return new Double(0);
                }
                return res;
            } else {
                throw new RuntimeException(evaluate.getClass() + " not double");
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 如果有百分号，那么进行相应处理98% ===》(98)/100
     *
     * @param value 公式或者包含百分号的结果值，如: (8*9+2)*100% ==》((8*9+2)*100)/100
     * @return
     */
    public static String handlePercentInExpression(String value) {
        if (StringUtils.isNotEmpty(value)) {
            String v = value.trim();
            if (v.charAt(v.trim().length() - 1) == '%') {
                return "(" + v.replaceAll("%", Constant.BLANK) + ")/100";
            }
        }
        return value;
    }


    public static String addBracketIfPercent(String value) {
        if (StringUtils.isNotEmpty(value)) {
            int inx = value.indexOf("*100%");
            if (inx > 0) {
                value = "(" + value.substring(0, inx) + ")" + "*100%";

            }

        }
        return value;
    }


    /**
     * 1.1 ==》#{1.1}映射
     *
     * @param formula
     * @return
     */
    public static Map<String, String> getFinalOrderMaskMap(String formula) {
        Matcher matcher = PATTERN.matcher(formula);
        Map<String, String> codeValueMap = new HashMap<>();
        while (matcher.find()) {
            String maskCode = formula.substring(matcher.start(), matcher.end());
            //解析出指标编码#{1.1}=》1.1
            String code = maskCode.substring(2, maskCode.length() - 1);
            codeValueMap.put(code, maskCode);

        }
        return codeValueMap;
    }
    /*public static void main(String[] agrs) {
        calculator("1*2*3");

    }*/
}
