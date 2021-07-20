package com.workloadaccount.app.transfer;

import com.workloadaccount.app.entity.ProjectDO;
import com.workloadaccount.app.vo.ProjectVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author
 * @description
 * @see
 * @since
 */
@Mapper
public interface ProjectTransfer {
    ProjectTransfer INSTANCE = Mappers.getMapper(ProjectTransfer.class);

    ProjectVO mapToVO(ProjectDO projectDO);
}
