/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_ID_USER", catalog = "activiti_cirtaflow_test", schema = "")
@NamedQueries({
    @NamedQuery(name = "ActIdUser.findAll", query = "SELECT a FROM ActIdUser a")})
public class ActIdUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Column(name = "FIRST_", length = 255)
    private String first;
    @Column(name = "LAST_", length = 255)
    private String last;
    @Column(name = "EMAIL_", length = 255)
    private String email;
    @Column(name = "PWD_", length = 255)
    private String pwd;
    @Column(name = "PICTURE_ID_", length = 64)
    private String pictureId;
    @ManyToMany(mappedBy = "actIdUserCollection")
    private Collection<ActIdGroup> actIdGroupCollection;

    public ActIdUser() {
    }

    public ActIdUser(String id) {
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

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public Collection<ActIdGroup> getActIdGroupCollection() {
        return actIdGroupCollection;
    }

    public void setActIdGroupCollection(Collection<ActIdGroup> actIdGroupCollection) {
        this.actIdGroupCollection = actIdGroupCollection;
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
        if (!(object instanceof ActIdUser)) {
            return false;
        }
        ActIdUser other = (ActIdUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActIdUser[ id=" + id + " ]";
    }
    
}
