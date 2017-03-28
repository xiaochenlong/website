package vip.ace.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.ace.admin.domian.SysRoles;
import vip.ace.admin.domian.SysRolesCriteria;

public interface SysRolesMapper {
    int countByExample(SysRolesCriteria example);

    int deleteByExample(SysRolesCriteria example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRoles record);

    int insertSelective(SysRoles record);

    List<SysRoles> selectByExample(SysRolesCriteria example);

    List<SysRoles> selectByUserId(Integer userId);

    SysRoles selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") SysRoles record, @Param("example") SysRolesCriteria example);

    int updateByExample(@Param("record") SysRoles record, @Param("example") SysRolesCriteria example);

    int updateByPrimaryKeySelective(SysRoles record);

    int updateByPrimaryKey(SysRoles record);
}