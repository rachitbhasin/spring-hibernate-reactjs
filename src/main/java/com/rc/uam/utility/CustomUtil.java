package com.rc.uam.utility;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.context.SecurityContextHolder;

import com.rc.uam.model.Authority;
import com.rc.uam.model.User;


/**
 * @author Rachit Bhasin
 *
 */

public final class CustomUtil {
	public static User getLoggedInUser() {
		if (isUserLoggedIn()) {
			return (User) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} else {
			return null;
		}
	}

	// public static Object checkAnonymousUser() {
	// return SecurityContextHolder.getContext().getAuthentication()
	// .getPrincipal();
	// }

	public static boolean isAdmin() {
		boolean b = false;

		if (getLoggedInUser() != null) {
			User user = (User)getLoggedInUser();
			Collection<Authority> auth = (Collection<Authority>) user.getAuthorities();
			Iterator<Authority> i = auth.iterator();
			if (i.hasNext()) {
				Authority authority = i.next();
				if(authority.getAuthority() == Constants.ROLE_ADMIN) {
					b = true;
				}
			}
		}

		return b;
	}

	/**
	 * to check if user logged in or not
	 *
	 * @return true/false (Boolean)
	 */
	public static Boolean isUserLoggedIn() {
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& !SecurityContextHolder.getContext().getAuthentication()
						.getPrincipal().equals("anonymousUser")) {
			return true;
		} else {
			return false;
		}
	}
}
