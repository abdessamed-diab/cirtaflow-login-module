/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_RU_TIMER_JOB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActRuTimerJob.findAll", query = "SELECT a FROM ActRuTimerJob a")
    , @NamedQuery(name = "ActRuTimerJob.findById", query = "SELECT a FROM ActRuTimerJob a WHERE a.id = :id")
    , @NamedQuery(name = "ActRuTimerJob.findByRev", query = "SELECT a FROM ActRuTimerJob a WHERE a.rev = :rev")
    , @NamedQuery(name = "ActRuTimerJob.findByType", query = "SELECT a FROM ActRuTimerJob a WHERE a.type = :type")
    , @NamedQuery(name = "ActRuTimerJob.findByLockExpTime", query = "SELECT a FROM ActRuTimerJob a WHERE a.lockExpTime = :lockExpTime")
    , @NamedQuery(name = "ActRuTimerJob.findByLockOwner", query = "SELECT a FROM ActRuTimerJob a WHERE a.lockOwner = :lockOwner")
    , @NamedQuery(name = "ActRuTimerJob.findByExclusive", query = "SELECT a FROM ActRuTimerJob a WHERE a.exclusive = :exclusive")
    , @NamedQuery(name = "ActRuTimerJob.findByRetries", query = "SELECT a FROM ActRuTimerJob a WHERE a.retries = :retries")
    , @NamedQuery(name = "ActRuTimerJob.findByExceptionMsg", query = "SELECT a FROM ActRuTimerJob a WHERE a.exceptionMsg = :exceptionMsg")
    , @NamedQuery(name = "ActRuTimerJob.findByDuedate", query = "SELECT a FROM ActRuTimerJob a WHERE a.duedate = :duedate")
    , @NamedQuery(name = "ActRuTimerJob.findByRepeat", query = "SELECT a FROM ActRuTimerJob a WHERE a.repeat = :repeat")
    , @NamedQuery(name = "ActRuTimerJob.findByHandlerType", query = "SELECT a FROM ActRuTimerJob a WHERE a.handlerType = :handlerType")
    , @NamedQuery(name = "ActRuTimerJob.findByHandlerCfg", query = "SELECT a FROM ActRuTimerJob a WHERE a.handlerCfg = :handlerCfg")
    , @NamedQuery(name = "ActRuTimerJob.findByTenantId", query = "SELECT a FROM ActRuTimerJob a WHERE a.tenantId = :tenantId")})
public class ActRuTimerJob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Basic(optional = false)
    @Column(name = "TYPE_", nullable = false, length = 255)
    private String type;
    @Column(name = "LOCK_EXP_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockExpTime;
    @Column(name = "LOCK_OWNER_", length = 255)
    private String lockOwner;
    @Column(name = "EXCLUSIVE_")
    private Boolean exclusive;
    @Column(name = "RETRIES_")
    private Integer retries;
    @Column(name = "EXCEPTION_MSG_", length = 4000)
    private String exceptionMsg;
    @Column(name = "DUEDATE_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    @Column(name = "REPEAT_", length = 255)
    private String repeat;
    @Column(name = "HANDLER_TYPE_", length = 255)
    private String handlerType;
    @Column(name = "HANDLER_CFG_", length = 4000)
    private String handlerCfg;
    @Column(name = "TENANT_ID_", length = 255)
    private String tenantId;
    @JoinColumn(name = "EXCEPTION_STACK_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActGeBytearray exceptionStackId;
    @JoinColumn(name = "EXECUTION_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution executionId;
    @JoinColumn(name = "PROCESS_INSTANCE_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution processInstanceId;
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActReProcdef procDefId;

    public ActRuTimerJob() {
    }

    public ActRuTimerJob(String id) {
        this.id = id;
    }

    public ActRuTimerJob(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLockExpTime() {
        return lockExpTime;
    }

    public void setLockExpTime(Date lockExpTime) {
        this.lockExpTime = lockExpTime;
    }

    public String getLockOwner() {
        return lockOwner;
    }

    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner;
    }

    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType;
    }

    public String getHandlerCfg() {
        return handlerCfg;
    }

    public void setHandlerCfg(String handlerCfg) {
        this.handlerCfg = handlerCfg;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public ActGeBytearray getExceptionStackId() {
        return exceptionStackId;
    }

    public void setExceptionStackId(ActGeBytearray exceptionStackId) {
        this.exceptionStackId = exceptionStackId;
    }

    public ActRuExecution getExecutionId() {
        return executionId;
    }

    public void setExecutionId(ActRuExecution executionId) {
        this.executionId = executionId;
    }

    public ActRuExecution getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(ActRuExecution processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public ActReProcdef getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(ActReProcdef procDefId) {
        this.procDefId = procDefId;
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
        if (!(object instanceof ActRuTimerJob)) {
            return false;
        }
        ActRuTimerJob other = (ActRuTimerJob) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActRuTimerJob[ id=" + id + " ]";
    }
    
}
