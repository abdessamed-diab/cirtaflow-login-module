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
@Table(name = "ACT_ID_INFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActIdInfo.findAll", query = "SELECT a FROM ActIdInfo a")
    , @NamedQuery(name = "ActIdInfo.findById", query = "SELECT a FROM ActIdInfo a WHERE a.id = :id")
    , @NamedQuery(name = "ActIdInfo.findByRev", query = "SELECT a FROM ActIdInfo a WHERE a.rev = :rev")
    , @NamedQuery(name = "ActIdInfo.findByUserId", query = "SELECT a FROM ActIdInfo a WHERE a.userId = :userId")
    , @NamedQuery(name = "ActIdInfo.findByType", query = "SELECT a FROM ActIdInfo a WHERE a.type = :type")
    , @NamedQuery(name = "ActIdInfo.findByKey", query = "SELECT a FROM ActIdInfo a WHERE a.key = :key")
    , @NamedQuery(name = "ActIdInfo.findByValue", query = "SELECT a FROM ActIdInfo a WHERE a.value = :value")
    , @NamedQuery(name = "ActIdInfo.findByParentId", query = "SELECT a FROM ActIdInfo a WHERE a.parentId = :parentId")})
public class ActIdInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Column(name = "USER_ID_", length = 64)
    private String userId;
    @Column(name = "TYPE_", length = 64)
    private String type;
    @Column(name = "KEY_", length = 255)
    private String key;
    @Column(name = "VALUE_", length = 255)
    private String value;
    @Lob
    @Column(name = "PASSWORD_")
    private byte[] password;
    @Column(name = "PARENT_ID_", length = 255)
    private String parentId;

    public ActIdInfo() {
    }

    public ActIdInfo(String id) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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
        if (!(object instanceof ActIdInfo)) {
            return false;
        }
        ActIdInfo other = (ActIdInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActIdInfo[ id=" + id + " ]";
    }
    
}
