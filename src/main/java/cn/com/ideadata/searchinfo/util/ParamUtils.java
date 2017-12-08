package cn.com.ideadata.searchinfo.util;

/**
 * 参数工具类
 *
 *
 */
public class ParamUtils {
	/**
	 * @description 通过参数获取数据库名
	 * @method  getDatabaseName
	 * @param args
	 * @return java.lang.String 数据库名
	 * @date: 2017/12/8 11:19
	 * @author:sunsiyuan
	 */
	public static String getDatabaseName(String[] args) {
		String sqlStr = null;
		try {
				if(args != null && args.length > 0) {
					sqlStr = String.valueOf(args[0]);
					return sqlStr;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	/**
	 * @description 通过参数获取表名
	 * @method  getTableName
	 * @param args
	 * @return java.lang.String  表名
	 * @date: 2017/12/8 11:19
	 * @author:sunsiyuan
	 */
	public static String getTableName(String[] args) {
		String clusterID=null;
		try {
			if(args != null && args.length > 0) {
				clusterID=String.valueOf(args[1]);
				return clusterID;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
