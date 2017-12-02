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
@Table(name = "ACT_RE_MODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActReModel.findAll", query = "SELECT a FROM ActReModel a")
    , @NamedQuery(name = "ActReModel.findById", query = "SELECT a FROM ActReModel a WHERE a.id = :id")
    , @NamedQuery(name = "ActReModel.findByRev", query = "SELECT a FROM ActReModel a WHERE a.rev = :rev")
    , @NamedQuery(name = "ActReModel.findByName", query = "SELECT a FROM ActReModel a WHERE a.name = :name")
    , @NamedQuery(name = "ActReModel.findByKey", query = "SELECT a FROM ActReModel a WHERE a.key = :key")
    , @NamedQuery(name = "ActReModel.findByCategory", query = "SELECT a FROM ActReModel a WHERE a.category = :category")
    , @NamedQuery(name = "ActReModel.findByCreateTime", query = "SELECT a FROM ActReModel a WHERE a.createTime = :createTime")
    , @NamedQuery(name = "ActReModel.findByLastUpdateTime", query = "SELECT a FROM ActReModel a WHERE a.lastUpdateTime = :lastUpdateTime")
    , @NamedQuery(name = "ActReModel.findByVersion", query = "SELECT a FROM ActReModel a WHERE a.version = :version")
    , @NamedQuery(name = "ActReModel.findByMetaInfo", query = "SELECT a FROM ActReModel a WHERE a.metaInfo = :metaInfo")
    , @NamedQuery(name = "ActReModel.findByTenantId", query = "SELECT a FROM ActReModel a WHERE a.tenantId = :tenantId")})
public class ActReModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_", nullable = false, length = 64)
    private String id;
    @Column(name = "REV_")
    private Integer rev;
    @Column(name = "NAME_", length = 255)
    private String name;
    @Column(name = "KEY_", length = 255)
    private String key;
    @Column(name = "CATEGORY_", length = 255)
    private String category;
    @Column(name = "CREATE_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "LAST_UPDATE_TIME_")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;
    @Column(name = "VERSION_")
    private Integer version;
    @Column(name = "META_INFO_", length = 4000)
    private String metaInfo;
    @Column(name = "TENANT_ID_", length = 255)
    private String tenantId;
    @JoinColumn(name = "DEPLOYMENT_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActReDeployment deploymentId;
    @JoinColumn(name = "EDITOR_SOURCE_VALUE_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActGeBytearray editorSourceValueId;
    @JoinColumn(name = "EDITOR_SOURCE_EXTRA_VALUE_ID_", referencedColumnName = "ID_")
    @ManyToOne(fetch = FetchType.LAZY)
    private ActGeBytearray editorSourceExtraValueId;

    public ActReModel() {
    }

    public ActReModel(String id) {
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(String metaInfo) {
        this.metaInfo = metaInfo;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public ActReDeployment getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(ActReDeployment deploymentId) {
        this.deploymentId = deploymentId;
    }

    public ActGeBytearray getEditorSourceValueId() {
        return editorSourceValueId;
    }

    public void setEditorSourceValueId(ActGeBytearray editorSourceValueId) {
        this.editorSourceValueId = editorSourceValueId;
    }

    public ActGeBytearray getEditorSourceExtraValueId() {
        return editorSourceExtraValueId;
    }

    public void setEditorSourceExtraValueId(ActGeBytearray editorSourceExtraValueId) {
        this.editorSourceExtraValueId = editorSourceExtraValueId;
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
        if (!(object instanceof ActReModel)) {
            return false;
        }
        ActReModel other = (ActReModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cirtaflow.business.cirtaflow.ActReModel[ id=" + id + " ]";
    }
    
}
