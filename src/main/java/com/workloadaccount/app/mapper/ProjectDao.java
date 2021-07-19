package com.workloadaccount.app.mapper;

import com.workloadaccount.app.entity.ProjectDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Mapper
public interface ProjectDao {

    /**
     * 查询所有项目
     * @return
     */
    List<ProjectDO> listProjects();

    /**
     * 根据id查询项目信息
     * @param id
     * @return
     */
    ProjectDO findProjectById(Integer id);

    /**
     * 根据项目id以及项目状态查询项目
     * @param id id
     * @param projectStatus 项目状态
     * @return
     */
    ProjectDO findProjectByStatusAndId(Integer id, Integer projectStatus);
}
