package vip.ace.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ace.admin.dao.SysRolesMapper;
import vip.ace.admin.domian.SysRoles;
import vip.ace.admin.domian.SysRolesCriteria;
import vip.ace.admin.service.SysRolesService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xcl on 2017/3/28.
 */
@Service
public class SysRolesServiceImpl implements SysRolesService {

    @Autowired
    private SysRolesMapper sysRolesMapper;


    @Override
    public int save(SysRoles sysRoles) {
        return sysRolesMapper.insert(sysRoles);
    }

    @Override
    public int del(int roleId) {
        return sysRolesMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int update(SysRoles sysRoles) {
        return sysRolesMapper.updateByPrimaryKeySelective(sysRoles);
    }

    @Override
    public Set<SysRoles> listByUser(int userId) {
        List<SysRoles> rols = sysRolesMapper.selectByUserId(userId);
        return new HashSet<SysRoles>(rols);
    }

    @Override
    public List<SysRoles> list(SysRolesCriteria sysRolesCriteria) {
        return sysRolesMapper.selectByExample(sysRolesCriteria);
    }

    @Override
    public int count(SysRolesCriteria sysRolesCriteria) {
        return sysRolesMapper.countByExample(sysRolesCriteria);
    }
}
