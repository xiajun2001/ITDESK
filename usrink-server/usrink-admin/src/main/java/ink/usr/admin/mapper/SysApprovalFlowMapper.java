package ink.usr.admin.mapper;

import ink.usr.common.model.mysql.SysApprovalFlowModel;
import ink.usr.common.model.mysql.SysApprovalRequestModel;
import ink.usr.common.model.mysql.SysApprovalTokenModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysApprovalFlowMapper {

    @Select("select * from sys_approval_flow where approverId = #{approverId}")
    List<SysApprovalFlowModel> getApprovalFlowListByApproverId(Long approverId);

    String getApproversByAprroval1Id(Long aprrovalId);

    String getApproversByAprroval2Id(Long aprrovalId);

    String getUserNameByAprrovalId(Long aprrovalId);
    
    /**
     * 根据flowId获取审批流信息
     */
    @Select("select * from sys_approval_flow where flowId = #{flowId}")
    SysApprovalFlowModel getApprovalFlowById(Long flowId);
    
    /**
     * 获取审批token
     */
    @Select("select * from sys_approval_token where flowId = #{flowId} and token = #{token}")
    SysApprovalTokenModel getApprovalToken(@Param("flowId") Long flowId, @Param("token") String token);
    
    /**
     * 更新审批状态
     */
    @Update("update sys_approval_request set status = #{status}, approvedAt = #{approvedAt}, " +
            "updatedAt = #{updatedAt}, comment = #{comment} where approvalId = #{approvalId}")
    int updateApprovalStatus(SysApprovalRequestModel requestModel);
    
    /**
     * 更新审批流状态
     */
    @Update("update sys_approval_flow set status = #{status}, updatedAt = #{updatedAt} where flowId = #{flowId}")
    int updateApprovalFlow(SysApprovalFlowModel flowModel);
}
