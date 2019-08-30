package com.haha.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;

public class DBFactory {
    //SqlSessionFactory一旦创建将会作用在整个周期所以将其创建为静态
    public static SqlSessionFactory sqlSessionFactory = null;
    static {

        //创建SqlSqlSessionFactory
        String resource = "mybatis-config.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"mysql");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSqlSession(){

        return sqlSessionFactory.openSession();
    }
}
