package com.fz.mybatis.dao;

import com.fz.mybatis.domain.UserDo;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */
public interface UserDao {
    public UserDo queryById(UserDo userDo);
    public UserDo findById(Integer userId);
    public List<UserDo> queryByList(UserDo userDo);
    public Integer addUser(UserDo userDo);
    public Integer modifyUser(UserDo userDo);
    public Integer delUser(UserDo userDo);
}
