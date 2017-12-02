/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_RU_EXECUTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActRuExecution.findAll", query = "SELECT a FROM ActRuExecution a")
    , @NamedQuery(name = "ActRuExecution.findById", query = "SELECT a FROM ActRuExecution a WHERE a.id = :id")
    , @NamedQuery(name = "ActRuExecution.findByRev", query = "SELECT a FROM ActRuExecution a WHERE a.rev = :rev")
    , @NamedQuery(name = "ActRuExecution.findByBusinessKey", query = "SELECT a FROM ActRuExecution a WHERE a.businessKey = :businessKey")
    , @NamedQuery(name = "ActRuExecution.findByRootProcInstId", query = "SELECT a FROM ActRuExecution a WHERE a.rootProcInstId = :rootProcInstId")
    , @NamedQuery(name = "ActRuExecution.findByActId", query = "SELECT a FROM ActRuExecution a WHERE a.actId = :actId")
    , @NamedQuery(name = "ActRuExecution.findByIsActive", query = "SELECT a FROM ActRuExecution a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "ActRuExecution.findByIsConcurrent", query = "SELECT a FROM ActRuExecution a WHERE a.isConcurrent = :isConcurrent")
    , @NamedQuery(name = "ActRuExecution.findByIsScope", query = "SELECT a FROM ActRuExecution a WHERE a.isScope = :isScope")
    , @NamedQuery(name = "ActRuExecution.findByIsEventScope", query = "SELECT a FROM ActRuExecution a WHERE a.isEventScope = :isEventScope")
    , @NamedQuery(name = "ActRuExecution.findByIsMiRoot", query = "SELECT a FROM ActRuExecution a WHERE a.isMiRoot = :isMiRoot")
    , @NamedQuery(name = "ActRuExecution.findBySuspensionState", query = "SELECT a FROM ActRuExecution a WHERE a.suspensionState = :suspensionState")
    , @NamedQuery(name = "ActRuExecution.findByCachedEntState", query = "SELECT a FROM ActRuExecution a WHERE a.cachedEntState = :cachedEntState")
    , @NamedQuery(name = "ActRuExecution.findByTenantId", query = "SELECT a FROM ActRuExecution a WHERE a.tenantId = :tenantId")
    , @NamedQuery(name = "ActRuExecution.findByName", query = "SELECT a FROM ActRuExecution a WHERE a.name = :name")
    , @NamedQuery(name = "ActRuExecution.findByStartTime", query = "SELECT a FROM ActRuExecution a WHERE a.startTime = :startTime")
    , @NamedQuery(name = "ActRuExecution.findByStartUserId", query = "SELECT a FROM ActRuExecution a WHERE a.startUserId = :startUserId")
    , @NamedQuery(name = "ActRuExecution.findByLockTime", query = "SELECT a FROM ActRuExecution a WHERE a.lockTime = :lockTime")
    , @NamedQuery(name = "ActRuExecution.findByIsCountEnabled", query = "SELECT a FROM ActRuExecution a WHERE a.isCountEnabled = :isCountEnabled")
    , @NamedQuery(name = "ActRuExecution.findByEvtSubscrCount", query = "SELECT a FROM ActRuExecution a WHERE a.evtSubscrCount = :evtSubscrCount")
    , @NamedQuery(name = "ActRuExecution.findByTaskCount", query = "SELECT a FROM ActRuExecution a WHERE a.taskCount = :taskCount")
    , @NamedQuery(name = "ActRuExecution.findByJobCount", query = "SELECT a FROM ActRuExecution a WHERE a.jobCount = :jobCount")
    , @NamedQuery(name = "ActRuExecution.findByTimerJobCount", query = "SELECT a FROM ActRuExecution a WHERE a.timerJobCount = :timerJobCount")
    , @NamedQuery(name = "ActRuExecution.findBySuspJobCount", query = "SELECT a FROM ActRuExecution a WHERE a.suspJobCount = :suspJobCount")
    , @NamedQuery(name = "ActRuExecution.findByDeadletterJobCount", query = "SELECT a FROM ActRuExecution a WHERE a.deadletterJobCount = :deadletterJobCount")
    , @NamedQuery(name = "ActRuExecution.findByVarCount", query = "SELECT a FROM ActRuExecution a WHERE a.varCount = :varCount")
    , @NamedQuery(name = "ActRuExecution.findByIdLinkCount", query = "SELECT a FROM ActRuExecution a WHERE a.idLinkCount = :idLinkCount")})
