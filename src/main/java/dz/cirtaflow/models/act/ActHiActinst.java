/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_HI_ACTINST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActHiActinst.findAll", query = "SELECT a FROM ActHiActinst a")
    , @NamedQuery(name = "ActHiActinst.findById", query = "SELECT a FROM ActHiActinst a WHERE a.id = :id")
    , @NamedQuery(name = "ActHiActinst.findByProcDefId", query = "SELECT a FROM ActHiActinst a WHERE a.procDefId = :procDefId")
    , @NamedQuery(name = "ActHiActinst.findByProcInstId", query = "SELECT a FROM ActHiActinst a WHERE a.procInstId = :procInstId")
    , @NamedQuery(name = "ActHiActinst.findByExecutionId", query = "SELECT a FROM ActHiActinst a WHERE a.executionId = :executionId")
    , @NamedQuery(name = "ActHiActinst.findByActId", query = "SELECT a FROM ActHiActinst a WHERE a.actId = :actId")
    , @NamedQuery(name = "ActHiActinst.findByTaskId", query = "SELECT a FROM ActHiActinst a WHERE a.taskId = :taskId")
    , @NamedQuery(name = "ActHiActinst.findByCallProcInstId", query = "SELECT a FROM ActHiActinst a WHERE a.callProcInstId = :callProcInstId")
    , @NamedQuery(name = "ActHiActinst.findByActName", query = "SELECT a FROM ActHiActinst a WHERE a.actName = :actName")
    , @NamedQuery(name = "ActHiActinst.findByActType", query = "SELECT a FROM ActHiActinst a WHERE a.actType = :actType")
    , @NamedQuery(name = "ActHiActinst.findByAssignee", query = "SELECT a FROM ActHiActinst a WHERE a.assignee = :assignee")
    , @NamedQuery(name = "ActHiActinst.findByStartTime", query = "SELECT a FROM ActHiActinst a WHERE a.startTime = :startTime")
    , @NamedQuery(name = "ActHiActinst.findByEndTime", query = "SELECT a FROM ActHiActinst a WHERE a.endTime = :endTime")
    , @NamedQuery(name = "ActHiActinst.findByDuration", query = "SELECT a FROM ActHiActinst a WHERE a.duration = :duration")
    , @NamedQuery(name = "ActHiActinst.findByDeleteReason", query = "SELECT a FROM ActHiActinst a WHERE a.deleteReason = :deleteReason")
    , @NamedQuery(name = "ActHiActinst.findByTenantId", query = "SELECT a FROM ActHiActinst a WHERE a.tenantId = :tenantId")})
public class ActHiActinst implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Basic(optional = false)
    @Column(name = "PROC_DEF_ID_", nullable = false, length = 64)
    private String procDefId;
    @Basic(optional = false)
    @Column(name = "PROC_INST_ID_", nullable = false, length = 64)
    private String procInstId;
    @Basic(optional = false)
    @Column(name = "EXECUTION_ID_", nullable = false, length = 64)
    private String executionId;
    @Basic(optional = false)
    @Column(name = "ACT_ID_", nullable = false, length = 255)
    private String actId;
    @Column(name = "TASK_ID_", length = 64)
    private String taskId;
    @Column(name = "CALL_PROC_INST_ID_", length = 64)
    private String callProcInstId;
    @Column(name = "ACT_NAME_", length = 255)
    private String actName;
    @Basic(optional = false)
    @Column(name = "ACT_TYPE_", nullable = false, length = 255)
    private String actType;
    @Column(name = "ASSIGNEE_", length = 255)
    private String assignee;
    @Basic(optional = false)
    @Column(name = "START_TIME_", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "DURATION_")
    private BigInteger duration;
    @Column(name = "DELETE_REASON_", length = 4000)
    private String deleteReason;
    @Column(name = "TENANT_ID_", length = 255)
    private String tenantId;

    public ActHiActinst() {
    }

    public ActHiActinst(String id) {
        this.id = id;
    }

    public ActHiActinst(String id, String procDefId, String procInstId, String executionId, String actId, String actType, Date startTime) {
        this.id = id;
        this.procDefId = procDefId;
        this.procInstId = procInstId;
        this.executionId = executionId;
        this.actId = actId;
        this.actType = actType;
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCallProcInstId() {
        return callProcInstId;
    }

    public void setCallProcInstId(String callProcInstId) {
        this.callProcInstId = callProcInstId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActHiActinst)) {
            return false;
        }
        ActHiActinst other = (ActHiActinst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActHiActinst[ id=" + id + " ]";
    }
    
}
