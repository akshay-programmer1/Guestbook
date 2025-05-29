/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.docs.guestbook.service;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Guestbook. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author liferay
 * @see GuestbookServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface GuestbookService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.docs.guestbook.service.impl.GuestbookServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the guestbook remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link GuestbookServiceUtil} if injection and service tracking are not available.
	 */
	public Guestbook addGuestbook(String name, ServiceContext serviceContext)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Guestbook> getGuestbooks(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Guestbook> getGuestbooks(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Guestbook> getGuestbooks(
		long groupId, int start, int end, OrderByComparator<Guestbook> obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGuestbooksCount(long groupId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}