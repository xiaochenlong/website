package vip.ace.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.ace.admin.dao.SysResourcesMapper;
import vip.ace.admin.domian.SysAuthorities;
import vip.ace.admin.domian.SysResources;
import vip.ace.admin.domian.SysResourcesCriteria;
import vip.ace.admin.service.SysResourcesService;

import java.util.List;
import java.util.Set;

/**
 * Created by xcl on 2017/3/29.
 */

@Service
public class SysResourcesServiceImpl implements SysResourcesService {

    @Autowired
    private SysResourcesMapper sysResourcesMapper;


    @Override
    public int save(SysResources sysResources) {
        return sysResourcesMapper.insert(sysResources);
    }

    @Override
    public int del(int sysresourceId) {
        return sysResourcesMapper.deleteByPrimaryKey(sysresourceId);
    }

    @Override
    public int update(SysResources sysResources) {
        return sysResourcesMapper.updateByPrimaryKey(sysResources);
    }

    @Override
    @Transactional
    public Set<Integer> listAuthoritiesIdByResource(String url) {
        return sysResourcesMapper.listAuthoritiesIdByResource(url);
    }


    @Override
    public List<SysResources> list(SysResourcesCriteria sysResourcesCriteria) {
        return sysResourcesMapper.selectByExample(sysResourcesCriteria);
    }

    @Override
    public int count(SysResourcesCriteria sysResourcesCriteria) {
        return sysResourcesMapper.countByExample(sysResourcesCriteria);
    }
}
