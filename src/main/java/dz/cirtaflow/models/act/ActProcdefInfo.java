/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_PROCDEF_INFO", catalog = "activiti_cirtaflow_test", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"PROC_DEF_ID_"})})
@NamedQueries({
    @NamedQuery(name = "ActProcdefInfo.findAll", query = "SELECT a FROM ActProcdefInfo a")})
public class ActProcdefInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @JoinColumn(name = "INFO_JSON_ID_", referencedColumnName = "ID_")
    @ManyToOne
    private ActGeBytearray infoJsonId;
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_", nullable = false)
    @OneToOne(optional = false)
    private ActReProcdef procDefId;

    public ActProcdefInfo() {
    }

    public ActProcdefInfo(String id) {
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

    public ActGeBytearray getInfoJsonId() {
        return infoJsonId;
    }

    public void setInfoJsonId(ActGeBytearray infoJsonId) {
        this.infoJsonId = infoJsonId;
    }

    public ActReProcdef getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(ActReProcdef procDefId) {
        this.procDefId = procDefId;
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
        if (!(object instanceof ActProcdefInfo)) {
            return false;
        }
        ActProcdefInfo other = (ActProcdefInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActProcdefInfo[ id=" + id + " ]";
    }
    
}
