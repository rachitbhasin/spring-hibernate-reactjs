package com.rc.uam.model.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rc.uam.model.User;
import com.rc.uam.model.auditable.Auditable;


/**
 * @author Rachit Bhasin
 *
 */
@MappedSuperclass
public class BaseEntity implements Auditable, Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne()
	@JoinColumns({ @JoinColumn(name = "created_by", referencedColumnName = "id", insertable = true, updatable = false) })
	@JsonIgnore
	private User createdBy;

	@OneToOne()
	@JoinColumns({ @JoinColumn(name = "last_modified_by", referencedColumnName = "id", insertable = false, updatable = true) })
	@JsonIgnore
	private User lastModifiedBy;

	@Column(name = "created_on", insertable = true, updatable = false)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "last_modified_on", insertable = false, updatable = true)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date lastModifiedOn;

	@Override
	public Date getCreatedOn() {
		return this.createdOn;
	}

	@Override
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public User getCreatedBy() {
		return createdBy;
	}

	@Override
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastModifiedBy
	 */
	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy
	 *            the lastModifiedBy to set
	 */
	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedOn
	 */
	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	/**
	 * @param lastModifiedOn
	 *            the lastModifiedOn to set
	 */
	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
}
