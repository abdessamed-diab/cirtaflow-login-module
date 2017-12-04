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
@Table(name = "ACT_RU_TASK", catalog = "activiti_cirtaflow_test", schema = "")
@NamedQueries({
    @NamedQuery(name = "ActRuTask.findAll", query = "SELECT a FROM ActRuTask a")})
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
    @ManyToOne
    private ActRuExecution executionId;
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
    @ManyToOne
    private ActReProcdef procDefId;
    @JoinColumn(name = "PROC_INST_ID_", referencedColumnName = "ID_")
    @ManyToOne
    private ActRuExecution procInstId;
    @OneToMany(mappedBy = "taskId")
    private Collection<ActRuIdentitylink> actRuIdentitylinkCollection;

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

    public Collection<ActRuIdentitylink> getActRuIdentitylinkCollection() {
        return actRuIdentitylinkCollection;
    }

    public void setActRuIdentitylinkCollection(Collection<ActRuIdentitylink> actRuIdentitylinkCollection) {
        this.actRuIdentitylinkCollection = actRuIdentitylinkCollection;
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
