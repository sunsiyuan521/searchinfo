package cn.com.ideadata.searchinfo;

import cn.com.ideadata.searchinfo.dao.factory.DAOFactory;
import cn.com.ideadata.searchinfo.dao.impl.IInsertToOracleDAOImpl;
import cn.com.ideadata.searchinfo.dao.impl.IReadTBFileDAOImpl;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by sunsiyuan on 2017年12月05日
 */

public class SearchInfo {
    public static void main(String[] args) {
//        读取配置文件获取表名
//        IReadTBFileDAOImpl iReadTBFileDAOImpl = new IReadTBFileDAOImpl();
//        InputStream inputStream = iReadTBFileDAOImpl.getClass().getResourceAsStream("/tablename.txt");
//        String read = iReadTBFileDAOImpl.read(inputStream);
            if (args.length != 2){
                System.out.println("请输入两个参数，第一个为库名，第二个为表名。");
                System.exit(0);
            }
            IInsertToOracleDAOImpl insertData = new IInsertToOracleDAOImpl() ;
            insertData.insert(args);
    }
}