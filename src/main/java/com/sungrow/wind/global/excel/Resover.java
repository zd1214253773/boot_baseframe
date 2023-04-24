package com.sungrow.wind.global.excel;

import java.util.List;

/**
 * @author ZHENGDONG
 * @date 2020/11/29 1:13
 */

public interface Resover<T> {
    Class<T> getElementClass();

    List<T> resolve();
}
