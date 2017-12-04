/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_RU_EXECUTION", catalog = "activiti_cirtaflow_test", schema = "")
@NamedQueries({
    @NamedQuery(name = "ActRuExecution.findAll", query = "SELECT a FROM ActRuExecution a")})
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
    @OneToMany(mappedBy = "executionId")
    private Collection<ActRuEventSubscr> actRuEventSubscrCollection;
    @OneToMany(mappedBy = "executionId")
    private Collection<ActRuVariable> actRuVariableCollection;
    @OneToMany(mappedBy = "procInstId")
    private Collection<ActRuVariable> actRuVariableCollection1;
    @OneToMany(mappedBy = "executionId")
    private Collection<ActRuTask> actRuTaskCollection;
    @OneToMany(mappedBy = "procInstId")
    private Collection<ActRuTask> actRuTaskCollection1;
    @OneToMany(mappedBy = "executionId")
    private Collection<ActRuDeadletterJob> actRuDeadletterJobCollection;
    @OneToMany(mappedBy = "processInstanceId")
    private Collection<ActRuDeadletterJob> actRuDeadletterJobCollection1;
    @OneToMany(mappedBy = "executionId")
    private Collection<ActRuJob> actRuJobCollection;
    @OneToMany(mappedBy = "processInstanceId")
    private Collection<ActRuJob> actRuJobCollection1;
    @OneToMany(mappedBy = "executionId")
    private Collection<ActRuSuspendedJob> actRuSuspendedJobCollection;
    @OneToMany(mappedBy = "processInstanceId")
    private Collection<ActRuSuspendedJob> actRuSuspendedJobCollection1;
    @OneToMany(mappedBy = "parentId")
    private Collection<ActRuExecution> actRuExecutionCollection;
    @JoinColumn(name = "PARENT_ID_", referencedColumnName = "ID_")
    @ManyToOne
    private ActRuExecution parentId;
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
    @ManyToOne
    private ActReProcdef procDefId;
    @OneToMany(mappedBy = "procInstId")
    private Collection<ActRuExecution> actRuExecutionCollection1;
    @JoinColumn(name = "PROC_INST_ID_", referencedColumnName = "ID_")
    @ManyToOne
    private ActRuExecution procInstId;
    @OneToMany(mappedBy = "superExec")
    private Collection<ActRuExecution> actRuExecutionCollection2;
    @JoinColumn(name = "SUPER_EXEC_", referencedColumnName = "ID_")
    @ManyToOne
    private ActRuExecution superExec;
    @OneToMany(mappedBy = "procInstId")
    private Collection<ActRuIdentitylink> actRuIdentitylinkCollection;
    @OneToMany(mappedBy = "executionId")
    private Collection<ActRuTimerJob> actRuTimerJobCollection;
    @OneToMany(mappedBy = "processInstanceId")
    private Collection<ActRuTimerJob> actRuTimerJobCollection1;

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

    public Collection<ActRuEventSubscr> getActRuEventSubscrCollection() {
        return actRuEventSubscrCollection;
    }

    public void setActRuEventSubscrCollection(Collection<ActRuEventSubscr> actRuEventSubscrCollection) {
        this.actRuEventSubscrCollection = actRuEventSubscrCollection;
    }

    public Collection<ActRuVariable> getActRuVariableCollection() {
        return actRuVariableCollection;
    }

    public void setActRuVariableCollection(Collection<ActRuVariable> actRuVariableCollection) {
        this.actRuVariableCollection = actRuVariableCollection;
    }

    public Collection<ActRuVariable> getActRuVariableCollection1() {
        return actRuVariableCollection1;
    }

    public void setActRuVariableCollection1(Collection<ActRuVariable> actRuVariableCollection1) {
        this.actRuVariableCollection1 = actRuVariableCollection1;
    }

    public Collection<ActRuTask> getActRuTaskCollection() {
        return actRuTaskCollection;
    }

    public void setActRuTaskCollection(Collection<ActRuTask> actRuTaskCollection) {
        this.actRuTaskCollection = actRuTaskCollection;
    }

    public Collection<ActRuTask> getActRuTaskCollection1() {
        return actRuTaskCollection1;
    }

    public void setActRuTaskCollection1(Collection<ActRuTask> actRuTaskCollection1) {
        this.actRuTaskCollection1 = actRuTaskCollection1;
    }

    public Collection<ActRuDeadletterJob> getActRuDeadletterJobCollection() {
        return actRuDeadletterJobCollection;
    }

    public void setActRuDeadletterJobCollection(Collection<ActRuDeadletterJob> actRuDeadletterJobCollection) {
        this.actRuDeadletterJobCollection = actRuDeadletterJobCollection;
    }

    public Collection<ActRuDeadletterJob> getActRuDeadletterJobCollection1() {
        return actRuDeadletterJobCollection1;
    }

    public void setActRuDeadletterJobCollection1(Collection<ActRuDeadletterJob> actRuDeadletterJobCollection1) {
        this.actRuDeadletterJobCollection1 = actRuDeadletterJobCollection1;
    }

    public Collection<ActRuJob> getActRuJobCollection() {
        return actRuJobCollection;
    }

    public void setActRuJobCollection(Collection<ActRuJob> actRuJobCollection) {
        this.actRuJobCollection = actRuJobCollection;
    }

    public Collection<ActRuJob> getActRuJobCollection1() {
        return actRuJobCollection1;
    }

    public void setActRuJobCollection1(Collection<ActRuJob> actRuJobCollection1) {
        this.actRuJobCollection1 = actRuJobCollection1;
    }

    public Collection<ActRuSuspendedJob> getActRuSuspendedJobCollection() {
        return actRuSuspendedJobCollection;
    }

    public void setActRuSuspendedJobCollection(Collection<ActRuSuspendedJob> actRuSuspendedJobCollection) {
        this.actRuSuspendedJobCollection = actRuSuspendedJobCollection;
    }

    public Collection<ActRuSuspendedJob> getActRuSuspendedJobCollection1() {
        return actRuSuspendedJobCollection1;
    }

    public void setActRuSuspendedJobCollection1(Collection<ActRuSuspendedJob> actRuSuspendedJobCollection1) {
        this.actRuSuspendedJobCollection1 = actRuSuspendedJobCollection1;
    }

    public Collection<ActRuExecution> getActRuExecutionCollection() {
        return actRuExecutionCollection;
    }

    public void setActRuExecutionCollection(Collection<ActRuExecution> actRuExecutionCollection) {
        this.actRuExecutionCollection = actRuExecutionCollection;
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

    public Collection<ActRuExecution> getActRuExecutionCollection1() {
        return actRuExecutionCollection1;
    }

    public void setActRuExecutionCollection1(Collection<ActRuExecution> actRuExecutionCollection1) {
        this.actRuExecutionCollection1 = actRuExecutionCollection1;
    }

    public ActRuExecution getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(ActRuExecution procInstId) {
        this.procInstId = procInstId;
    }

    public Collection<ActRuExecution> getActRuExecutionCollection2() {
        return actRuExecutionCollection2;
    }

    public void setActRuExecutionCollection2(Collection<ActRuExecution> actRuExecutionCollection2) {
        this.actRuExecutionCollection2 = actRuExecutionCollection2;
    }

    public ActRuExecution getSuperExec() {
        return superExec;
    }

    public void setSuperExec(ActRuExecution superExec) {
        this.superExec = superExec;
    }

    public Collection<ActRuIdentitylink> getActRuIdentitylinkCollection() {
        return actRuIdentitylinkCollection;
    }

    public void setActRuIdentitylinkCollection(Collection<ActRuIdentitylink> actRuIdentitylinkCollection) {
        this.actRuIdentitylinkCollection = actRuIdentitylinkCollection;
    }

    public Collection<ActRuTimerJob> getActRuTimerJobCollection() {
        return actRuTimerJobCollection;
    }

    public void setActRuTimerJobCollection(Collection<ActRuTimerJob> actRuTimerJobCollection) {
        this.actRuTimerJobCollection = actRuTimerJobCollection;
    }

    public Collection<ActRuTimerJob> getActRuTimerJobCollection1() {
        return actRuTimerJobCollection1;
    }

    public void setActRuTimerJobCollection1(Collection<ActRuTimerJob> actRuTimerJobCollection1) {
        this.actRuTimerJobCollection1 = actRuTimerJobCollection1;
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
