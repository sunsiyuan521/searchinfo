package cn.com.ideadata.searchinfo.constant;

/**
 * 常量接口
 *
 *
 */
public interface Constants {

	/**
	 * Oracle配置相关的常量
	 */
	String JDBC_DRIVER = "jdbc.driver";
	String JDBC_DATASOURCE_SIZE = "jdbc.datasource.size";
	String JDBC_URL = "jdbc.url";
	String JDBC_USER = "jdbc.user";
	String JDBC_PASSWORD = "jdbc.password";

	
	/**
	 * Hive作业相关的常量
	 */
	String HIVE_JDBC_DRIVER = "hive.jdbc.driver";
	String HIVE_JDBC_DATASOURCE_SIZE = "hive.jdbc.datasource.size";
	//准实时集群参数
	String HIVE_JDBC_URL_R = "hiver.jdbc.url";
	String HIVE_JDBC_USER_R = "hiver.jdbc.user";
	String HIVE_JDBC_PASSWORD_R = "hiver.jdbc.password";
	//非准实时集群参数
	String HIVE_JDBC_URL_N = "hiven.jdbc.url";
	String HIVE_JDBC_USER_N = "hiven.jdbc.user";
	String HIVE_JDBC_PASSWORD_N = "hiven.jdbc.password";
	
	/**
	 * mysql作业相关的常量
	 */
	String MYSQL_JDBC_DRIVER = "mysql.jdbc.driver";
	String MYSQL_JDBC_DATASOURCE_SIZE = "mysql.jdbc.datasource.size";
	String MYSQL_JDBC_URL = "mysql.jdbc.url";
	String MYSQL_JDBC_USER = "mysql.jdbc.user";
	String MYSQL_JDBC_PASSWORD = "mysql.jdbc.password";

	/**
	 * HDFS作业相关的常量
	 */
	String HDFS_URL_R = "hdfs.url.r";
	String HDFS_URL_N = "hdfs.url.n";
	String HADOOP_USER_NAME ="hadoop.user.name";

	/**
	 * 任务相关的常量
	 */
	String SERVER_ID_R = "server.id.r";
	String DATABASE_HEAD ="database.head";
	String REGEX_COMMON="regex.common";
	String REGEX_SPECIAL="regex.special";
	String TABLENAME_ORALE="tablename.oracle";
	String TABLE_ORACLE_COLUMN_DATABASE= "table.oracle.column.database";
	String TABLE_ORACLE_COLUMN_TABLENAME = "table.oracle.column.tablename";
	String TABLE_ORACLE_COLUMN_TABLESIZE = "table.oracle.column.tablesize";
	String TABLE_ORACLE_COLUMN_TABLEROWS= "table.oracle.column.tablerows";

}
