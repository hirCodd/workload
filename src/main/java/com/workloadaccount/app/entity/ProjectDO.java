package com.workloadaccount.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.Optional;


/**
 *
 * @description
 * @see
 * @since 1.0.0
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProjectDO extends BaseDO {
    private static final long serialVersionUID = 4996123075610886338L;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 项目主管
     */
    private String projectMajor;

    /**
     * 项目创建者
     */
    private String projectCreator;

    /**
     * 项目经理
     */
    private String projectManager;

    /**
     * 项目团队成员
     */
    private String group;

    /**
     * 项目状态
     */
    private Integer projectStatus;

    /**
     * 开始时间
     */
    private Timestamp startDatetime;

    /**
     * 项目结束时间
     */
    private Timestamp endDatetime;

//    public static ProjectDO createAdminProjectEntity(final AdminProjectDTO adminProjectDTO){
//        return Optional.ofNullable(adminProjectDTO).map(item -> {
//            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//            ProjectDO projectDO = ProjectDO.builder()
//                    .name(item.getName())
//                    .description(item.getDescription())
//                    .group(item.getGroup())
//                    .projectMajor(item.getProjectMajor())
//                    .projectCreator(item.getProjectCreator())
//                    .projectManager(item.getProjectManager())
//                    .startDatetime(item.getStartDatetime())
//                    .endDatetime(item.getEndDatetime())
//                    .createTime(currentTime)
//                    .updateTime(currentTime)
//                    .build();
//            switch (item.getProjectStatus()) {
//                case UNCOMPLETED:
//                    projectDO.setProjectStatus(ProjectStatus.UNCOMPLETED.getId());
//                    break;
//                case PROCESSING:
//                    projectDO.setProjectStatus(ProjectStatus.PROCESSING.getId());
//                case COMPLETED:
//                    projectDO.setProjectStatus(ProjectStatus.COMPLETED.getId());
//                case DELAY:
//                    projectDO.setProjectStatus(ProjectStatus.DELAY.getId());
//            }
//            return projectDO;
//        }).orElse(null);
//    }

}
