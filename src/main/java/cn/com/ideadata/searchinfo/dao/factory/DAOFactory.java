package cn.com.ideadata.searchinfo.dao.factory;
import cn.com.ideadata.searchinfo.dao.IFindTableInfoMysqlDAO;
import cn.com.ideadata.searchinfo.dao.IFindTableInfoOracleDAO;
import cn.com.ideadata.searchinfo.dao.IInsertToOracleDAO;
import cn.com.ideadata.searchinfo.dao.IReadTBFileDAO;
import cn.com.ideadata.searchinfo.dao.impl.IFindTableInfoMysqlDAOImpl;
import cn.com.ideadata.searchinfo.dao.impl.IFindTableInfoOracleDAOImpl;
import cn.com.ideadata.searchinfo.dao.impl.IInsertToOracleDAOImpl;
import cn.com.ideadata.searchinfo.dao.impl.IReadTBFileDAOImpl;

/**
 * Created by Sun Siyuan on 2017/10/24.
 */
public class DAOFactory {
    public static IReadTBFileDAO getReadTBFileDAO() {return new IReadTBFileDAOImpl();}
    public static IFindTableInfoOracleDAO getFindTableInfoOracleDAO(){return new IFindTableInfoOracleDAOImpl();}
    public static IFindTableInfoMysqlDAO getFindTableInfoMysqlDAO(){return new IFindTableInfoMysqlDAOImpl();}
    public static IInsertToOracleDAO getInsertToOracleDAO(){return new IInsertToOracleDAOImpl();}}