package ink.usr.admin.service.Impl;

import ink.usr.admin.dao.VO.SysApproversVO;
import ink.usr.admin.mapper.SysApplyMapper;
import ink.usr.admin.mapper.SysApprovalFlowMapper;
import ink.usr.admin.service.SysApplyService;
import ink.usr.admin.service.SysApprovalFlowService;
import ink.usr.common.model.mysql.SysApprovalFlowModel;
import ink.usr.common.model.mysql.SysApprovalRequestModel;
import ink.usr.common.model.mysql.SysApprovalTokenModel;
import ink.usr.framework.shiro.domain.ShiroUserInfo;
import ink.usr.framework.shiro.utils.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class SysApprovalFlowServiceImpl implements SysApprovalFlowService {

    @Autowired
    private SysApprovalFlowMapper sysApprovalFlowMapper;

    @Override
    public List<SysApprovalFlowModel> getApprovalFlowListByApproverId(Long approverId) {
        List<SysApprovalFlowModel> FlowList = sysApprovalFlowMapper.getApprovalFlowListByApproverId(approverId);
        return FlowList;
    }

    @Override
    public SysApproversVO getApproversByAprrovalId(Long aprrovalId) {
        String approver1 = sysApprovalFlowMapper.getApproversByAprroval1Id(aprrovalId);
        String approver2 = sysApprovalFlowMapper.getApproversByAprroval2Id(aprrovalId);
        String username = sysApprovalFlowMapper.getUserNameByAprrovalId(aprrovalId);
        SysApproversVO sysApproversVO = new SysApproversVO();
        sysApproversVO.setApprover1(approver1);
        sysApproversVO.setApprover2(approver2);
        sysApproversVO.setUsername(username);
        return sysApproversVO;
    }
}
