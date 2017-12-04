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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_GE_BYTEARRAY", catalog = "activiti_cirtaflow_test", schema = "")
@NamedQueries({
    @NamedQuery(name = "ActGeBytearray.findAll", query = "SELECT a FROM ActGeBytearray a")})
public class ActGeBytearray implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Column(name = "NAME_", length = 255)
    private String name;
    @Lob
    @Column(name = "BYTES_")
    private byte[] bytes;
    @Column(name = "GENERATED_")
    private Short generated;
    @JoinColumn(name = "DEPLOYMENT_ID_", referencedColumnName = "ID_")
    @ManyToOne
    private ActReDeployment deploymentId;
    @OneToMany(mappedBy = "editorSourceValueId")
    private Collection<ActReModel> actReModelCollection;
    @OneToMany(mappedBy = "editorSourceExtraValueId")
    private Collection<ActReModel> actReModelCollection1;
    @OneToMany(mappedBy = "bytearrayId")
    private Collection<ActRuVariable> actRuVariableCollection;
    @OneToMany(mappedBy = "exceptionStackId")
    private Collection<ActRuDeadletterJob> actRuDeadletterJobCollection;
    @OneToMany(mappedBy = "exceptionStackId")
    private Collection<ActRuJob> actRuJobCollection;
    @OneToMany(mappedBy = "infoJsonId")
    private Collection<ActProcdefInfo> actProcdefInfoCollection;
    @OneToMany(mappedBy = "exceptionStackId")
    private Collection<ActRuSuspendedJob> actRuSuspendedJobCollection;
    @OneToMany(mappedBy = "exceptionStackId")
    private Collection<ActRuTimerJob> actRuTimerJobCollection;

    public ActGeBytearray() {
    }

    public ActGeBytearray(String id) {
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

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Short getGenerated() {
        return generated;
    }

    public void setGenerated(Short generated) {
        this.generated = generated;
    }

    public ActReDeployment getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(ActReDeployment deploymentId) {
        this.deploymentId = deploymentId;
    }

    public Collection<ActReModel> getActReModelCollection() {
        return actReModelCollection;
    }

    public void setActReModelCollection(Collection<ActReModel> actReModelCollection) {
        this.actReModelCollection = actReModelCollection;
    }

    public Collection<ActReModel> getActReModelCollection1() {
        return actReModelCollection1;
    }

    public void setActReModelCollection1(Collection<ActReModel> actReModelCollection1) {
        this.actReModelCollection1 = actReModelCollection1;
    }

    public Collection<ActRuVariable> getActRuVariableCollection() {
        return actRuVariableCollection;
    }

    public void setActRuVariableCollection(Collection<ActRuVariable> actRuVariableCollection) {
        this.actRuVariableCollection = actRuVariableCollection;
    }

    public Collection<ActRuDeadletterJob> getActRuDeadletterJobCollection() {
        return actRuDeadletterJobCollection;
    }

    public void setActRuDeadletterJobCollection(Collection<ActRuDeadletterJob> actRuDeadletterJobCollection) {
        this.actRuDeadletterJobCollection = actRuDeadletterJobCollection;
    }

    public Collection<ActRuJob> getActRuJobCollection() {
        return actRuJobCollection;
    }

    public void setActRuJobCollection(Collection<ActRuJob> actRuJobCollection) {
        this.actRuJobCollection = actRuJobCollection;
    }

    public Collection<ActProcdefInfo> getActProcdefInfoCollection() {
        return actProcdefInfoCollection;
    }

    public void setActProcdefInfoCollection(Collection<ActProcdefInfo> actProcdefInfoCollection) {
        this.actProcdefInfoCollection = actProcdefInfoCollection;
    }

    public Collection<ActRuSuspendedJob> getActRuSuspendedJobCollection() {
        return actRuSuspendedJobCollection;
    }

    public void setActRuSuspendedJobCollection(Collection<ActRuSuspendedJob> actRuSuspendedJobCollection) {
        this.actRuSuspendedJobCollection = actRuSuspendedJobCollection;
    }

    public Collection<ActRuTimerJob> getActRuTimerJobCollection() {
        return actRuTimerJobCollection;
    }

    public void setActRuTimerJobCollection(Collection<ActRuTimerJob> actRuTimerJobCollection) {
        this.actRuTimerJobCollection = actRuTimerJobCollection;
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
        if (!(object instanceof ActGeBytearray)) {
            return false;
        }
        ActGeBytearray other = (ActGeBytearray) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActGeBytearray[ id=" + id + " ]";
    }
    
}
