package org.sangaizhi.springboot.mybatis;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

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
	public DataSource dataSource() throws Exception {
		Properties properties = new Properties();
		properties.put("driverClassName", environment.getProperty("jdbc.driver"));
		properties.put("url", environment.getProperty("jdbc.url"));
		properties.put("username", environment.getProperty("jdbc.username"));
		properties.put("password", environment.getProperty("jdbc.password"));
		return DruidDataSourceFactory.createDataSource(properties);
	}


	/**
	 * 根据数据源创建SqlSessionFactory
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
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
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
