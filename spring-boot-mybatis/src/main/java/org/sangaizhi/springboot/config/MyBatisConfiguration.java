package org.sangaizhi.springboot.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.sangaizhi.springboot.config.datasource.DatabaseType;
import org.sangaizhi.springboot.config.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * spring boot 集成mybatis 的基本路口， 1） 创建数据源 2） 创建 sessionFactory 3） 配置事务管理器
 * 
 * @author sangaizhi
 * @date 2017/6/22
 */

@Configuration
@MapperScan(basePackages ={"org.sangaizhi.springboot.mapper", "org.sangaizhi.springboot.dao"})
public class MyBatisConfiguration {

	private static final String MAPPER_PATH = "/mapper/**.xml";
	@Autowired
	private Environment environment;
	private String MYBATIS_CONFIG = "mybatis-config.xml";

	/**
	 * 创建数据源
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
	public DataSource testDbDataSource() throws Exception {
		Properties properties = new Properties();
		properties.put("driverClassName", environment.getProperty("jdbc.driver"));
		properties.put("url", environment.getProperty("jdbc.url"));
		properties.put("username", environment.getProperty("jdbc.username"));
		properties.put("password", environment.getProperty("jdbc.password"));
		return DruidDataSourceFactory.createDataSource(properties);
	}

	@Bean
	public DataSource testDb2DataSource() throws Exception {
		Properties properties = new Properties();
		properties.put("driverClassName", environment.getProperty("jdbc2.driver"));
		properties.put("url", environment.getProperty("jdbc2.url"));
		properties.put("username", environment.getProperty("jdbc2.username"));
		properties.put("password", environment.getProperty("jdbc2.password"));
		return DruidDataSourceFactory.createDataSource(properties);
	}

	/**
	 * 动态数据源
	 * 
	 * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
	 * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入
	 * @param testDbDataSource
	 * @param testDb2DataSource
	 * @return
	 */
	@Bean
	@Primary
	public DynamicDataSource dataSource(@Qualifier("testDbDataSource") DataSource testDbDataSource,
		@Qualifier("testDb2DataSource") DataSource testDb2DataSource) {
		Map<Object, Object> targetDataSource = new HashMap<>();
		targetDataSource.put(DatabaseType.testdb, testDbDataSource);
		targetDataSource.put(DatabaseType.testdb2, testDb2DataSource);

		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSource);
		dataSource.setDefaultTargetDataSource(testDbDataSource);
		return dataSource;
	}

	/**
	 * 根据数据源创建SqlSessionFactory
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DynamicDataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
		sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(
			pathMatchingResourcePatternResolver.getResources(environment.getProperty("mybatis.mapperLocations")));
		return sqlSessionFactoryBean.getObject();
	}

	/**
	 * 配置事务管理器
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
