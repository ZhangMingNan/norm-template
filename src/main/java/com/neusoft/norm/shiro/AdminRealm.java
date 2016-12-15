package com.neusoft.norm.shiro;

import com.google.common.collect.Sets;
import com.neusoft.norm.domain.Admin;
import com.neusoft.norm.service.AdminService;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * 作者: 张明楠 创建于 16/12/1.
 */
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    AdminService adminService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Admin admin = (Admin) principalCollection.getPrimaryPrincipal();
        Set<String> permissions = Sets.newHashSet();
        List<String> permissionsList = adminService.findPermissionsByRoleid(admin.getRoleid().intValue());
        //根据这个用户获取权限标记集合
        for (int i = 0; i < permissionsList.size(); i++) {
            String p = StringUtils.trim(permissionsList.get(i));
            if (StringUtils.isNotEmpty(p)) {
                String[] split = StringUtils.split(p, ",");
                for (int j = 0; j < split.length; j++) {
                    permissions.add(split[j]);
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permissions);
        return info;
    }


    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到用户名密码
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        Admin admin = adminService.selectByUserName(username);
        //账号不存在
        if (admin == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        //密码错误
        if (!password.equals(admin.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin, password, getName());
        return info;
    }
}















