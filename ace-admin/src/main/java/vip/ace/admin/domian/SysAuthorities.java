package vip.ace.admin.domian;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class SysAuthorities implements Serializable,GrantedAuthority {
    private Integer authorityId;

    private String authorityName;

    private String authorityDesc;

    private Integer enabled;

    private static final long serialVersionUID = 1L;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    public String getAuthorityDesc() {
        return authorityDesc;
    }

    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc == null ? null : authorityDesc.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authorityId=").append(authorityId);
        sb.append(", authorityName=").append(authorityName);
        sb.append(", authorityDesc=").append(authorityDesc);
        sb.append(", enabled=").append(enabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysAuthorities other = (SysAuthorities) that;
        return (this.getAuthorityId() == null ? other.getAuthorityId() == null : this.getAuthorityId().equals(other.getAuthorityId()))
            && (this.getAuthorityName() == null ? other.getAuthorityName() == null : this.getAuthorityName().equals(other.getAuthorityName()))
            && (this.getAuthorityDesc() == null ? other.getAuthorityDesc() == null : this.getAuthorityDesc().equals(other.getAuthorityDesc()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAuthorityId() == null) ? 0 : getAuthorityId().hashCode());
        result = prime * result + ((getAuthorityName() == null) ? 0 : getAuthorityName().hashCode());
        result = prime * result + ((getAuthorityDesc() == null) ? 0 : getAuthorityDesc().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        return result;
    }

    @Override
    public String getAuthority() {
        return this.getAuthorityId()+"";
    }
}