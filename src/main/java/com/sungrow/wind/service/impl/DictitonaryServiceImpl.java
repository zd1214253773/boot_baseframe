package com.sungrow.wind.service.impl;

import com.sungrow.wind.dao.base.DictitonaryMapper;
import com.sungrow.wind.entity.Dictitonary;
import com.sungrow.wind.service.DictitonaryService;
import com.sungrow.wind.util.BeanUtils;
import com.sungrow.wind.util.StringUtils;
import com.sungrow.wind.vo.DictitonaryVO;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DictitonaryServiceImpl implements DictitonaryService {
    @Autowired
    private DictitonaryMapper dictitonaryMapper;


    @Override
    public int deleteByPrimaryKey(DictitonaryVO dictitonaryVO) {
        return dictitonaryMapper.deleteByPrimaryKey(BeanUtils.copy(dictitonaryVO, Dictitonary.class));
    }

    @Override
    public int insert(DictitonaryVO dictitonaryVO) {
        return dictitonaryMapper.insert(BeanUtils.copy(dictitonaryVO, Dictitonary.class));
    }

    @Override
    public int insertSelective(DictitonaryVO dictitonaryVO) {
        return dictitonaryMapper.insertSelective(BeanUtils.copy(dictitonaryVO, Dictitonary.class));
    }

    @Override
    public DictitonaryVO selectByPrimaryKey(String dictionaryId) {
        return BeanUtils.copy(dictitonaryMapper.selectByPrimaryKey(dictionaryId), DictitonaryVO.class);
    }

    @Override
    public int updateByPrimaryKeySelective(DictitonaryVO dictitonaryVO) {
        return dictitonaryMapper.updateByPrimaryKeySelective(BeanUtils.copy(dictitonaryVO, Dictitonary.class));
    }

    @Override
    public int updateByPrimaryKey(DictitonaryVO dictitonaryVO) {
        return dictitonaryMapper.updateByPrimaryKey(BeanUtils.copy(dictitonaryVO, Dictitonary.class));
    }

    //TODO
    @Override
    public List<DictitonaryVO> listByPage(DictitonaryQueryVO dictitonaryQueryVO) {
        return BeanUtils.copy(dictitonaryMapper.listByPage(dictitonaryQueryVO), DictitonaryVO.class);
    }

    @Override
    public List<DictitonaryVO> listBy(DictitonaryQueryVO dictitonaryQueryVO) {
        /*throw new RuntimeException("hhhh");*/
        dictitonaryQueryVO.setPageParam(null);
        return BeanUtils.copy(dictitonaryMapper.listByPage(dictitonaryQueryVO), DictitonaryVO.class);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBatch(List<DictitonaryVO> dictitonaryVOs) {
        dictitonaryVOs.stream().forEach(
                d -> this.insert(d)
        );
        return dictitonaryVOs.size();
    }


    /**
     * 按sequence字段升序，null被排在最前面。
     *
     * @param groupKey
     * @return
     */
    @Override
    public List<DictitonaryVO> listByGroupKey(String groupKey) {
        if (StringUtils.isEmpty(groupKey)) {
            return Collections.emptyList();
        }
        DictitonaryQueryVO queryVO = new DictitonaryQueryVO();
        queryVO.setGroupKey(groupKey);
        return orderBySeq(this.listBy(queryVO));
    }

    /**
     * 按sequence字段升序，null被排在最前面。会进行组装成树形操作
     *
     * @param groupKey
     * @return
     */
    @Override
    public List<DictitonaryVO> listTreeByGroupKey(String groupKey) {
        List<DictitonaryVO> list = this.listByGroupKey(groupKey);
        return DictitonaryVO.fold(list);
    }

    @Override
    public Map<String, List<DictitonaryVO>> mapByGroupKey() {
        List<DictitonaryVO> list = orderBySeq(this.listBy(new DictitonaryQueryVO()));
        return list.stream().collect(Collectors.groupingBy(DictitonaryVO::getGroupKey));
    }

    private List<DictitonaryVO> orderBySeq(List<DictitonaryVO> list) {
        return list.stream().sorted(
                Comparator.comparing((dc) -> dc.getSequence() == null ? 0 : dc.getSequence()))
                .collect(Collectors.toList());
    }

    @Override
    public String transferCodeToValue(String code, String groupKey) {
        List<DictitonaryVO> dictitonaryVOS = listByGroupKey(groupKey);
        for (DictitonaryVO dic : dictitonaryVOS) {
            if (code.equals(dic.getItemCode())) {
                return dic.getItemValue();
            }
        }
        return code;
    }
}