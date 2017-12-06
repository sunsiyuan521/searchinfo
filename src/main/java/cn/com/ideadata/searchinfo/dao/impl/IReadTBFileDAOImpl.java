package cn.com.ideadata.searchinfo.dao.impl;

import cn.com.ideadata.searchinfo.dao.IReadTBFileDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by sunsiyuan on 2017年12月05日
 */

public class IReadTBFileDAOImpl implements IReadTBFileDAO{
    /**
     * @description 读取表名
     * @method  read
     * @param inputStream
     * @return java.lang.String
     * @date: 2017/12/6 12:45
     * @author:sunsiyuan
     */
    public static String read(InputStream inputStream) {

        BufferedReader reader = null;
        String laststr = "";
        try{
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
}