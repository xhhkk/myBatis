package com.fz.mybatis.dao.impl;

import com.fz.mybatis.dao.UserDao;
import com.fz.mybatis.domain.UserDo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */
public class UserDaoImpl implements UserDao{

    SqlSessionFactory sqlSessionFactory;

    SqlSession session;

    public UserDaoImpl() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    public UserDo queryById(UserDo userDo) {

        return session.selectOne("");
    }

    public UserDo findById(Integer userId) {

        return null;
    }

    public List<UserDo> queryByList(UserDo userDo) {

        return null;
    }

    public Integer addUser(UserDo userDo) {

        return null;
    }

    public Integer modifyUser(UserDo userDo) {

        return null;
    }

    public Integer delUser(UserDo userDo) {

        return null;
    }
}