public class ActRuExecution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Column(name = "BUSINESS_KEY_", length = 255)
    private String businessKey;
    @Column(name = "ROOT_PROC_INST_ID_", length = 64)
    private String rootProcInstId;
    @Column(name = "ACT_ID_", length = 255)
    private String actId;
    @Column(name = "IS_ACTIVE_")
    private Short isActive;
    @Column(name = "IS_CONCURRENT_")
    private Short isConcurrent;
    @Column(name = "IS_SCOPE_")
    private Short isScope;
    @Column(name = "IS_EVENT_SCOPE_")
    private Short isEventScope;
    @Column(name = "IS_MI_ROOT_")
    private Short isMiRoot;
    @Column(name = "SUSPENSION_STATE_")
    private Integer suspensionState;
    @Column(name = "CACHED_ENT_STATE_")
    private Integer cachedEntState;
    @Column(name = "TENANT_ID_", length = 255)
    private String tenantId;
    @Column(name = "NAME_", length = 255)
    private String name;
    @Column(name = "START_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "START_USER_ID_", length = 255)
    private String startUserId;
    @Column(name = "LOCK_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockTime;
    @Column(name = "IS_COUNT_ENABLED_")
    private Short isCountEnabled;
    @Column(name = "EVT_SUBSCR_COUNT_")
    private Integer evtSubscrCount;
    @Column(name = "TASK_COUNT_")
    private Integer taskCount;
    @Column(name = "JOB_COUNT_")
    private Integer jobCount;
    @Column(name = "TIMER_JOB_COUNT_")
    private Integer timerJobCount;
    @Column(name = "SUSP_JOB_COUNT_")
    private Integer suspJobCount;
    @Column(name = "DEADLETTER_JOB_COUNT_")
    private Integer deadletterJobCount;
    @Column(name = "VAR_COUNT_")
    private Integer varCount;
    @Column(name = "ID_LINK_COUNT_")
    private Integer idLinkCount;
    @OneToMany(mappedBy = "executionId", fetch = FetchType.LAZY)
    private List<ActRuEventSubscr> actRuEventSubscrList;
    @OneToMany(mappedBy = "executionId", fetch = FetchType.LAZY)
    private List<ActRuVariable> actRuVariableList;
    @OneToMany(mappedBy = "procInstId", fetch = FetchType.LAZY)
    private List<ActRuVariable> actRuVariableList1;
    @OneToMany(mappedBy = "executionId", fetch = FetchType.LAZY)
    private List<ActRuTask> actRuTaskList;
    @OneToMany(mappedBy = "procInstId", fetch = FetchType.LAZY)
    private List<ActRuTask> actRuTaskList1;
    @OneToMany(mappedBy = "executionId", fetch = FetchType.LAZY)
    private List<ActRuDeadletterJob> actRuDeadletterJobList;
    @OneToMany(mappedBy = "processInstanceId", fetch = FetchType.LAZY)
    private List<ActRuDeadletterJob> actRuDeadletterJobList1;
    @OneToMany(mappedBy = "executionId", fetch = FetchType.LAZY)
    private List<ActRuJob> actRuJobList;
    @OneToMany(mappedBy = "processInstanceId", fetch = FetchType.LAZY)
    private List<ActRuJob> actRuJobList1;
    @OneToMany(mappedBy = "executionId", fetch = FetchType.LAZY)
    private List<ActRuSuspendedJob> actRuSuspendedJobList;
    @OneToMany(mappedBy = "processInstanceId", fetch = FetchType.LAZY)
    private List<ActRuSuspendedJob> actRuSuspendedJobList1;
    @OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
    private List<ActRuExecution> actRuExecutionList;
    @JoinColumn(name = "PARENT_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution parentId;
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActReProcdef procDefId;
    @OneToMany(mappedBy = "procInstId", fetch = FetchType.LAZY)
    private List<ActRuExecution> actRuExecutionList1;
    @JoinColumn(name = "PROC_INST_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution procInstId;
    @OneToMany(mappedBy = "superExec", fetch = FetchType.LAZY)
    private List<ActRuExecution> actRuExecutionList2;
    @JoinColumn(name = "SUPER_EXEC_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution superExec;
    @OneToMany(mappedBy = "procInstId", fetch = FetchType.LAZY)
    private List<ActRuIdentitylink> actRuIdentitylinkList;
    @OneToMany(mappedBy = "executionId", fetch = FetchType.LAZY)
    private List<ActRuTimerJob> actRuTimerJobList;
    @OneToMany(mappedBy = "processInstanceId", fetch = FetchType.LAZY)
    private List<ActRuTimerJob> actRuTimerJobList1;

    public ActRuExecution() {
    }

    public ActRuExecution(String id) {
        this.id = id;
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

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getRootProcInstId() {
        return rootProcInstId;
    }

    public void setRootProcInstId(String rootProcInstId) {
        this.rootProcInstId = rootProcInstId;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public Short getIsConcurrent() {
        return isConcurrent;
    }

    public void setIsConcurrent(Short isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public Short getIsScope() {
        return isScope;
    }

    public void setIsScope(Short isScope) {
        this.isScope = isScope;
    }

    public Short getIsEventScope() {
        return isEventScope;
    }

    public void setIsEventScope(Short isEventScope) {
        this.isEventScope = isEventScope;
    }

    public Short getIsMiRoot() {
        return isMiRoot;
    }

    public void setIsMiRoot(Short isMiRoot) {
        this.isMiRoot = isMiRoot;
    }

    public Integer getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
    }

    public Integer getCachedEntState() {
        return cachedEntState;
    }

    public void setCachedEntState(Integer cachedEntState) {
        this.cachedEntState = cachedEntState;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public Short getIsCountEnabled() {
        return isCountEnabled;
    }

    public void setIsCountEnabled(Short isCountEnabled) {
        this.isCountEnabled = isCountEnabled;
    }

    public Integer getEvtSubscrCount() {
        return evtSubscrCount;
    }

    public void setEvtSubscrCount(Integer evtSubscrCount) {
        this.evtSubscrCount = evtSubscrCount;
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }

    public Integer getJobCount() {
        return jobCount;
    }

    public void setJobCount(Integer jobCount) {
        this.jobCount = jobCount;
    }

    public Integer getTimerJobCount() {
        return timerJobCount;
    }

    public void setTimerJobCount(Integer timerJobCount) {
        this.timerJobCount = timerJobCount;
    }

    public Integer getSuspJobCount() {
        return suspJobCount;
    }

    public void setSuspJobCount(Integer suspJobCount) {
        this.suspJobCount = suspJobCount;
    }

    public Integer getDeadletterJobCount() {
        return deadletterJobCount;
    }

    public void setDeadletterJobCount(Integer deadletterJobCount) {
        this.deadletterJobCount = deadletterJobCount;
    }

    public Integer getVarCount() {
        return varCount;
    }

    public void setVarCount(Integer varCount) {
        this.varCount = varCount;
    }

    public Integer getIdLinkCount() {
        return idLinkCount;
    }

    public void setIdLinkCount(Integer idLinkCount) {
        this.idLinkCount = idLinkCount;
    }

    @XmlTransient
    public List<ActRuEventSubscr> getActRuEventSubscrList() {
        return actRuEventSubscrList;
    }

    public void setActRuEventSubscrList(List<ActRuEventSubscr> actRuEventSubscrList) {
        this.actRuEventSubscrList = actRuEventSubscrList;
    }

    @XmlTransient
    public List<ActRuVariable> getActRuVariableList() {
        return actRuVariableList;
    }

    public void setActRuVariableList(List<ActRuVariable> actRuVariableList) {
        this.actRuVariableList = actRuVariableList;
    }

    @XmlTransient
    public List<ActRuVariable> getActRuVariableList1() {
        return actRuVariableList1;
    }

    public void setActRuVariableList1(List<ActRuVariable> actRuVariableList1) {
        this.actRuVariableList1 = actRuVariableList1;
    }

    @XmlTransient
    public List<ActRuTask> getActRuTaskList() {
        return actRuTaskList;
    }

    public void setActRuTaskList(List<ActRuTask> actRuTaskList) {
        this.actRuTaskList = actRuTaskList;
    }

    @XmlTransient
    public List<ActRuTask> getActRuTaskList1() {
        return actRuTaskList1;
    }

    public void setActRuTaskList1(List<ActRuTask> actRuTaskList1) {
        this.actRuTaskList1 = actRuTaskList1;
    }

    @XmlTransient
    public List<ActRuDeadletterJob> getActRuDeadletterJobList() {
        return actRuDeadletterJobList;
    }

    public void setActRuDeadletterJobList(List<ActRuDeadletterJob> actRuDeadletterJobList) {
        this.actRuDeadletterJobList = actRuDeadletterJobList;
    }

    @XmlTransient
    public List<ActRuDeadletterJob> getActRuDeadletterJobList1() {
        return actRuDeadletterJobList1;
    }

    public void setActRuDeadletterJobList1(List<ActRuDeadletterJob> actRuDeadletterJobList1) {
        this.actRuDeadletterJobList1 = actRuDeadletterJobList1;
    }

    @XmlTransient
    public List<ActRuJob> getActRuJobList() {
        return actRuJobList;
    }

    public void setActRuJobList(List<ActRuJob> actRuJobList) {
        this.actRuJobList = actRuJobList;
    }

    @XmlTransient
    public List<ActRuJob> getActRuJobList1() {
        return actRuJobList1;
    }

    public void setActRuJobList1(List<ActRuJob> actRuJobList1) {
        this.actRuJobList1 = actRuJobList1;
    }

    @XmlTransient
    public List<ActRuSuspendedJob> getActRuSuspendedJobList() {
        return actRuSuspendedJobList;
    }

    public void setActRuSuspendedJobList(List<ActRuSuspendedJob> actRuSuspendedJobList) {
        this.actRuSuspendedJobList = actRuSuspendedJobList;
    }

    @XmlTransient
    public List<ActRuSuspendedJob> getActRuSuspendedJobList1() {
        return actRuSuspendedJobList1;
    }

    public void setActRuSuspendedJobList1(List<ActRuSuspendedJob> actRuSuspendedJobList1) {
        this.actRuSuspendedJobList1 = actRuSuspendedJobList1;
    }

    @XmlTransient
    public List<ActRuExecution> getActRuExecutionList() {
        return actRuExecutionList;
    }

    public void setActRuExecutionList(List<ActRuExecution> actRuExecutionList) {
        this.actRuExecutionList = actRuExecutionList;
    }

    public ActRuExecution getParentId() {
        return parentId;
    }

    public void setParentId(ActRuExecution parentId) {
        this.parentId = parentId;
    }

    public ActReProcdef getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(ActReProcdef procDefId) {
        this.procDefId = procDefId;
    }

    @XmlTransient
    public List<ActRuExecution> getActRuExecutionList1() {
        return actRuExecutionList1;
    }

    public void setActRuExecutionList1(List<ActRuExecution> actRuExecutionList1) {
        this.actRuExecutionList1 = actRuExecutionList1;
    }

    public ActRuExecution getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(ActRuExecution procInstId) {
        this.procInstId = procInstId;
    }

    @XmlTransient
    public List<ActRuExecution> getActRuExecutionList2() {
        return actRuExecutionList2;
    }

    public void setActRuExecutionList2(List<ActRuExecution> actRuExecutionList2) {
        this.actRuExecutionList2 = actRuExecutionList2;
    }

    public ActRuExecution getSuperExec() {
        return superExec;
    }

    public void setSuperExec(ActRuExecution superExec) {
        this.superExec = superExec;
    }

    @XmlTransient
    public List<ActRuIdentitylink> getActRuIdentitylinkList() {
        return actRuIdentitylinkList;
    }

    public void setActRuIdentitylinkList(List<ActRuIdentitylink> actRuIdentitylinkList) {
        this.actRuIdentitylinkList = actRuIdentitylinkList;
    }

    @XmlTransient
    public List<ActRuTimerJob> getActRuTimerJobList() {
        return actRuTimerJobList;
    }

    public void setActRuTimerJobList(List<ActRuTimerJob> actRuTimerJobList) {
        this.actRuTimerJobList = actRuTimerJobList;
    }

    @XmlTransient
    public List<ActRuTimerJob> getActRuTimerJobList1() {
        return actRuTimerJobList1;
    }

    public void setActRuTimerJobList1(List<ActRuTimerJob> actRuTimerJobList1) {
        this.actRuTimerJobList1 = actRuTimerJobList1;
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
        if (!(object instanceof ActRuExecution)) {
            return false;
        }
        ActRuExecution other = (ActRuExecution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActRuExecution[ id=" + id + " ]";
    }
    
}
