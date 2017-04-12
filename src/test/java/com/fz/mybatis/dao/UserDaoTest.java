package com.fz.mybatis.dao;

import com.fz.mybatis.domain.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/11.
 */
@Slf4j
public class UserDaoTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession(true);
        //默认创建session是false 手动提交事务，如果设置true 自动提交事物
        //也可以理解为 false：开启事物  true：关闭事物
        //session=sqlSessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void testQueryById() throws Exception {
        UserDo user=new UserDo();
        /* user.setUserId(Long.valueOf(1000)); */
        user.setUserId(1000L);

        UserDo ud=session.selectOne("user.queryById",user);

        log.info("UserDo:{}", ud);
    }

    @Test
    public void testQueryByList() throws Exception {
        UserDo user=new UserDo();
        user.setAddress("南");

        List<UserDo> list=session.selectList("user.queryByList", user);

        for(UserDo u:list){
            log.info("user:{}",user);
        }
    }

    @Test
    public void testFindByList() throws Exception {
        UserDo user=session.selectOne("user.findByList",1000);

        log.info("UserDo:{}", user);
    }

    @Test
    public void testAddUser() throws Exception {
        UserDo user=new UserDo();

        user.setUserName("zs");
        user.setPassword("123456");
        user.setRealName("赵四");
        user.setEmail("zs123@qq.com");
        user.setCellphone("13612538456");
        user.setAddress("北京");
        user.setUserType("1");

        Integer it=session.insert("user.addUser",user);
        //默认情况下mybatis是手动提交的（开启事务的）
        session.commit();

        log.info("新增影响的行数: {}",it);
    }

    @Test
    public void testModifyUser() throws Exception {
        UserDo user=new UserDo();

        user.setUserId(1012L);
        user.setPassword("654321");

        Integer it=session.update("user.modifyUser", user);

        log.info("修改影响的行数: {}", it);

        session.commit();
    }

    @Test
    public void testDelUser() throws Exception {
        UserDo user=new UserDo();
        user.setUserId(1003L);

        Integer it=session.delete("user.delUser", user);

        log.info("删除影响的行数: {}", it);

        session.commit();
    }

    @Test
    public void testSelectUserOne() throws Exception {
        UserDo user = session.selectOne("user.queryUserById",1000);

//        UserMapper mapper = session.getMapper(UserMapper.class);

//        List<UserDo> user = session.selectList("user.queryUserById",1000);

//        UserDo user = mapper.queryUserById(1000);

        log.info("user:{}",user);
    }
}