package org.sangaizhi.springboot.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.sangaizhi.springboot.config.datasource.DatabaseType;
import org.sangaizhi.springboot.config.datasource.DynamicDataSource;
import org.springframework.stereotype.Component;

/**
 * 数据源切面 通过切面server包中的方法，根据方法的名称为接下来的操作选择不同的数据源
 * 
 * @author sangaizhi
 * @date 2017/6/23
 */
@Component
@Aspect
public class DataSourceAspect {

	@Pointcut("execution(* org.sangaizhi.springboot.service.*.*(..))")
	public void declareJoinPointExpression() {
	}

	@Before("declareJoinPointExpression()")
	public void setDataSourceKey(JoinPoint point) {
		String name = point.getSignature().getName();
		name = name.toLowerCase();
		boolean isWrite = StringUtils.startsWithAny(name, "save","update","delete","insert","add","modify");
		if (isWrite) {
			DynamicDataSource.DatabaseContextHolder.setDatabaseType(DatabaseType.testdb);
		} else {
			DynamicDataSource.DatabaseContextHolder.setDatabaseType(DatabaseType.testdb2);
		}
	}

}
