package cn.com.ideadata.searchinfo.dao.impl;

import cn.com.ideadata.searchinfo.conf.ConfigurationManager;
import cn.com.ideadata.searchinfo.constant.Constants;
import cn.com.ideadata.searchinfo.dao.IFindTableInfoMysqlDAO;
import cn.com.ideadata.searchinfo.jdbc.MysqlJDBCHelper;
import cn.com.ideadata.searchinfo.util.ParamUtils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunsiyuan on 2017年12月06日
 */

public class IFindTableInfoMysqlDAOImpl implements IFindTableInfoMysqlDAO {
    /**
     * @description 查询需要插入Mysql的表信息
     * @method  findTableInfo
     * @param args
     * @return java.lang.String[]  Mysql查询出来的信息
     * @date: 2017/12/8 11:28
     * @author:sunsiyuan
     */
    String sql = null;
    public String[] findTableInfo(String args[]){
        String databaseName = ParamUtils.getDatabaseName(args);
        String tableName = ParamUtils.getTableName(args);
        sql = "SELECT max(b.NAME),a.TBL_NAME,max(case c.PARAM_KEY when 'totalSize' then c.param_value else -1 end)," +
                "max(case c.PARAM_KEY when 'numRows' then c.param_value else -1 end)" +
                "FROM DBS b,TBLS a " +
                "LEFT JOIN TABLE_PARAMS c ON a.TBL_ID=c.TBL_ID AND (c.PARAM_KEY='totalSize' or c.PARAM_KEY='numRows')" +
                " WHERE b.NAME ='"+databaseName+"' AND a.TBL_NAME = '"+tableName+"' AND a.DB_ID=b.DB_ID GROUP BY a.TBL_NAME";
        System.out.println(sql);
        final String[] mysqlData = new String[4];
        MysqlJDBCHelper jdbcHelper = MysqlJDBCHelper.getInstance();
        System.out.println("查询需要插入Mysql的表信息");
        jdbcHelper.executeQuery(sql, null, new MysqlJDBCHelper.QueryCallback() {
            @Override
            public void process(ResultSet rs) throws Exception {
                if (rs.next()) {
                    mysqlData[0] = rs.getString(1);
                    mysqlData[1] = rs.getString(2);
                    mysqlData[2] = rs.getString(3);
                    mysqlData[3] = rs.getString(4);
                    System.out.println("数据库名："+mysqlData[0] + "表名：\t" + mysqlData[1] +"表大小：\t"+mysqlData[2]+"表条目：\t"+mysqlData[3]);
               }
            }
        });
        return mysqlData;
    }
}