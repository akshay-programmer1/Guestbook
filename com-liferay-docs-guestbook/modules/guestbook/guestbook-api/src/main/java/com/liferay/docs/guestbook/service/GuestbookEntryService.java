/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.docs.guestbook.service;

import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for GuestbookEntry. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author liferay
 * @see GuestbookEntryServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface GuestbookEntryService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.docs.guestbook.service.impl.GuestbookEntryServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the guestbook entry remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link GuestbookEntryServiceUtil} if injection and service tracking are not available.
	 */
	public GuestbookEntry addGuestbookEntry(
			long userId, long groupId, long guestbookId, String name,
			String email, String message, ServiceContext serviceContext)
		throws PortalException;

	public GuestbookEntry deleteGuestbookEntry(long entryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GuestbookEntry getGuestbookEntry(long entryId)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public GuestbookEntry updateGuestbookEntry(
			long userId, long guestbookId, long entryId, String name,
			String email, String message, ServiceContext serviceContext)
		throws PortalException;

}