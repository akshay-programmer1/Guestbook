/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.docs.guestbook.service;

import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the remote service utility for GuestbookEntry. This utility wraps
 * <code>com.liferay.docs.guestbook.service.impl.GuestbookEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author liferay
 * @see GuestbookEntryService
 * @generated
 */
public class GuestbookEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.docs.guestbook.service.impl.GuestbookEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static GuestbookEntry addGuestbookEntry(
			long userId, long groupId, long guestbookId, String name,
			String email, String message,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addGuestbookEntry(
			userId, groupId, guestbookId, name, email, message, serviceContext);
	}

	public static GuestbookEntry deleteGuestbookEntry(long entryId)
		throws PortalException {

		return getService().deleteGuestbookEntry(entryId);
	}

	public static GuestbookEntry getGuestbookEntry(long entryId)
		throws PortalException {

		return getService().getGuestbookEntry(entryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static GuestbookEntry updateGuestbookEntry(
			long userId, long guestbookId, long entryId, String name,
			String email, String message,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateGuestbookEntry(
			userId, guestbookId, entryId, name, email, message, serviceContext);
	}

	public static GuestbookEntryService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<GuestbookEntryService> _serviceSnapshot =
		new Snapshot<>(
			GuestbookEntryServiceUtil.class, GuestbookEntryService.class);

}