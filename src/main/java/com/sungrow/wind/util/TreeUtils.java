package com.sungrow.wind.util;

import java.text.MessageFormat;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author ZHENGDONG
 * @date 2020/11/19 19:29
 */
public class TreeUtils {


    public static <T, K> List<T> tree(List<T> targets,
                                      Predicate<T> outestFilter,
                                      BiConsumer<? super T, List<T>> doUnion,
                                      Function<? super T, ? extends K> classifier,
                                      Function<? super T, ? extends K> unionKey) {
        List<T> outest = targets.stream().filter(outestFilter).collect(Collectors.toList());
        //对子级别的数据，转装成Map,便取。
        Map<K, List<T>> map = targets.stream().filter(outestFilter.negate())
                .filter(t -> classifier.apply(t) != null)
                .collect(Collectors.groupingBy(classifier));
        //动态list，避免递归
        List<T> dyList = new LinkedList<>(outest);
        //检测死循环
        Set<K> hasHandles = new LinkedHashSet<>();
        while (!dyList.isEmpty()) {

            T vo = dyList.remove(0);
            //检测是否有死循环
            K code = unionKey.apply(vo);
            if (hasHandles.contains(code)) {
                throw new RuntimeException(MessageFormat.format("有循环引用或者相同的标识，code:[{0}]!!!!", code));
            }
            hasHandles.add(code);
            List<T> list1 = map.get(code);
            if (list1 != null) {
                doUnion.accept(vo,list1);
                dyList.addAll(list1);
            }
        }

        return outest;
    }


}
