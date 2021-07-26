package com.workloadaccount.app.mapper;

import com.workloadaccount.app.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Mapper
public interface UserDao {
    /**
     * 查询所有用户
     * @return 所用户
     */
    List<UserDO> listUsers();

    /**
     * 通过id查询用户名
     * @param id id
     * @return
     */
    UserDO findUserById(String id);
}
