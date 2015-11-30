var chain={
	"default" : {
		"ps" : [
			  "com.fc.common.mvc.processor.LogTimeProcessor",
			  "com.fc.common.mvc.processor.GlobalsSettingProcessor",
			  "org.nutz.mvc.impl.processor.UpdateRequestAttributesProcessor",
		      "org.nutz.mvc.impl.processor.EncodingProcessor",
		      "com.fc.common.mvc.processor.XSSProcessor",
		      "org.nutz.mvc.impl.processor.ModuleProcessor",
		      "com.fc.common.mvc.processor.NutShiroProcessor",
		      "org.nutz.mvc.impl.processor.ActionFiltersProcessor",
		      "org.nutz.mvc.impl.processor.AdaptorProcessor",
		      "org.nutz.mvc.impl.processor.MethodInvokeProcessor",
			  "org.nutz.mvc.impl.processor.ViewProcessor"
		],
		"error" : 'org.nutz.mvc.impl.processor.FailProcessor'
	}
};