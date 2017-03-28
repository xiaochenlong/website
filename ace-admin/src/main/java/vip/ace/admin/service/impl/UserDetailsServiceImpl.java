package vip.ace.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vip.ace.admin.dao.SysUsersMapper;
import vip.ace.admin.domian.SysUsers;
import vip.ace.admin.domian.SysUsersCriteria;
import vip.ace.admin.service.SysUsersService;

import java.util.List;

/**
 * Created by xcl on 2017/3/15.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService, SysUsersService {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUsersCriteria ex = new SysUsersCriteria();
        ex.createCriteria().andUserAccountEqualTo(s);
        List<SysUsers> users = sysUsersMapper.selectByExample(ex);
        if (users != null && users.size() == 1) {
            return users.get(0);
        } else {
            throw new UsernameNotFoundException("用户名不存在");
        }
    }

    @Override
    public int save(SysUsers sysUsers) {
        sysUsers.setUserPassword(bCryptPasswordEncoder.encode(sysUsers.getPassword()));
        return sysUsersMapper.insert(sysUsers);
    }

    @Override
    public int del(int userId) {
        return sysUsersMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int update(SysUsers sysUsers) {
        return sysUsersMapper.updateByPrimaryKeySelective(sysUsers);
    }

    @Override
    public List<SysUsers> list(SysUsersCriteria sysUsersCriteria) {
        return sysUsersMapper.selectByExample(sysUsersCriteria);
    }

    @Override
    public int count(SysUsersCriteria sysUsersCriteria) {
        return sysUsersMapper.countByExample(sysUsersCriteria);
    }
}
