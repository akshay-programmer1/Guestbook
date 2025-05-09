/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.docs.guestbook.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GuestbookEntryService}.
 *
 * @author liferay
 * @see GuestbookEntryService
 * @generated
 */
public class GuestbookEntryServiceWrapper
	implements GuestbookEntryService, ServiceWrapper<GuestbookEntryService> {

	public GuestbookEntryServiceWrapper() {
		this(null);
	}

	public GuestbookEntryServiceWrapper(
		GuestbookEntryService guestbookEntryService) {

		_guestbookEntryService = guestbookEntryService;
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestbookEntry addGuestbookEntry(
			long userId, long groupId, long guestbookId, String name,
			String email, String message,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookEntryService.addGuestbookEntry(
			userId, groupId, guestbookId, name, email, message, serviceContext);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestbookEntry deleteGuestbookEntry(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookEntryService.deleteGuestbookEntry(entryId);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestbookEntry getGuestbookEntry(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookEntryService.getGuestbookEntry(entryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _guestbookEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestbookEntry updateGuestbookEntry(
			long userId, long guestbookId, long entryId, String name,
			String email, String message,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookEntryService.updateGuestbookEntry(
			userId, guestbookId, entryId, name, email, message, serviceContext);
	}

	@Override
	public GuestbookEntryService getWrappedService() {
		return _guestbookEntryService;
	}

	@Override
	public void setWrappedService(GuestbookEntryService guestbookEntryService) {
		_guestbookEntryService = guestbookEntryService;
	}

	private GuestbookEntryService _guestbookEntryService;

}