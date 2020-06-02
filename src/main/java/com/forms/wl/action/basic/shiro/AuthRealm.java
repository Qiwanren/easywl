package com.forms.wl.action.basic.shiro;

import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.forms.wl.action.basic.login.entity.UserInfo;
import com.forms.wl.action.basic.login.service.UserService;


public class AuthRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;
    
    private static Logger logger=LoggerFactory.getLogger(AuthRealm.class.getName());
    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	
    	logger.info(" ====================  开始认证.登录     ====================== ");
    	
    	UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        UserInfo user = userService.findUserByLoginId(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
    	logger.info(" ====================  开始授权     ====================== ");
    	UserInfo user=(UserInfo) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<String>();
        
        List<String> roles = userService.findRolesByUserId(user.getUserId());
        if(roles.size()>0) {
            for(String role : roles) {
                List<String> modules = userService.findModulesByRoleId(role);
                if(modules.size()>0) {
                    for(String module : modules) {
                        permissions.add(module);
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

}
