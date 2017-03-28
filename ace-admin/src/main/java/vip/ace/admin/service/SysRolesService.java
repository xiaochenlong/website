package vip.ace.admin.service;

import vip.ace.admin.domian.SysRoles;
import vip.ace.admin.domian.SysRolesCriteria;

import java.util.List;
import java.util.Set;

/**
 * Created by xcl on 2017/3/28.
 */
public interface SysRolesService {

    int save(SysRoles sysRoles);

    int del(int roleId);

    int update(SysRoles sysRoles);

    Set<SysRoles> listByUser(int userId);

    List<SysRoles> list(SysRolesCriteria sysRolesCriteria);

    int count(SysRolesCriteria sysRolesCriteria);

}
