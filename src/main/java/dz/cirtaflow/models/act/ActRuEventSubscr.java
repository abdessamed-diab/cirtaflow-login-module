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
@Table(name = "ACT_RU_EVENT_SUBSCR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActRuEventSubscr.findAll", query = "SELECT a FROM ActRuEventSubscr a")
    , @NamedQuery(name = "ActRuEventSubscr.findById", query = "SELECT a FROM ActRuEventSubscr a WHERE a.id = :id")
    , @NamedQuery(name = "ActRuEventSubscr.findByRev", query = "SELECT a FROM ActRuEventSubscr a WHERE a.rev = :rev")
    , @NamedQuery(name = "ActRuEventSubscr.findByEventType", query = "SELECT a FROM ActRuEventSubscr a WHERE a.eventType = :eventType")
    , @NamedQuery(name = "ActRuEventSubscr.findByEventName", query = "SELECT a FROM ActRuEventSubscr a WHERE a.eventName = :eventName")
    , @NamedQuery(name = "ActRuEventSubscr.findByProcInstId", query = "SELECT a FROM ActRuEventSubscr a WHERE a.procInstId = :procInstId")
    , @NamedQuery(name = "ActRuEventSubscr.findByActivityId", query = "SELECT a FROM ActRuEventSubscr a WHERE a.activityId = :activityId")
    , @NamedQuery(name = "ActRuEventSubscr.findByConfiguration", query = "SELECT a FROM ActRuEventSubscr a WHERE a.configuration = :configuration")
    , @NamedQuery(name = "ActRuEventSubscr.findByCreated", query = "SELECT a FROM ActRuEventSubscr a WHERE a.created = :created")
    , @NamedQuery(name = "ActRuEventSubscr.findByProcDefId", query = "SELECT a FROM ActRuEventSubscr a WHERE a.procDefId = :procDefId")
    , @NamedQuery(name = "ActRuEventSubscr.findByTenantId", query = "SELECT a FROM ActRuEventSubscr a WHERE a.tenantId = :tenantId")})
public class ActRuEventSubscr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Basic(optional = false)
    @Column(name = "EVENT_TYPE_", nullable = false, length = 255)
    private String eventType;
    @Column(name = "EVENT_NAME_", length = 255)
    private String eventName;
    @Column(name = "PROC_INST_ID_", length = 64)
    private String procInstId;
    @Column(name = "ACTIVITY_ID_", length = 64)
    private String activityId;
    @Column(name = "CONFIGURATION_", length = 255)
    private String configuration;
    @Basic(optional = false)
    @Column(name = "CREATED_", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "PROC_DEF_ID_", length = 64)
    private String procDefId;
    @Column(name = "TENANT_ID_", length = 255)
    private String tenantId;
    @JoinColumn(name = "EXECUTION_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution executionId;

    public ActRuEventSubscr() {
    }

    public ActRuEventSubscr(String id) {
        this.id = id;
    }

    public ActRuEventSubscr(String id, String eventType, Date created) {
        this.id = id;
        this.eventType = eventType;
        this.created = created;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public ActRuExecution getExecutionId() {
        return executionId;
    }

    public void setExecutionId(ActRuExecution executionId) {
        this.executionId = executionId;
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
        if (!(object instanceof ActRuEventSubscr)) {
            return false;
        }
        ActRuEventSubscr other = (ActRuEventSubscr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActRuEventSubscr[ id=" + id + " ]";
    }
    
}
