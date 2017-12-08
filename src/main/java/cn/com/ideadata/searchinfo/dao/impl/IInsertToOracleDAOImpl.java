package cn.com.ideadata.searchinfo.dao.impl;

import cn.com.ideadata.searchinfo.dao.IInsertToOracleDAO;
import cn.com.ideadata.searchinfo.dao.factory.DAOFactory;
import cn.com.ideadata.searchinfo.jdbc.JDBCHelper;
import cn.com.ideadata.searchinfo.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sunsiyuan on 2017年12月06日
 */

public class IInsertToOracleDAOImpl implements IInsertToOracleDAO {
    String sql = null;
    /**
     * @description 把两个集群查出的数据插入oracle
     * @method  insert
     * @param args
     * @return void
     * @date: 2017/12/8 11:38
     * @author:sunsiyuan
     */
    public void insert(String args[]) {
        //mysql查询出来的信息
        String[] mysqlInfo = DAOFactory.getFindTableInfoMysqlDAO().findTableInfo(args);
        //oracle查询出来的信息
        String[] oracleInfo = DAOFactory.getFindTableInfoOracleDAO().findTableInfo(args);
        sql="insert into compare_table_test VALUES(?,?,?,?,?,?,?)";
        System.out.println(sql);
        if (oracleInfo.length != 4){
            JDBCHelper.getInstance().executeUpdate(sql,args[0],args[1],mysqlInfo[2],mysqlInfo[3],null,null,DateUtils.formatDate(new Date())) ;
        }
            JDBCHelper.getInstance().executeUpdate(sql,args[0],args[1],mysqlInfo[2],mysqlInfo[3],oracleInfo[2],oracleInfo[3], DateUtils.formatDate(new Date())) ;
    }
}