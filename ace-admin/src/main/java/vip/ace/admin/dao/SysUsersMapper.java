package vip.ace.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.ace.admin.domian.SysUsers;
import vip.ace.admin.domian.SysUsersCriteria;

public interface SysUsersMapper {

    int countByExample(SysUsersCriteria example);

    int deleteByExample(SysUsersCriteria example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    List<SysUsers> selectByExample(SysUsersCriteria example);

    SysUsers selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SysUsers record, @Param("example") SysUsersCriteria example);

    int updateByExample(@Param("record") SysUsers record, @Param("example") SysUsersCriteria example);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);
}