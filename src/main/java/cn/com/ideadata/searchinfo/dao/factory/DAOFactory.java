package cn.com.ideadata.searchinfo.dao.factory;
import cn.com.ideadata.searchinfo.dao.IFindTableInfoDAO;
import cn.com.ideadata.searchinfo.dao.IInsertToOracleDAO;
import cn.com.ideadata.searchinfo.dao.IReadTBFileDAO;
import cn.com.ideadata.searchinfo.dao.impl.IFindTableInfoDAOImpl;
import cn.com.ideadata.searchinfo.dao.impl.IInsertToOracleDAOImpl;
import cn.com.ideadata.searchinfo.dao.impl.IReadTBFileDAOImpl;

/**
 * Created by Sun Siyuan on 2017/10/24.
 */
public class DAOFactory {
    public static IReadTBFileDAO getReadTBFileDAO() {
        return new IReadTBFileDAOImpl();
    }

    public static IFindTableInfoDAO getGetTableNameDAO() {
        return new IFindTableInfoDAOImpl();
    }
    public static IInsertToOracleDAO getInsertToOracleDAO(){return new IInsertToOracleDAOImpl();}
}