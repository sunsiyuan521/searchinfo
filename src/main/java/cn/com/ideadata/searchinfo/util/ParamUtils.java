package cn.com.ideadata.searchinfo.util;

/**
 * 参数工具类
 *
 *
 */
public class ParamUtils {
	/**
	 * 从命令行参数中提取sql脚本名
	 * @param args 命令行参数
	 * @return sql脚本名
	 */
	public static String getSqlName(String[] args) {
		String sqlStr = null;
		try {
				if(args != null && args.length > 0) {
					sqlStr = String.valueOf(args[1]);
					return sqlStr;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	/**
	 * 从命令行参数中提取日期字符串
	 * @param args 命令行参数
	 * @return 日期字符串
	 */
	public static String getTaskDate(String[] args) {
		String datestr=null;
		try {
			if(args != null && args.length > 0) {
				datestr=String.valueOf(args[0]);
				return datestr;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 从命令行参数中提取集群ID
	 * @param args 命令行参数
	 * @return 集群ID
	 */
	public static String getClusterID(String[] args) {
		String clusterID=null;
		try {
			if(args != null && args.length > 0) {
				clusterID=String.valueOf(args[2]);
				return clusterID;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
