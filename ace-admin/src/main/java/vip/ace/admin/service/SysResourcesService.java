package vip.ace.admin.service;

import vip.ace.admin.domian.SysAuthorities;
import vip.ace.admin.domian.SysResources;
import vip.ace.admin.domian.SysResourcesCriteria;

import java.util.List;
import java.util.Set;

/**
 * Created by xcl on 2017/3/29.
 */
public interface SysResourcesService {

    int save(SysResources sysResources);

    int del(int sysresourceId);

    int update(SysResources sysResources);

    Set<Integer> listAuthoritiesIdByResource(String url);

    List<SysResources> list(SysResourcesCriteria sysResourcesCriteria);

    int count(SysResourcesCriteria sysResourcesCriteria);
}
