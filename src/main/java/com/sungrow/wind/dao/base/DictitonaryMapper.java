package com.sungrow.wind.dao.base;

import com.sungrow.wind.entity.Dictitonary;
import com.sungrow.wind.vo.query.DictitonaryQueryVO;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface DictitonaryMapper {
    @Delete({
        "update public.dictitonary set valid='0',",
        " update_time = #{updateTime,jdbcType=TIMESTAMP},",
        "modifyer_code = #{modifyerCode,jdbcType=VARCHAR},",
        "modifyer_name = #{modifyerName,jdbcType=VARCHAR}",
        "where dictionary_id = #{dictionaryId,jdbcType=VARCHAR}",
        "and valid = '1'"
    })
    int deleteByPrimaryKey(Dictitonary record);

    @Insert({
        "insert into public.dictitonary (dictionary_id, parent_item__key, ",
        "item_value, item_code, ",
        "sequence, item_describe, ",
        "group_key, create_time, ",
        "oper_code, oper_name, ",
        "update_time, modifyer_code, ",
        "modifyer_name, valid)",
        "values (#{dictionaryId,jdbcType=VARCHAR}, #{parentItemKey,jdbcType=VARCHAR}, ",
        "#{itemValue,jdbcType=VARCHAR}, #{itemCode,jdbcType=VARCHAR}, ",
        "#{sequence,jdbcType=INTEGER}, #{itemDescribe,jdbcType=VARCHAR}, ",
        "#{groupKey,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{operCode,jdbcType=VARCHAR}, #{operName,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{modifyerCode,jdbcType=VARCHAR}, ",
        "#{modifyerName,jdbcType=VARCHAR}, #{valid,jdbcType=VARCHAR})"
    })
    int insert(Dictitonary record);

    int insertSelective(Dictitonary record);

    @Select({
        "select",
        "dictionary_id, parent_item__key, item_value, item_code, sequence, item_describe, ",
        "group_key, create_time, oper_code, oper_name, update_time, modifyer_code, modifyer_name, ",
        "valid",
        "from public.dictitonary",
        "where dictionary_id = #{dictionaryId,jdbcType=VARCHAR}",
        "and valid = '1'"
    })
    @ResultMap("com.sungrow.wind.dao.postgre.DictitonaryMapper.BaseResultMap")
    Dictitonary selectByPrimaryKey(String dictionaryId);

    int updateByPrimaryKeySelective(Dictitonary record);

    @Update({
        "update public.dictitonary",
        "set parent_item__key = #{parentItemKey,jdbcType=VARCHAR},",
          "item_value = #{itemValue,jdbcType=VARCHAR},",
          "item_code = #{itemCode,jdbcType=VARCHAR},",
          "sequence = #{sequence,jdbcType=INTEGER},",
          "item_describe = #{itemDescribe,jdbcType=VARCHAR},",
          "group_key = #{groupKey,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "modifyer_code = #{modifyerCode,jdbcType=VARCHAR},",
          "modifyer_name = #{modifyerName,jdbcType=VARCHAR}",
        "where dictionary_id = #{dictionaryId,jdbcType=VARCHAR}",
        "and valid = '1'"
    })
    int updateByPrimaryKey(Dictitonary record);

    List<Dictitonary> listByPage(DictitonaryQueryVO dictitonaryQueryVO);


    /*@Select({
          "select * from public.dictitonary where valid = '1' order by sequence asc"
    })
    @ResultMap("com.sungrow.wind.dao.postgre.DictitonaryMapper.BaseResultMap")
    List<Dictitonary> listAll();*/

}