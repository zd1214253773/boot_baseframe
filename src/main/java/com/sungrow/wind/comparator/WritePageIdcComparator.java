package com.sungrow.wind.comparator;

import com.sungrow.wind.constant.Constant;
import com.sungrow.wind.util.NumberUtils;
import com.sungrow.wind.util.NumberUtils;

import java.util.Comparator;

/**
 * ===排序结果==>>>>["1.1.1","1.1.2","1.2.1","1.2.2","1.2.3","1.1","1.2","1"]
 *
 * @author ZHENGDONG
 * @date 2020/12/2 20:26
 */
public class WritePageIdcComparator implements Comparator<OrderFinal> {

    @Override
    public int compare(OrderFinal o1, OrderFinal o2) {
        if (o1 == o2) {
            return 0;
        }

        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }

        String c1 = o1.getIdcOrderFinal();
        String c2 = o2.getIdcOrderFinal();
        if (c1 == c2) {
            return 0;
        }

        if (c1 == null) {
            return 1;
        }
        if (c2 == null) {
            return -1;
        }


        String[] f1 = c1.split(Constant.DOT_REGEX);
        String[] f2 = c2.split(Constant.DOT_REGEX);
        if (f1.length > f2.length) {
            return -1;
        }

        if (f1.length < f2.length) {
            return 1;
        }

        int lev = f1.length;

        for (int k = 0; k < lev; k++) {
            if(!f1[k].equals(f2[k])) {
                if (NumberUtils.isInteger(f1[k]) && NumberUtils.isInteger(f2[k])) {
                    int r = Integer.compare(Integer.valueOf(f1[k]), Integer.valueOf(f2[k]));
                    if (r != 0) {
                        return r;
                    }
                } else {
                    if(!NumberUtils.isInteger(f1[k]) && !NumberUtils.isInteger(f2[k])) {
                        return f1[k].compareTo(f2[k]);
                    }
                    if(!NumberUtils.isInteger(f1[k])) {
                        return 1;
                    }
                    if(!NumberUtils.isInteger(f2[k])) {
                        return -1;
                    }
                }
            }

        }

        return 0;
    }
}
