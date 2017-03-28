package vip.ace.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.ace.admin.domian.SysMenu;
import vip.ace.admin.domian.SysMenuCriteria;

public interface SysMenuMapper {
    int countByExample(SysMenuCriteria example);

    int deleteByExample(SysMenuCriteria example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuCriteria example);

    SysMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuCriteria example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuCriteria example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}