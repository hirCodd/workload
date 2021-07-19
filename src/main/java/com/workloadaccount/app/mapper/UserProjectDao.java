package com.workloadaccount.app.mapper;

import com.workloadaccount.app.entity.UserProjectDO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Mapper
public interface UserProjectDao {
    /**
     *
     * @param id 项目id
     * @return
     */
    List<UserProjectDO> findUserProjectById(Integer id);

    /**
     * 通过id查询用户项目
     * @param id
     * @return
     */
    List<UserProjectDO> findUserProjectByUserId(Integer id);

    /**
     * 更新项目总的工作时间
     * @param projectId
     * @param userId
     */
    void updateWorkloadTime(Integer projectId, Integer userId, Long workTime);
}
