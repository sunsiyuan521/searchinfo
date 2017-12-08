package cn.com.ideadata.searchinfo.dao.impl;

import cn.com.ideadata.searchinfo.conf.ConfigurationManager;
import cn.com.ideadata.searchinfo.constant.Constants;
import cn.com.ideadata.searchinfo.dao.IFindTableInfoOracleDAO;
import cn.com.ideadata.searchinfo.jdbc.JDBCHelper;
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

public class IFindTableInfoOracleDAOImpl implements IFindTableInfoOracleDAO {
    /**
     * @description 在非实时集群中查询需要插入Oralce的表信息
     * @method  findTableInfo
     * @param args
     * @return java.lang.String[] 查询出的Oracle中的信息 数据库名，表名，表大小，表条目
     * @date: 2017/12/8 11:33
     * @author:sunsiyuan
     */
    String sql = null;
    public String[] findTableInfo(String args[]) {
        String databaseName = ParamUtils.getDatabaseName(args);
        String tableName = ParamUtils.getTableName(args);
        sql = "SELECT max(b.NAME),a.TBL_NAME,max(case c.PARAM_KEY when 'totalSize' then c.param_value else '-1' end)," +
                "max(case c.PARAM_KEY when 'numRows' then c.param_value else '-1' end)" +
                "FROM DBS b,TBLS a " +
                "LEFT JOIN TABLE_PARAMS c ON a.TBL_ID=c.TBL_ID AND (c.PARAM_KEY='totalSize' or c.PARAM_KEY='numRows')" +
                " WHERE b.NAME ='"+databaseName+"' AND a.TBL_NAME = '"+tableName+"' AND a.DB_ID=b.DB_ID GROUP BY a.TBL_NAME";
        System.out.println(sql);
        final String[] oracleData = new String[4];
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        System.out.println("在非实时集群中查询需要插入Oralce的表信息");
        jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
            @Override
            public void process(ResultSet rs) throws Exception {
                if (rs.next()) {
                    oracleData[0] = rs.getString(1);
                    oracleData[1] = rs.getString(2);
                    oracleData[2] = rs.getString(3);
                    oracleData[3] = rs.getString(4);
                    System.out.println("数据库名："+oracleData[0] + "\t表名：" + oracleData[1] +"\t表大小："+oracleData[2]+"\t表条目："+oracleData[3]);
                }
            }
        });
        return oracleData;
    }
}