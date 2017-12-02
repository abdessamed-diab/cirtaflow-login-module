/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_RU_IDENTITYLINK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActRuIdentitylink.findAll", query = "SELECT a FROM ActRuIdentitylink a")
    , @NamedQuery(name = "ActRuIdentitylink.findById", query = "SELECT a FROM ActRuIdentitylink a WHERE a.id = :id")
    , @NamedQuery(name = "ActRuIdentitylink.findByRev", query = "SELECT a FROM ActRuIdentitylink a WHERE a.rev = :rev")
    , @NamedQuery(name = "ActRuIdentitylink.findByGroupId", query = "SELECT a FROM ActRuIdentitylink a WHERE a.groupId = :groupId")
    , @NamedQuery(name = "ActRuIdentitylink.findByType", query = "SELECT a FROM ActRuIdentitylink a WHERE a.type = :type")
    , @NamedQuery(name = "ActRuIdentitylink.findByUserId", query = "SELECT a FROM ActRuIdentitylink a WHERE a.userId = :userId")})
public class ActRuIdentitylink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Column(name = "GROUP_ID_", length = 255)
    private String groupId;
    @Column(name = "TYPE_", length = 255)
    private String type;
    @Column(name = "USER_ID_", length = 255)
    private String userId;
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActReProcdef procDefId;
    @JoinColumn(name = "PROC_INST_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution procInstId;
    @JoinColumn(name = "TASK_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuTask taskId;

    public ActRuIdentitylink() {
    }

    public ActRuIdentitylink(String id) {
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public ActRuTask getTaskId() {
        return taskId;
    }

    public void setTaskId(ActRuTask taskId) {
        this.taskId = taskId;
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
        if (!(object instanceof ActRuIdentitylink)) {
            return false;
        }
        ActRuIdentitylink other = (ActRuIdentitylink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActRuIdentitylink[ id=" + id + " ]";
    }
    
}
