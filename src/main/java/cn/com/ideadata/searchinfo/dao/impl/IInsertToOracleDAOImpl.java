package cn.com.ideadata.searchinfo.dao.impl;

import cn.com.ideadata.searchinfo.dao.IInsertToOracleDAO;
import cn.com.ideadata.searchinfo.dao.factory.DAOFactory;
import cn.com.ideadata.searchinfo.jdbc.JDBCHelper;

import java.util.*;

/**
 * Created by sunsiyuan on 2017年12月06日
 */

public class IInsertToOracleDAOImpl implements IInsertToOracleDAO {
    String sql = null;
    /**
     * @description 把查询到的数据插入orale
     * @method  insert
     * @param list_tableinfo 获得到的表信息
     * @param laststr 读取配置文件中的表名
     * @return void
     * @date: 2017/12/6 14:47
     * @author:sunsiyuan
     */
    public void insert(List<Map> list_tableinfo, String laststr) {
        List<Object[]> insertList = new ArrayList<Object[]>();
        DAOFactory.getGetTableNameDAO().findTableInfo(laststr);
        for (int i = 0; i < list_tableinfo.size(); i++) {
            Map map = list_tableinfo.get(i);
            Set set = map.keySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Object[] params = new Object[]{};
                params[i] = map.get(it.next());
                insertList.add(params);
            }
        }
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        jdbcHelper.executeBatch(sql,insertList);
    }
}