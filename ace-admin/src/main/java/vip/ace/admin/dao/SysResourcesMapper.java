package vip.ace.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.ace.admin.domian.SysResources;
import vip.ace.admin.domian.SysResourcesCriteria;

public interface SysResourcesMapper {
    int countByExample(SysResourcesCriteria example);

    int deleteByExample(SysResourcesCriteria example);

    int deleteByPrimaryKey(Integer resourceId);

    int insert(SysResources record);

    int insertSelective(SysResources record);

    List<SysResources> selectByExample(SysResourcesCriteria example);

    SysResources selectByPrimaryKey(Integer resourceId);

    int updateByExampleSelective(@Param("record") SysResources record, @Param("example") SysResourcesCriteria example);

    int updateByExample(@Param("record") SysResources record, @Param("example") SysResourcesCriteria example);

    int updateByPrimaryKeySelective(SysResources record);

    int updateByPrimaryKey(SysResources record);
}