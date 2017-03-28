package vip.ace.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ace.admin.dao.SysAuthoritiesMapper;
import vip.ace.admin.domian.*;
import vip.ace.admin.service.SysAuthoritiesService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xcl on 2017/3/28.
 */
@Service
public class SysAuthoritiesServiceImpl implements SysAuthoritiesService {

    @Autowired
    private SysAuthoritiesMapper sysAuthoritiesMapper;

    @Override
    public int save(SysAuthorities authorities) {
        return sysAuthoritiesMapper.insert(authorities);
    }

    @Override
    public int del(int authoritiesId) {
        return sysAuthoritiesMapper.deleteByPrimaryKey(authoritiesId);
    }

    @Override
    public int update(SysAuthorities authorities) {
        return sysAuthoritiesMapper.updateByPrimaryKeySelective(authorities);
    }

    @Override
    public Set<SysAuthorities> listByUser(int userId) {
        List<SysAuthorities> auths = sysAuthoritiesMapper.selectByUserId(userId);
        return new HashSet<SysAuthorities>(auths);
    }

    @Override
    public Set<SysAuthorities> listByRole(int roleId) {
        List<SysAuthorities> auths = sysAuthoritiesMapper.selectByRoleId(roleId);
        return new HashSet<SysAuthorities>(auths);
    }

    @Override
    public List<SysAuthorities> list(SysAuthoritiesCriteria sysAuthoritiesCriteria) {
        return sysAuthoritiesMapper.selectByExample(sysAuthoritiesCriteria);
    }

    @Override
    public int count(SysAuthoritiesCriteria sysAuthoritiesCriteria) {
        return sysAuthoritiesMapper.countByExample(sysAuthoritiesCriteria);
    }
}
