/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.docs.guestbook.service.impl;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.base.GuestbookServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Theme;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author liferay
 */
@Component(
	property = {
		"json.web.service.context.name=gb",
		"json.web.service.context.path=Guestbook"
	},
	service = AopService.class
)
public class GuestbookServiceImpl extends GuestbookServiceBaseImpl {

	public Guestbook addGuestbook(String name, ServiceContext serviceContext) throws PortalException {
		return guestbookLocalService.addGuestbook(name, serviceContext);
	}

	// Get all guestbooks for a group
	public List<Guestbook> getGuestbooks(long groupId) {
		return guestbookLocalService.getGuestbooks(groupId);
	}

	// Get paginated guestbooks for a group
	public List<Guestbook> getGuestbooks(long groupId, int start, int end) {
		return guestbookLocalService.getGuestbooks(groupId, start, end);
	}

	// Get paginated guestbooks with ordering
	public List<Guestbook> getGuestbooks(long groupId, int start, int end, OrderByComparator<Guestbook> obc) {
		return guestbookLocalService.getGuestbooks(groupId, start, end, obc);
	}

	// Count guestbooks in a group
	public int getGuestbooksCount(long groupId) {
		return guestbookLocalService.getGuestbooksCount(groupId);
	}


}