package ink.usr.common.model.mysql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysApprovalFlowModel implements Serializable {
    // 审批流程id
    private Long flowId;
    // 审批请求id
    private Long approvalId;
    // 审批人id
    private Long approverId;
    // 审批环节序号
    private Long stage;
    // 当前环节的审批状态
    private String status;
    // 创建时间
    private String createdAt;
    // 更新时间
    private String updatedAt;
    
}
