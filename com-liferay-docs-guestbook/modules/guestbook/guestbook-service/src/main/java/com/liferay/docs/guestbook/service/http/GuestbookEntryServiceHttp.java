/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.docs.guestbook.service.http;

import com.liferay.docs.guestbook.service.GuestbookEntryServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>GuestbookEntryServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author liferay
 * @generated
 */
public class GuestbookEntryServiceHttp {

	public static com.liferay.docs.guestbook.model.GuestbookEntry
			addGuestbookEntry(
				HttpPrincipal httpPrincipal, long userId, long groupId,
				long guestbookId, String name, String email, String message,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				GuestbookEntryServiceUtil.class, "addGuestbookEntry",
				_addGuestbookEntryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId, guestbookId, name, email, message,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.docs.guestbook.model.GuestbookEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntry
			updateGuestbookEntry(
				HttpPrincipal httpPrincipal, long userId, long guestbookId,
				long entryId, String name, String email, String message,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				GuestbookEntryServiceUtil.class, "updateGuestbookEntry",
				_updateGuestbookEntryParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, guestbookId, entryId, name, email, message,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.docs.guestbook.model.GuestbookEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntry
			deleteGuestbookEntry(HttpPrincipal httpPrincipal, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				GuestbookEntryServiceUtil.class, "deleteGuestbookEntry",
				_deleteGuestbookEntryParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, entryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.docs.guestbook.model.GuestbookEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntry
			getGuestbookEntry(HttpPrincipal httpPrincipal, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				GuestbookEntryServiceUtil.class, "getGuestbookEntry",
				_getGuestbookEntryParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, entryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.docs.guestbook.model.GuestbookEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		GuestbookEntryServiceHttp.class);

	private static final Class<?>[] _addGuestbookEntryParameterTypes0 =
		new Class[] {
			long.class, long.class, long.class, String.class, String.class,
			String.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateGuestbookEntryParameterTypes1 =
		new Class[] {
			long.class, long.class, long.class, String.class, String.class,
			String.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteGuestbookEntryParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getGuestbookEntryParameterTypes3 =
		new Class[] {long.class};

}