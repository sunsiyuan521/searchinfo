package cn.com.ideadata.searchinfo.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by sunsiyuan on 2017/12/6.
 */
public interface IFindTableInfoDAO {
    List<Map> findTableInfo(String laststr);
}
