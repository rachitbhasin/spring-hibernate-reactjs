package com.rc.uam.interceptor;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.rc.uam.model.auditable.Auditable;
import com.rc.uam.utility.CustomUtil;

/**
 * this class is used to manage audit fields like createdby, modifiedby,
 * createdon, modifiedon
 *
 * @author rcs
 *
 */

public class SaveOrUpdateInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {

		Calendar currenttime = Calendar.getInstance();

		if (entity instanceof Auditable) {
			int indexOfLastModifieldOn = ArrayUtils.indexOf(propertyNames,
					"lastModifiedOn");
			currentState[indexOfLastModifieldOn] = new Date(
					(currenttime.getTime()).getTime());

			int indexOfLastModifieldBy = ArrayUtils.indexOf(propertyNames,
					"lastModifiedBy");
			currentState[indexOfLastModifieldBy] = CustomUtil.getLoggedInUser();

			return true;
		}
		return false;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		Calendar currenttime = Calendar.getInstance();

		if (entity instanceof Auditable) {
			int indexOfCreatedOn = ArrayUtils.indexOf(propertyNames,
					"createdOn");
			state[indexOfCreatedOn] = new Date(
					(currenttime.getTime()).getTime());

			int indexOfCreatedBy = ArrayUtils.indexOf(propertyNames,
					"createdBy");
			state[indexOfCreatedBy] = CustomUtil.getLoggedInUser();

			return true;
		}
		return false;
	}
}
