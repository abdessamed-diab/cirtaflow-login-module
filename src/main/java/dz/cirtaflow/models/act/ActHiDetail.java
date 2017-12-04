/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.cirtaflow.models.act;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_HI_DETAIL", catalog = "activiti_cirtaflow_test", schema = "")
@NamedQueries({
    @NamedQuery(name = "ActHiDetail.findAll", query = "SELECT a FROM ActHiDetail a")})
public class ActHiDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Basic(optional = false)
    @Column(name = "TYPE_", nullable = false, length = 255)
    private String type;
    @Column(name = "PROC_INST_ID_", length = 64)
    private String procInstId;
    @Column(name = "EXECUTION_ID_", length = 64)
    private String executionId;
    @Column(name = "TASK_ID_", length = 64)
    private String taskId;
    @Column(name = "ACT_INST_ID_", length = 64)
    private String actInstId;
    @Basic(optional = false)
    @Column(name = "NAME_", nullable = false, length = 255)
    private String name;
    @Column(name = "VAR_TYPE_", length = 255)
    private String varType;
    @Column(name = "REV_")
    private Integer rev;
    @Basic(optional = false)
    @Column(name = "TIME_", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Column(name = "BYTEARRAY_ID_", length = 64)
    private String bytearrayId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DOUBLE_", precision = 22)
    private Double double1;
    @Column(name = "LONG_")
    private BigInteger long1;
    @Column(name = "TEXT_", length = 4000)
    private String text;
    @Column(name = "TEXT2_", length = 4000)
    private String text2;

    public ActHiDetail() {
    }

    public ActHiDetail(String id) {
        this.id = id;
    }

    public ActHiDetail(String id, String type, String name, Date time) {
        this.id = id;
        this.type = type;
        this.name = name;
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

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getActInstId() {
        return actInstId;
    }

    public void setActInstId(String actInstId) {
        this.actInstId = actInstId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVarType() {
        return varType;
    }

    public void setVarType(String varType) {
        this.varType = varType;
    }

    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getBytearrayId() {
        return bytearrayId;
    }

    public void setBytearrayId(String bytearrayId) {
        this.bytearrayId = bytearrayId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActHiDetail)) {
            return false;
        }
        ActHiDetail other = (ActHiDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActHiDetail[ id=" + id + " ]";
    }
    
}
