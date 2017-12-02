/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_RU_VARIABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActRuVariable.findAll", query = "SELECT a FROM ActRuVariable a")
    , @NamedQuery(name = "ActRuVariable.findById", query = "SELECT a FROM ActRuVariable a WHERE a.id = :id")
    , @NamedQuery(name = "ActRuVariable.findByRev", query = "SELECT a FROM ActRuVariable a WHERE a.rev = :rev")
    , @NamedQuery(name = "ActRuVariable.findByType", query = "SELECT a FROM ActRuVariable a WHERE a.type = :type")
    , @NamedQuery(name = "ActRuVariable.findByName", query = "SELECT a FROM ActRuVariable a WHERE a.name = :name")
    , @NamedQuery(name = "ActRuVariable.findByTaskId", query = "SELECT a FROM ActRuVariable a WHERE a.taskId = :taskId")
    , @NamedQuery(name = "ActRuVariable.findByDouble1", query = "SELECT a FROM ActRuVariable a WHERE a.double1 = :double1")
    , @NamedQuery(name = "ActRuVariable.findByLong1", query = "SELECT a FROM ActRuVariable a WHERE a.long1 = :long1")
    , @NamedQuery(name = "ActRuVariable.findByText", query = "SELECT a FROM ActRuVariable a WHERE a.text = :text")
    , @NamedQuery(name = "ActRuVariable.findByText2", query = "SELECT a FROM ActRuVariable a WHERE a.text2 = :text2")})
public class ActRuVariable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Basic(optional = false)
    @Column(name = "TYPE_", nullable = false, length = 255)
    private String type;
    @Basic(optional = false)
    @Column(name = "NAME_", nullable = false, length = 255)
    private String name;
    @Column(name = "TASK_ID_", length = 64)
    private String taskId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DOUBLE_", precision = 22)
    private Double double1;
    @Column(name = "LONG_")
    private BigInteger long1;
    @Column(name = "TEXT_", length = 4000)
    private String text;
    @Column(name = "TEXT2_", length = 4000)
    private String text2;
    @JoinColumn(name = "BYTEARRAY_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActGeBytearray bytearrayId;
    @JoinColumn(name = "EXECUTION_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution executionId;
    @JoinColumn(name = "PROC_INST_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActRuExecution procInstId;

    public ActRuVariable() {
    }

    public ActRuVariable(String id) {
        this.id = id;
    }

    public ActRuVariable(String id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Double getDouble1() {
        return double1;
    }

    public void setDouble1(Double double1) {
        this.double1 = double1;
    }

    public BigInteger getLong1() {
        return long1;
    }

    public void setLong1(BigInteger long1) {
        this.long1 = long1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public ActGeBytearray getBytearrayId() {
        return bytearrayId;
    }

    public void setBytearrayId(ActGeBytearray bytearrayId) {
        this.bytearrayId = bytearrayId;
    }

    public ActRuExecution getExecutionId() {
        return executionId;
    }

    public void setExecutionId(ActRuExecution executionId) {
        this.executionId = executionId;
    }

    public ActRuExecution getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(ActRuExecution procInstId) {
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
        if (!(object instanceof ActRuVariable)) {
            return false;
        }
        ActRuVariable other = (ActRuVariable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActRuVariable[ id=" + id + " ]";
    }
    
}
