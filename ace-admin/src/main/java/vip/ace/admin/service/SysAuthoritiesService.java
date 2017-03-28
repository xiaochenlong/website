package vip.ace.admin.service;
import vip.ace.admin.domian.SysAuthorities;
import vip.ace.admin.domian.SysAuthoritiesCriteria;

import java.util.List;
import java.util.Set;

/**
 * Created by xcl on 2017/3/28.
 */
public interface SysAuthoritiesService {

    int save(SysAuthorities authorities);

    int del(int authoritiesId);

    int update(SysAuthorities authorities);

    Set<SysAuthorities> listByUser(int userId);

    Set<SysAuthorities> listByRole(int role);


    List<SysAuthorities> list(SysAuthoritiesCriteria sysAuthoritiesCriteria);

    int count(SysAuthoritiesCriteria sysAuthoritiesCriteria);
}
