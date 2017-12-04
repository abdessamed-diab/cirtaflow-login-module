/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_ID_GROUP", catalog = "activiti_cirtaflow_test", schema = "")
@NamedQueries({
    @NamedQuery(name = "ActIdGroup.findAll", query = "SELECT a FROM ActIdGroup a")})
public class ActIdGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Column(name = "NAME_", length = 255)
    private String name;
    @Column(name = "TYPE_", length = 255)
    private String type;
    @JoinTable(name = "ACT_ID_MEMBERSHIP", joinColumns = {
        @JoinColumn(name = "GROUP_ID_", referencedColumnName = "ID_", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "USER_ID_", referencedColumnName = "ID_", nullable = false)})
    @ManyToMany
    private Collection<ActIdUser> actIdUserCollection;

    public ActIdGroup() {
    }

    public ActIdGroup(String id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<ActIdUser> getActIdUserCollection() {
        return actIdUserCollection;
    }

    public void setActIdUserCollection(Collection<ActIdUser> actIdUserCollection) {
        this.actIdUserCollection = actIdUserCollection;
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
        if (!(object instanceof ActIdGroup)) {
            return false;
        }
        ActIdGroup other = (ActIdGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActIdGroup[ id=" + id + " ]";
    }
    
}
