package com.sungrow.wind.service;

import com.sungrow.wind.entity.Dictitonary;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface DictitonaryService {
    int deleteByPrimaryKey(DictitonaryVO dictitonaryVO);

    int insert(DictitonaryVO dictitonaryVO);

    int insertSelective(DictitonaryVO dictitonaryVO);

    DictitonaryVO selectByPrimaryKey(String dictionaryId);

    int updateByPrimaryKeySelective(DictitonaryVO dictitonaryVO);

    int updateByPrimaryKey(DictitonaryVO dictitonaryVO);

    List<DictitonaryVO> listByPage(DictitonaryQueryVO dictitonaryQueryVO);

    List<DictitonaryVO> listBy(DictitonaryQueryVO dictitonaryQueryVO);

    @Transactional(rollbackFor = Exception.class)
    int insertBatch(List<DictitonaryVO> dictitonaryVOs);

    List<DictitonaryVO> listByGroupKey(String groupKey);

    List<DictitonaryVO> listTreeByGroupKey(String groupKey);

    Map<String,List<DictitonaryVO>> mapByGroupKey();

    String transferCodeToValue(String code, String groupKey);
}