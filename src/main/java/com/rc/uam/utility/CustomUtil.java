package com.rc.uam.utility;

import org.springframework.security.core.context.SecurityContextHolder;

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
			if (getLoggedInUser().getRole().getName().equalsIgnoreCase(
					Constants.ROLE_ADMIN)) {
				b = true;
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
