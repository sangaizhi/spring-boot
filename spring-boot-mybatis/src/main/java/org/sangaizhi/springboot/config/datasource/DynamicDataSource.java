package org.sangaizhi.springboot.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author sangaizhi
 * @date 2017/6/22
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DatabaseContextHolder.getDatabaseType();
	}

	public static class DatabaseContextHolder {

		private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

		public static void setDatabaseType(DatabaseType type) {
			contextHolder.set(type);
		}

		public static DatabaseType getDatabaseType() {
			return contextHolder.get();
		}
	}
}
