package com.arkfancy.generator;

import com.arkfancy.generator.properties.GeneratorProperties;
import com.arkfancy.generator.util.PropertiesUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;

public class CodeGenerator {

	private static GeneratorProperties properties;

	static {
		properties = GeneratorProperties.get(PropertiesUtils.get("key"));
//		properties = GeneratorProperties.NOTES_POKEMON;
	}

	public static void main(String[] args) {
		AutoGenerator generator = new AutoGenerator()//
				.setDataSource(dataSourceConfig())// 数据源
				.setStrategy(strategyConfig())// 策略
				.setPackageInfo(packageConfig())// 包
				.setGlobalConfig(globalConfig())// 全局
				.setCfg(injectionConfig())// 注入
				.setTemplate(templateConfig())// 模板
		;

		generator.execute();

	}

	private static DataSourceConfig dataSourceConfig() {
		return new DataSourceConfig()//
				.setDbType(properties.getDbType())// 数据库类型
				.setUrl(properties.getUrl())// 数据库连接
				.setDriverName(properties.getDriverName())// 数据库驱动
				.setUsername(properties.getUsername())// 用户名
				.setPassword(properties.getPassword())// 密码
		;
	}

	private static StrategyConfig strategyConfig() {
		return new StrategyConfig()//
				.setNaming(properties.getNaming())// 命名规则
				.setTablePrefix(properties.getTablePrefix()) // 表前缀
				.setInclude(properties.getInclude())// 包含表
				.setEntityColumnConstant(properties.getEntityColumnConstant())// 生成字段常量
				.setEntityBuilderModel(properties.getEntityBuilderModel())// 构建者模式
				.setEntityLombokModel(properties.getEntityLombokModel())// lombok注解
				.setRestControllerStyle(properties.getRestControllerStyle())// rest风格控制器
				.setControllerMappingHyphenStyle(properties.getControllerMappingHyphenStyle())// 请求路径连字符
				.setEntityTableFieldAnnotationEnable(properties.getEntityTableFieldAnnotationEnable())// 实体字段注解
				.setSuperControllerClass(properties.getSuperControllerClass())// 控制器父类
		;
	}

	private static PackageConfig packageConfig() {
		return new PackageConfig()//
				.setParent(properties.getParent())// 父包
				.setController("controller" + properties.getSubModulePackagePath())// 控制器
				.setService("service" + properties.getSubModulePackagePath())// 服务接口
				.setServiceImpl("service" + properties.getSubModulePackagePath() + ".impl")// 服务实现
				.setMapper("mapper" + properties.getSubModulePackagePath())// 映射
				.setEntity("entity" + properties.getSubModulePackagePath())// 实体
		;
	}

	private static GlobalConfig globalConfig() {
		return new GlobalConfig()//
				.setOutputDir(properties.getOutputDir())// 输出路径
				.setFileOverride(properties.getFileOverride())// 覆盖文件
				.setOpen(properties.getOpen())// 完成后打开路径
				.setAuthor(properties.getAuthor())// 作者
				.setActiveRecord(properties.getActiveRecord())// 充血模型
				.setBaseResultMap(properties.getBaseResultMap())// xml基础结果集
				.setDateType(properties.getDateType())// 数据库时间类型
				.setServiceName(properties.getServiceName())// 服务接口名称
				.setIdType(properties.getIdType())// 主键类型
		;
	}

	private static InjectionConfig injectionConfig() {
		return new InjectionConfig() {
			@Override
			public void initMap() {
				setMap(properties.getInitMap());// 自定义参数
			}
		}//
				.setFileOutConfigList(properties.getFileOutConfigList())// 文件输出目录
		;
	}

	private static TemplateConfig templateConfig() {
		return new TemplateConfig().setXml(null);
	}
}
