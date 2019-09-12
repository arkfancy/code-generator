package com.arkfancy.generator.properties.sso;

import com.arkfancy.generator.properties.GeneratorProperties;

public class UserProperties implements GeneratorProperties {

	@Override
	public String getTablePrefix() {
		return "sso_";
	}

	@Override
	public String[] getInclude() {
		return new String[] { "sso_user" };
	}

	@Override
	public String getParent() {
		return "com.arkfancy.sso";
	}

	@Override
	public String getSubModuleName() {
		return "user";
	}

}
