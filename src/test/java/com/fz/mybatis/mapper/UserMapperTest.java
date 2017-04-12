package com.fz.mybatis.mapper;

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
public class UserMapperTest {
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
        UserDo userDo=new UserDo();
        /* user.setUserId(Long.valueOf(1000)); */
        userDo.setUserId(1000L);

        UserMapper mapper=session.getMapper(UserMapper.class);
        UserDo user=mapper.queryById(userDo);

        log.info("User : {}", user);
    }

    @Test
    public void testFindById() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserDo user = mapper.findById(1000);

        log.info("User: {}", user);
    }

    @Test
    public void testQueryByList() throws Exception {
        UserDo userDo=new UserDo();
        userDo.setAddress("南");

        UserMapper mapper=session.getMapper(UserMapper.class);

        List<UserDo> list=mapper.queryByList(userDo);

        for(UserDo u:list){
            log.info("UserDo: {}",u);
        }
    }

    @Test
    public void testAddUser() throws Exception {
        UserDo userDo=new UserDo();

        userDo.setUserName("zs");
        userDo.setPassword("123456");
        userDo.setRealName("赵四");
        userDo.setEmail("zs123@qq.com");
        userDo.setCellphone("13612538456");
        userDo.setAddress("北京");
        userDo.setUserType("1");

        UserMapper mapper=session.getMapper(UserMapper.class);

        Integer it=mapper.addUser(userDo);
        /*//默认情况下mybatis是手动提交的（开启事务的）
        session.commit();*/

        log.info("新增影响的行数: {}",it);
    }

    @Test
    public void testModifyUser() throws Exception {
        UserDo userDo=new UserDo();

        userDo.setUserId(1012L);
        userDo.setPassword("654321");

        UserMapper mapper=session.getMapper(UserMapper.class);

        Integer it=mapper.modifyUser(userDo);

        log.info("修改影响的行数: {}", it);
    }

    @Test
    public void testDelUser() throws Exception {
        UserDo user=new UserDo();
        user.setUserId(1003L);

        UserMapper mapper=session.getMapper(UserMapper.class);

        Integer it=mapper.delUser(user);

        log.info("删除影响的行数: {}", it);
    }
}