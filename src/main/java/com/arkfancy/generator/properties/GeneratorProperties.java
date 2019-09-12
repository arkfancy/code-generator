package com.arkfancy.generator.properties;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.arkfancy.generator.properties.notes.PokemonProperties;
import com.arkfancy.generator.properties.sso.UserProperties;
import com.arkfancy.generator.util.PropertiesUtils;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public interface GeneratorProperties {

	GeneratorProperties SSO_USER = new UserProperties();

	GeneratorProperties NOTES_POKEMON = new PokemonProperties();

	static GeneratorProperties get(String key) {
		if ("user".equals(key)) {
			return new UserProperties();
		} else if ("pokemon".equals(key)) {
			return new PokemonProperties();
		}
		throw new RuntimeException("unknow key: " + key);
	}

	/*-----------------------------DataSourceConfig-----------------------------*/

	default DbType getDbType() {
		return DbType.getDbType(PropertiesUtils.get("database"));
	}

	default String getUrl() {
		return PropertiesUtils.get("url");
	}

	default String getUsername() {
		return PropertiesUtils.get("username");
	};

	default String getPassword() {
		return PropertiesUtils.get("password");
	}

	default String getDriverName() {
		return PropertiesUtils.get("driver");
	}

	/*-----------------------------StrategyConfig-----------------------------*/

	default NamingStrategy getNaming() {
		return NamingStrategy.underline_to_camel;
	}

	String getTablePrefix();

	String[] getInclude();

	default boolean getEntityColumnConstant() {
		return true;
	}

	default boolean getEntityBuilderModel() {
		return true;
	}

	default boolean getEntityLombokModel() {
		return false;
	}

	default boolean getRestControllerStyle() {
		return true;
	}

	default boolean getControllerMappingHyphenStyle() {
		return true;
	}

	default boolean getEntityTableFieldAnnotationEnable() {
		return true;
	}

	default String getSuperControllerClass() {
		return "com.baomidou.mybatisplus.extension.api.ApiController";
	}

	/*-----------------------------PackageConfig-----------------------------*/

	String getParent();

	String getSubModuleName();

	default String getSubModulePackagePath() {
		return StringUtils.isEmpty(getSubModuleName()) ? "" : "." + getSubModuleName();
	}

	default String getSubModuleDirPath() {
		return StringUtils.isEmpty(getSubModuleName()) ? "" : "/" + getSubModuleName();
	}

	/*-----------------------------GlobalConfig-----------------------------*/

	default String getOutputDir() {
		return new File("").getAbsolutePath() + File.separator + "src/main/java";
	}

	default boolean getFileOverride() {
		return true;
	}

	default boolean getOpen() {
		return true;
	}

	default String getAuthor() {
		return System.getProperty("user.name");
	}

	default boolean getActiveRecord() {
		return true;
	}

	default boolean getBaseResultMap() {
		return true;
	}

	default DateType getDateType() {
		return DateType.TIME_PACK;
	}

	default String getServiceName() {
		return "%sService";
	}

	default IdType getIdType() {
		return IdType.AUTO;
	}

	/*-----------------------------InjectionConfig-----------------------------*/

	default Map<String, Object> getInitMap() {
		return null;
	}

	default List<FileOutConfig> getFileOutConfigList() {
		return Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
			// 自定义输出文件目录
			@Override
			public String outputFile(TableInfo tableInfo) {
				return new File("").getAbsolutePath() + "/src/main/resources/mapper" + getSubModuleDirPath() + "/"
						+ tableInfo.getEntityName() + "Mapper.xml";
			}
		});
	}

}
