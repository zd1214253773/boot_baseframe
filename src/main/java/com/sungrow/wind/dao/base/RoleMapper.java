package com.sungrow.wind.dao.base;

import com.sungrow.wind.entity.Role;
import com.sungrow.wind.vo.query.RoleQueryVO;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    @Delete({
        "update public.role set valid='0',",
        " update_time = #{updateTime,jdbcType=TIMESTAMP},",
        "modifyer_code = #{modifyerCode,jdbcType=VARCHAR},",
        "modifyer_name = #{modifyerName,jdbcType=VARCHAR}",
        "where role_id = #{roleId,jdbcType=VARCHAR}",
        "and valid = '1'"
    })
    int deleteByPrimaryKey(Role record);

    @Insert({
        "insert into public.role (role_id, role, ",
        "idc_version, idc_extend_id, ",
        "idc_name, report_permission, ",
        "report_user, approve_permission, ",
        "approve_user, look_permission, ",
        "dep_id, dep_name, ",
        "create_time, oper_code, ",
        "oper_name, update_time, ",
        "modifyer_code, modifyer_name, ",
        "valid, ",
        "hospital_id,finally_user,look_user,finally_permission,finally_dep)",
        "values (#{roleId,jdbcType=VARCHAR}, #{role,jdbcType=VARCHAR}, ",
        "#{idcVersion,jdbcType=INTEGER}, #{idcExtendId,jdbcType=VARCHAR}, ",
        "#{idcName,jdbcType=VARCHAR}, #{reportPermission,jdbcType=VARCHAR}, ",
        "#{reportUser,jdbcType=VARCHAR}, #{approvePermission,jdbcType=VARCHAR}, ",
        "#{approveUser,jdbcType=VARCHAR}, #{lookPermission,jdbcType=VARCHAR}, ",
        "#{depId,jdbcType=VARCHAR}, #{depName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{operCode,jdbcType=VARCHAR}, ",
        "#{operName,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{modifyerCode,jdbcType=VARCHAR}, #{modifyerName,jdbcType=VARCHAR}, ",
        "#{valid,jdbcType=VARCHAR},",
        "#{hospitalId,jdbcType=VARCHAR},#{finallyUser,jdbcType=VARCHAR}," +
                "#{lookUser,jdbcType=VARCHAR},#{finallyPermission,jdbcType=VARCHAR},#{finallyDep,jdbcType=VARCHAR}" +
                ")"
    })
    int insert(Role record);

    int insertSelective(Role record);

    @Select({
        "select",
        "role_id, role, idc_version, idc_extend_id, idc_name, report_permission, report_user, ",
        "approve_permission, approve_user, look_permission, dep_id, dep_name, create_time, ",
        "oper_code, oper_name, update_time, modifyer_code, modifyer_name, valid,hospital_id," +
                "finally_user,look_user,finally_permission,finally_dep",
        "from public.role",
        "where role_id = #{roleId,jdbcType=VARCHAR}",
        "and valid = '1'"
    })
    @ResultMap("com.sungrow.wind.dao.postgre.RoleMapper.BaseResultMap")
    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    @Update({
        "update public.role",
        "set role = #{role,jdbcType=VARCHAR},",
          "idc_version = #{idcVersion,jdbcType=INTEGER},",
          "idc_extend_id = #{idcExtendId,jdbcType=VARCHAR},",
          "idc_name = #{idcName,jdbcType=VARCHAR},",
          "report_permission = #{reportPermission,jdbcType=VARCHAR},",
          "report_user = #{reportUser,jdbcType=VARCHAR},",
          "approve_permission = #{approvePermission,jdbcType=VARCHAR},",
          "approve_user = #{approveUser,jdbcType=VARCHAR},",
          "look_permission = #{lookPermission,jdbcType=VARCHAR},",
          "dep_id = #{depId,jdbcType=VARCHAR},",
          "dep_name = #{depName,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "modifyer_code = #{modifyerCode,jdbcType=VARCHAR},",
          "modifyer_name = #{modifyerName,jdbcType=VARCHAR},",
            "hospital_id = #{hospitalId,jdbcType=VARCHAR},",
            "finally_user = #{finallyUser,jdbcType=VARCHAR},",
            "look_user = #{lookUser,jdbcType=VARCHAR},",
            "finally_permission = #{finallyPermission,jdbcType=VARCHAR},",
            "finally_dep = #{finallyDep,jdbcType=VARCHAR}",
        "where role_id = #{roleId,jdbcType=VARCHAR}",
        "and valid = '1'"
    })
    int updateByPrimaryKey(Role record);

    List<Role> listByPage(RoleQueryVO roleQueryVO);

}