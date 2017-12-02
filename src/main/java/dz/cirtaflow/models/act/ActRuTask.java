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
@Table(name = "ACT_RU_TASK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActRuTask.findAll", query = "SELECT a FROM ActRuTask a")
    , @NamedQuery(name = "ActRuTask.findById", query = "SELECT a FROM ActRuTask a WHERE a.id = :id")
    , @NamedQuery(name = "ActRuTask.findByRev", query = "SELECT a FROM ActRuTask a WHERE a.rev = :rev")
    , @NamedQuery(name = "ActRuTask.findByName", query = "SELECT a FROM ActRuTask a WHERE a.name = :name")
    , @NamedQuery(name = "ActRuTask.findByParentTaskId", query = "SELECT a FROM ActRuTask a WHERE a.parentTaskId = :parentTaskId")
    , @NamedQuery(name = "ActRuTask.findByDescription", query = "SELECT a FROM ActRuTask a WHERE a.description = :description")
    , @NamedQuery(name = "ActRuTask.findByTaskDefKey", query = "SELECT a FROM ActRuTask a WHERE a.taskDefKey = :taskDefKey")
    , @NamedQuery(name = "ActRuTask.findByOwner", query = "SELECT a FROM ActRuTask a WHERE a.owner = :owner")
    , @NamedQuery(name = "ActRuTask.findByAssignee", query = "SELECT a FROM ActRuTask a WHERE a.assignee = :assignee")
    , @NamedQuery(name = "ActRuTask.findByDelegation", query = "SELECT a FROM ActRuTask a WHERE a.delegation = :delegation")
    , @NamedQuery(name = "ActRuTask.findByPriority", query = "SELECT a FROM ActRuTask a WHERE a.priority = :priority")
    , @NamedQuery(name = "ActRuTask.findByCreateTime", query = "SELECT a FROM ActRuTask a WHERE a.createTime = :createTime")
    , @NamedQuery(name = "ActRuTask.findByDueDate", query = "SELECT a FROM ActRuTask a WHERE a.dueDate = :dueDate")
    , @NamedQuery(name = "ActRuTask.findByCategory", query = "SELECT a FROM ActRuTask a WHERE a.category = :category")
    , @NamedQuery(name = "ActRuTask.findBySuspensionState", query = "SELECT a FROM ActRuTask a WHERE a.suspensionState = :suspensionState")
    , @NamedQuery(name = "ActRuTask.findByTenantId", query = "SELECT a FROM ActRuTask a WHERE a.tenantId = :tenantId")
    , @NamedQuery(name = "ActRuTask.findByFormKey", query = "SELECT a FROM ActRuTask a WHERE a.formKey = :formKey")
    , @NamedQuery(name = "ActRuTask.findByClaimTime", query = "SELECT a FROM ActRuTask a WHERE a.claimTime = :claimTime")})
public class ActRuTask implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Column(name = "NAME_", length = 255)
    private String name;
    @Column(name = "PARENT_TASK_ID_", length = 64)
    private String parentTaskId;
    @Column(name = "DESCRIPTION_", length = 4000)
    private String description;
    @Column(name = "TASK_DEF_KEY_", length = 255)
    private String taskDefKey;
    @Column(name = "OWNER_", length = 255)
    private String owner;
    @Column(name = "ASSIGNEE_", length = 255)
    private String assignee;
    @Column(name = "DELEGATION_", length = 64)
    private String delegation;
    @Column(name = "PRIORITY_")
    private Integer priority;
    @Column(name = "CREATE_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "DUE_DATE_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "CATEGORY_", length = 255)
    private String category;
    @Column(name = "SUSPENSION_STATE_")
    private Integer suspensionState;
    @Column(name = "TENANT_ID_", length = 255)
    private String tenantId;
    @Column(name = "FORM_KEY_", length = 255)
    private String formKey;
    @Column(name = "CLAIM_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date claimTime;
    @JoinColumn(name = "EXECUTION_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution executionId;
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActReProcdef procDefId;
    @JoinColumn(name = "PROC_INST_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution procInstId;
    @OneToMany(mappedBy = "taskId", fetch = FetchType.LAZY)
    private List<ActRuIdentitylink> actRuIdentitylinkList;

    public ActRuTask() {
    }

    public ActRuTask(String id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskDefKey() {
        return taskDefKey;
    }

    public void setTaskDefKey(String taskDefKey) {
        this.taskDefKey = taskDefKey;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    public ActRuExecution getExecutionId() {
        return executionId;
    }

    public void setExecutionId(ActRuExecution executionId) {
        this.executionId = executionId;
    }

    public ActReProcdef getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(ActReProcdef procDefId) {
        this.procDefId = procDefId;
    }

    public ActRuExecution getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(ActRuExecution procInstId) {
        this.procInstId = procInstId;
    }

    @XmlTransient
    public List<ActRuIdentitylink> getActRuIdentitylinkList() {
        return actRuIdentitylinkList;
    }

    public void setActRuIdentitylinkList(List<ActRuIdentitylink> actRuIdentitylinkList) {
        this.actRuIdentitylinkList = actRuIdentitylinkList;
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
        if (!(object instanceof ActRuTask)) {
            return false;
        }
        ActRuTask other = (ActRuTask) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActRuTask[ id=" + id + " ]";
    }
    
}
