package com.rc.uam.model.auditable;

import java.util.Date;

import com.rc.uam.model.User;


/**
 * @author Rachit Bhasin
 *
 */
public interface AuditableCreateOnly {

	Date getCreatedOn();

	User getCreatedBy();

	void setCreatedBy(User createBy);

	void setCreatedOn(Date createdOn);

}
