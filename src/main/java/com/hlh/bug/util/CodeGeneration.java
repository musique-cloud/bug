package com.hlh.bug.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @ClassName: CodeGeneration
 * @Description: 代码生成器
 */
public class CodeGeneration {

	public static void main(String[] args) {

		String model = "project"; // 模块名
		String[] tableArr = { "bug" }; // 多个表名

// ----------------------------------------------------------------------------------------------------------

		AutoGenerator mpg = new AutoGenerator();
		// 选择 freemarker 引擎，默认 Veloctiy
		// mpg.setTemplateEngine(new FreemarkerTemplateEngine());

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("D:\\temp");
		gc.setFileOverride(true);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setActiveRecord(false);// 关闭AR模式
		gc.setServiceName("%sService"); // 生成的service接口名字首字母是否为I，这样设置就没有I

		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("root");
		dsc.setUrl("jdbc:mysql://localhost:3306/bug?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=Hongkong");
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setInclude(tableArr); // 设置需要生成代码的多个完整表名
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.hlh.bug");
		pc.setMapper("mapper").setService("service").setController("controller").setEntity("entity").setXml("mapper");// 设置xml文件的目录
		mpg.setPackageInfo(pc);
		pc.setModuleName(model);

//        TemplateConfig tc = new TemplateConfig();
//         tc.setController(null);
//        // tc.setEntity(null);
//        // tc.setMapper(null);
//        // tc.setXml(null);
//         tc.setService(null);
//         tc.setServiceImpl(null);
//        mpg.setTemplate(tc);

		// 执行生成
		mpg.execute();
		System.out.println("执行成功!");
	}
}