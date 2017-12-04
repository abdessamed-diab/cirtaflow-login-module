/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_HI_PROCINST", catalog = "activiti_cirtaflow_test", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PROC_INST_ID_"})})
@NamedQueries({
    @NamedQuery(name = "ActHiProcinst.findAll", query = "SELECT a FROM ActHiProcinst a")})
public class ActHiProcinst implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Basic(optional = false)
    @Column(name = "PROC_INST_ID_", nullable = false, length = 64)
    private String procInstId;
    @Column(name = "BUSINESS_KEY_", length = 255)
    private String businessKey;
    @Basic(optional = false)
    @Column(name = "PROC_DEF_ID_", nullable = false, length = 64)
    private String procDefId;
    @Basic(optional = false)
    @Column(name = "START_TIME_", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "DURATION_")
    private BigInteger duration;
    @Column(name = "START_USER_ID_", length = 255)
    private String startUserId;
    @Column(name = "START_ACT_ID_", length = 255)
    private String startActId;
    @Column(name = "END_ACT_ID_", length = 255)
    private String endActId;
    @Column(name = "SUPER_PROCESS_INSTANCE_ID_", length = 64)
    private String superProcessInstanceId;
    @Column(name = "DELETE_REASON_", length = 4000)
    private String deleteReason;
    @Column(name = "TENANT_ID_", length = 255)
    private String tenantId;
    @Column(name = "NAME_", length = 255)
    private String name;

    public ActHiProcinst() {
    }

    public ActHiProcinst(String id) {
        this.id = id;
    }

    public ActHiProcinst(String id, String procInstId, String procDefId, Date startTime) {
        this.id = id;
        this.procInstId = procInstId;
        this.procDefId = procDefId;
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
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

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public String getStartActId() {
        return startActId;
    }

    public void setStartActId(String startActId) {
        this.startActId = startActId;
    }

    public String getEndActId() {
        return endActId;
    }

    public void setEndActId(String endActId) {
        this.endActId = endActId;
    }

    public String getSuperProcessInstanceId() {
        return superProcessInstanceId;
    }

    public void setSuperProcessInstanceId(String superProcessInstanceId) {
        this.superProcessInstanceId = superProcessInstanceId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof ActHiProcinst)) {
            return false;
        }
        ActHiProcinst other = (ActHiProcinst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActHiProcinst[ id=" + id + " ]";
    }
    
}
