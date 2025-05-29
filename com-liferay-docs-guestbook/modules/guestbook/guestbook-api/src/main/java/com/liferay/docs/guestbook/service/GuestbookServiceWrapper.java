/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.docs.guestbook.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GuestbookService}.
 *
 * @author liferay
 * @see GuestbookService
 * @generated
 */
public class GuestbookServiceWrapper
	implements GuestbookService, ServiceWrapper<GuestbookService> {

	public GuestbookServiceWrapper() {
		this(null);
	}

	public GuestbookServiceWrapper(GuestbookService guestbookService) {
		_guestbookService = guestbookService;
	}

	@Override
	public com.liferay.docs.guestbook.model.Guestbook addGuestbook(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _guestbookService.addGuestbook(name, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.docs.guestbook.model.Guestbook>
		getGuestbooks(long groupId) {

		return _guestbookService.getGuestbooks(groupId);
	}

	@Override
	public java.util.List<com.liferay.docs.guestbook.model.Guestbook>
		getGuestbooks(long groupId, int start, int end) {

		return _guestbookService.getGuestbooks(groupId, start, end);
	}

	@Override
	public java.util.List<com.liferay.docs.guestbook.model.Guestbook>
		getGuestbooks(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.docs.guestbook.model.Guestbook> obc) {

		return _guestbookService.getGuestbooks(groupId, start, end, obc);
	}

	@Override
	public int getGuestbooksCount(long groupId) {
		return _guestbookService.getGuestbooksCount(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _guestbookService.getOSGiServiceIdentifier();
	}

	@Override
	public GuestbookService getWrappedService() {
		return _guestbookService;
	}

	@Override
	public void setWrappedService(GuestbookService guestbookService) {
		_guestbookService = guestbookService;
	}

	private GuestbookService _guestbookService;

}