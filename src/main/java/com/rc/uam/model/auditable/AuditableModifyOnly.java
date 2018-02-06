package com.rc.uam.model.auditable;

import java.util.Date;

import com.rc.uam.model.User;

/**
 * @author Rachit Bhasin
 *
 */
public interface AuditableModifyOnly {

	Date getLastModifiedOn();

	User getLastModifiedBy();

	void setLastModifiedBy(User user);

	void setLastModifiedOn(Date lastModifiedOn);
}
