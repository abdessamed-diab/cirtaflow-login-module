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
import java.util.Date;

/**
 *
 * @author diab
 */
@Entity
@Table(name = "ACT_HI_VARINST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActHiVarinst.findAll", query = "SELECT a FROM ActHiVarinst a")
    , @NamedQuery(name = "ActHiVarinst.findById", query = "SELECT a FROM ActHiVarinst a WHERE a.id = :id")
    , @NamedQuery(name = "ActHiVarinst.findByProcInstId", query = "SELECT a FROM ActHiVarinst a WHERE a.procInstId = :procInstId")
    , @NamedQuery(name = "ActHiVarinst.findByExecutionId", query = "SELECT a FROM ActHiVarinst a WHERE a.executionId = :executionId")
    , @NamedQuery(name = "ActHiVarinst.findByTaskId", query = "SELECT a FROM ActHiVarinst a WHERE a.taskId = :taskId")
    , @NamedQuery(name = "ActHiVarinst.findByName", query = "SELECT a FROM ActHiVarinst a WHERE a.name = :name")
    , @NamedQuery(name = "ActHiVarinst.findByVarType", query = "SELECT a FROM ActHiVarinst a WHERE a.varType = :varType")
    , @NamedQuery(name = "ActHiVarinst.findByRev", query = "SELECT a FROM ActHiVarinst a WHERE a.rev = :rev")
    , @NamedQuery(name = "ActHiVarinst.findByBytearrayId", query = "SELECT a FROM ActHiVarinst a WHERE a.bytearrayId = :bytearrayId")
    , @NamedQuery(name = "ActHiVarinst.findByDouble1", query = "SELECT a FROM ActHiVarinst a WHERE a.double1 = :double1")
    , @NamedQuery(name = "ActHiVarinst.findByLong1", query = "SELECT a FROM ActHiVarinst a WHERE a.long1 = :long1")
    , @NamedQuery(name = "ActHiVarinst.findByText", query = "SELECT a FROM ActHiVarinst a WHERE a.text = :text")
    , @NamedQuery(name = "ActHiVarinst.findByText2", query = "SELECT a FROM ActHiVarinst a WHERE a.text2 = :text2")
    , @NamedQuery(name = "ActHiVarinst.findByCreateTime", query = "SELECT a FROM ActHiVarinst a WHERE a.createTime = :createTime")
    , @NamedQuery(name = "ActHiVarinst.findByLastUpdatedTime", query = "SELECT a FROM ActHiVarinst a WHERE a.lastUpdatedTime = :lastUpdatedTime")})
public class ActHiVarinst implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "PROC_INST_ID_", length = 64)
    private String procInstId;
    @Column(name = "EXECUTION_ID_", length = 64)
    private String executionId;
    @Column(name = "TASK_ID_", length = 64)
    private String taskId;
    @Basic(optional = false)
    @Column(name = "NAME_", nullable = false, length = 255)
    private String name;
    @Column(name = "VAR_TYPE_", length = 100)
    private String varType;
    @Column(name = "REV_")
    private Integer rev;
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
    @Column(name = "CREATE_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "LAST_UPDATED_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;

    public ActHiVarinst() {
    }

    public ActHiVarinst(String id) {
        this.id = id;
    }

    public ActHiVarinst(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
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
        if (!(object instanceof ActHiVarinst)) {
            return false;
        }
        ActHiVarinst other = (ActHiVarinst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActHiVarinst[ id=" + id + " ]";
    }
    
}
