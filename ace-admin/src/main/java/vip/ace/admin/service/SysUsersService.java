package vip.ace.admin.service;

import vip.ace.admin.domian.SysAuthorities;
import vip.ace.admin.domian.SysUsers;
import vip.ace.admin.domian.SysUsersCriteria;

import java.util.List;

/**
 * Created by xcl on 2017/3/28.
 */
public interface SysUsersService {


    int save(SysUsers sysUsers);

    int del(int userId);

    int update(SysUsers sysUsers);

    List<SysUsers> list(SysUsersCriteria sysUsersCriteria);

    int count(SysUsersCriteria sysUsersCriteria);
}
