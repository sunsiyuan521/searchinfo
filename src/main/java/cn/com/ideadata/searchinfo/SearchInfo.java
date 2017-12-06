package cn.com.ideadata.searchinfo;

import cn.com.ideadata.searchinfo.dao.factory.DAOFactory;
import cn.com.ideadata.searchinfo.dao.impl.IReadTBFileDAOImpl;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by sunsiyuan on 2017年12月05日
 */

public class SearchInfo {
    public static void main(String[] args) {
        IReadTBFileDAOImpl iReadTBFileDAOImpl = new IReadTBFileDAOImpl();
        InputStream inputStream = iReadTBFileDAOImpl.getClass().getResourceAsStream("/tablename.txt");
        String read = iReadTBFileDAOImpl.read(inputStream);
        List<Map> tableInfo = DAOFactory.getGetTableNameDAO().findTableInfo(read);
        DAOFactory.getInsertToOracleDAO().insert(tableInfo,read);

    }
}