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
@Table(name = "ACT_HI_IDENTITYLINK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActHiIdentitylink.findAll", query = "SELECT a FROM ActHiIdentitylink a")
    , @NamedQuery(name = "ActHiIdentitylink.findById", query = "SELECT a FROM ActHiIdentitylink a WHERE a.id = :id")
    , @NamedQuery(name = "ActHiIdentitylink.findByGroupId", query = "SELECT a FROM ActHiIdentitylink a WHERE a.groupId = :groupId")
    , @NamedQuery(name = "ActHiIdentitylink.findByType", query = "SELECT a FROM ActHiIdentitylink a WHERE a.type = :type")
    , @NamedQuery(name = "ActHiIdentitylink.findByUserId", query = "SELECT a FROM ActHiIdentitylink a WHERE a.userId = :userId")
    , @NamedQuery(name = "ActHiIdentitylink.findByTaskId", query = "SELECT a FROM ActHiIdentitylink a WHERE a.taskId = :taskId")
    , @NamedQuery(name = "ActHiIdentitylink.findByProcInstId", query = "SELECT a FROM ActHiIdentitylink a WHERE a.procInstId = :procInstId")})
public class ActHiIdentitylink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "GROUP_ID_", length = 255)
    private String groupId;
    @Column(name = "TYPE_", length = 255)
    private String type;
    @Column(name = "USER_ID_", length = 255)
    private String userId;
    @Column(name = "TASK_ID_", length = 64)
    private String taskId;
    @Column(name = "PROC_INST_ID_", length = 64)
    private String procInstId;

    public ActHiIdentitylink() {
    }

    public ActHiIdentitylink(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
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
        if (!(object instanceof ActHiIdentitylink)) {
            return false;
        }
        ActHiIdentitylink other = (ActHiIdentitylink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActHiIdentitylink[ id=" + id + " ]";
    }
    
}
