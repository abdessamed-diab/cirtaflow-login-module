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
@Table(name = "ACT_HI_COMMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActHiComment.findAll", query = "SELECT a FROM ActHiComment a")
    , @NamedQuery(name = "ActHiComment.findById", query = "SELECT a FROM ActHiComment a WHERE a.id = :id")
    , @NamedQuery(name = "ActHiComment.findByType", query = "SELECT a FROM ActHiComment a WHERE a.type = :type")
    , @NamedQuery(name = "ActHiComment.findByTime", query = "SELECT a FROM ActHiComment a WHERE a.time = :time")
    , @NamedQuery(name = "ActHiComment.findByUserId", query = "SELECT a FROM ActHiComment a WHERE a.userId = :userId")
    , @NamedQuery(name = "ActHiComment.findByTaskId", query = "SELECT a FROM ActHiComment a WHERE a.taskId = :taskId")
    , @NamedQuery(name = "ActHiComment.findByProcInstId", query = "SELECT a FROM ActHiComment a WHERE a.procInstId = :procInstId")
    , @NamedQuery(name = "ActHiComment.findByAction", query = "SELECT a FROM ActHiComment a WHERE a.action = :action")
    , @NamedQuery(name = "ActHiComment.findByMessage", query = "SELECT a FROM ActHiComment a WHERE a.message = :message")})
public class ActHiComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "TYPE_", length = 255)
    private String type;
    @Basic(optional = false)
    @Column(name = "TIME_", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Column(name = "USER_ID_", length = 255)
    private String userId;
    @Column(name = "TASK_ID_", length = 64)
    private String taskId;
    @Column(name = "PROC_INST_ID_", length = 64)
    private String procInstId;
    @Column(name = "ACTION_", length = 255)
    private String action;
    @Column(name = "MESSAGE_", length = 4000)
    private String message;
    @Lob
    @Column(name = "FULL_MSG_")
    private byte[] fullMsg;

    public ActHiComment() {
    }

    public ActHiComment(String id) {
        this.id = id;
    }

    public ActHiComment(String id, Date time) {
        this.id = id;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte[] getFullMsg() {
        return fullMsg;
    }

    public void setFullMsg(byte[] fullMsg) {
        this.fullMsg = fullMsg;
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
        if (!(object instanceof ActHiComment)) {
            return false;
        }
        ActHiComment other = (ActHiComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActHiComment[ id=" + id + " ]";
    }
    
}
