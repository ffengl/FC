package com.fc.modules;

import org.nutz.mvc.annotation.ChainBy;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import com.fc.common.mvc.view.VelocityViewMaker;

/**
 * Created by Wizzer.cn on 2015/6/26.
 */
@Modules(scanPackage = true)
@Ok("raw")
@Fail("http:500")
@IocBy(type=ComboIocProvider.class,args={"*json","config/ioc/","*anno","com.fc","*tx","*org.nutz.integration.quartz.QuartzIocLoader"})
@Localization(value="msg/", defaultLocalizationKey="zh_CN")
@Encoding(input = "UTF-8", output = "UTF-8")
@Views({ VelocityViewMaker.class})
@SetupBy(value=MainSetup.class)
@ChainBy(args="mvc/nutzfw-mvc-chain.js")
public class MainModule {

	public MainModule()
	{

	}
}

