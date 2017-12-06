package cn.com.ideadata.searchinfo.dao.impl;

import cn.com.ideadata.searchinfo.conf.ConfigurationManager;
import cn.com.ideadata.searchinfo.constant.Constants;
import cn.com.ideadata.searchinfo.dao.IFindTableInfoDAO;
import cn.com.ideadata.searchinfo.jdbc.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunsiyuan on 2017年12月06日
 */

public class IFindTableInfoDAOImpl implements IFindTableInfoDAO {
    String sql = null;
    /**
     * @description 查找要插入Oralce结果表的信息
     * @method  findTableInfo
     * @param laststr 读取出来的表名
     * @return java.util.List<java.util.Map>
     * @date: 2017/12/6 12:46
     * @author:sunsiyuan
     */
    public List<Map> findTableInfo(String laststr) {
        sql = "SELECT max(b.NAME),a.TBL_NAME,max(case c.PARAM_KEY when 'totalSize' then c.param_value else -1 end)," +
                "max(case c.PARAM_KEY when 'numRows' then c.param_value else -1 end)," +
                "FROM DBS b,TBLS a " +
                "LEFT JOIN TABLE_PARAMS c ON a.TBL_ID=c.TBL_ID AND (c.PARAM_KEY='totalSize' or c.PARAM_KEY='numRows')" +
                "WHERE b.NAME in (" + laststr + ") AND a.DB_ID=b.DB_ID GROUP BY a.TBL_NAME";
        final List<Map> list_tableinfo = new ArrayList<Map>();
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
            @Override
            public void process(ResultSet rs) throws Exception {
                while (rs.next()) {
                    Map<String, List<String>> tableinfo = new HashMap<String, List<String>>();
                    String database = rs.getString(1);
                    String tablename = rs.getString(2);
                    String tablesize = rs.getString(3);
                    String tablerows = rs.getString(4);
                    tableinfo.get(database).add(ConfigurationManager.getProperty(Constants.TABLE_ORACLE_COLUMN_DATABASE));
                    tableinfo.get(tablename).add(ConfigurationManager.getProperty(Constants.TABLE_ORACLE_COLUMN_TABLENAME));
                    tableinfo.get(tablesize).add(ConfigurationManager.getProperty(Constants.TABLE_ORACLE_COLUMN_TABLESIZE));
                    tableinfo.get(tablerows).add(ConfigurationManager.getProperty(Constants.TABLE_ORACLE_COLUMN_TABLEROWS));
                  //  tableinfo.put(ConfigurationManager.getProperty(Constants.TABLE_ORACLE_COLUMN_DATABASE), database);
                  //  tableinfo.put(ConfigurationManager.getProperty(Constants.TABLE_ORACLE_COLUMN_TABLENAME), tablename);
                 //   tableinfo.put(ConfigurationManager.getProperty(Constants.TABLE_ORACLE_COLUMN_TABLESIZE), tablesize);
                  //  tableinfo.put(ConfigurationManager.getProperty(Constants.TABLE_ORACLE_COLUMN_TABLEROWS), tablerows);
                    for (String key : tableinfo.keySet()) {
                        tableinfo.get(key);
                    }
                    list_tableinfo.add(tableinfo);
                }
            }
        });
        return list_tableinfo;
    }
}