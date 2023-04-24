package com.sungrow.wind.service.cache;

import com.sungrow.wind.service.DictitonaryService;
import com.sungrow.wind.util.SpringBeanUtils;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import com.sungrow.wind.util.SpringBeanUtils;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * @author ZHENGDONG
 * @date 2020/11/25 13:39
 */
@Service
public class CommonCacheServiceUtil extends RefreshAble {


    private static volatile Map<String, DictitonaryVO> DICTIONARY_MAP;

    private static volatile Map<String, String> CODE_VALUE_MAP;

    private static volatile Map<String, String> VALUE_CODE_MAP;

    /**
     * itemCode =》DictitonaryVO
     *
     * @return
     */
    public static Map<String, DictitonaryVO> getDictionaryMap() {
        Map<String, DictitonaryVO> dbMap = DICTIONARY_MAP;
        if (dbMap == null) {
            dbMap = getDictionaryMap2();
            DICTIONARY_MAP = dbMap;
        }
        return dbMap;

    }

    private static Map<String, DictitonaryVO> getDictionaryMap2() {
        DictitonaryService service = SpringBeanUtils.getBean(DictitonaryService.class);
        List<DictitonaryVO> list = service.listBy(new DictitonaryQueryVO());
        Map<String, DictitonaryVO> dMap = list.stream().collect(toMap(DictitonaryVO::getItemCode,
                Function.identity(), (k1, k2) -> k2));
        return dMap;
    }

    /**
     * 字典表，itemCode=》itemValue
     *
     * @return
     */
    public static Map<String, String> getCodeValueMap() {
        Map<String, String> map = CODE_VALUE_MAP;
        if (map == null) {
            map = getDictionaryMap().entrySet().stream().collect(toMap(
                    e -> e.getKey(), e -> e.getValue().getItemValue()));
            CODE_VALUE_MAP = map;
        }

        return map;

    }


    /**
     * 字典表，itemValue =》itemCode
     *
     * @return
     */
    public static Map<String, String> getValueCodeMap() {
        Map<String, String> map = VALUE_CODE_MAP;
        if (map == null) {
            map = getCodeValueMap().entrySet().stream().collect(
                    toMap(e -> e.getValue(), e -> e.getKey(), (k1, k2) -> k2));
            VALUE_CODE_MAP = map;
        }

        return map;
    }

    @Override
    public void refresh() {
        DICTIONARY_MAP = null;
        CODE_VALUE_MAP = null;
        VALUE_CODE_MAP = null;
    }
}
