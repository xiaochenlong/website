package vip.ace.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.ace.admin.domian.SysAuthorities;
import vip.ace.admin.domian.SysAuthoritiesCriteria;

public interface SysAuthoritiesMapper {
    int countByExample(SysAuthoritiesCriteria example);

    int deleteByExample(SysAuthoritiesCriteria example);

    int deleteByPrimaryKey(Integer authorityId);

    int insert(SysAuthorities record);

    int insertSelective(SysAuthorities record);

    List<SysAuthorities> selectByExample(SysAuthoritiesCriteria example);

    List<SysAuthorities> selectByRoleId(Integer roleId);

    List<SysAuthorities> selectByUserId(Integer userId);

    SysAuthorities selectByPrimaryKey(Integer authorityId);

    int updateByExampleSelective(@Param("record") SysAuthorities record, @Param("example") SysAuthoritiesCriteria example);

    int updateByExample(@Param("record") SysAuthorities record, @Param("example") SysAuthoritiesCriteria example);

    int updateByPrimaryKeySelective(SysAuthorities record);

    int updateByPrimaryKey(SysAuthorities record);
}