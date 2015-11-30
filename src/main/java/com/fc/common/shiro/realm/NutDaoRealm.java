package com.fc.common.shiro.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.util.ByteSource;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.fc.common.exception.CreateUserSaltException;
import com.fc.common.exception.IncorrectCaptchaException;
import com.fc.common.exception.IncorrectIpException;
import com.fc.common.util.StringUtils;
import com.fc.modules.sys.bean.Sys_user;

public class NutDaoRealm extends AbstractNutAuthoRealm {
	private static final Log log = Logs.get();
	public NutDaoRealm() {
		setAuthenticationTokenClass(CaptchaUsernamePasswordToken.class);
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws DisabledAccountException {
		CaptchaUsernamePasswordToken authcToken = (CaptchaUsernamePasswordToken) token;
		String accountName = authcToken.getUsername();
		if (Strings.isBlank(accountName)) {
			throw Lang.makeThrow(AuthenticationException.class, "Account is empty");
		}
		Sys_user user = getUserService().fetchByUsername(authcToken.getUsername());
		if (Lang.isEmpty(user)) {
			throw Lang.makeThrow(UnknownAccountException.class, "Account [ %s ] not found", authcToken.getUsername());
		}
		if(!Strings.sNull(user.getLoginIp()).equals(StringUtils.getRemoteAddr())){
			boolean isCaptchaBlank = Strings.isBlank(authcToken.getCaptcha());
			if (isCaptchaBlank) {
				throw Lang.makeThrow(IncorrectIpException.class, "Captcha is must");
			}
			String _captcha = Strings.sBlank(SecurityUtils.getSubject().getSession(true).getAttribute("captcha"));
			if (!authcToken.getCaptcha().equalsIgnoreCase(_captcha)) {
				throw Lang.makeThrow(IncorrectCaptchaException.class, "Captcha is error");
			}
		}
		if (user.isLocked()) {
			throw Lang.makeThrow(LockedAccountException.class, "Account [ %s ] is locked.", authcToken.getUsername());
		}
		String userSalt = user.getSalt();
		if (Strings.isBlank(userSalt)) {
			throw Lang.makeThrow(CreateUserSaltException.class, "Account [ %s ] is not set PassWord", authcToken.getUsername());
		}
		user.setMenus(getUserService().getMenus(user.getId()));
		user.setUnits(getUserService().getUnits(user.getId()));
		List<String> roles=getUserService().getRoleCodeList(user);
		if(roles!=null&&roles.contains("superadmin")){
			user.setSystem(true);
		}
		ByteSource salt = ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		info.setCredentialsSalt(salt);
		return info;
	}
}
