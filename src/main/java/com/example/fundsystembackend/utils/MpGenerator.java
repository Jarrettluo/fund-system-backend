package com.example.fundsystembackend.utils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MpGenerator {
    public static void main(String[] args) {
        // 创建代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig config = new GlobalConfig();
        String  dirPath = System.getProperty("user.dir");
        config.setOutputDir(dirPath + "/src/main/java");
        System.out.println(dirPath + "/src/main/java/com");
        config.setAuthor("luojiarui");
        config.setServiceName("fundSystem");
        autoGenerator.setGlobalConfig(config);

        // 配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/fund_system?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        autoGenerator.setDataSource(dataSourceConfig);

        // 配置包
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("hirain");
        packageConfig.setController("controller");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        autoGenerator.setPackageInfo(packageConfig);

        // 配置生成表
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("myfund");
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);

        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();

    }
}
