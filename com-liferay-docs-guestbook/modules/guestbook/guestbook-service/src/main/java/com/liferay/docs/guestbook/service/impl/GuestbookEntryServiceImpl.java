package com.liferay.docs.guestbook.service.impl;

import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.docs.guestbook.service.base.GuestbookEntryServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
		property = {
				"json.web.service.context.name=gb",
				"json.web.service.context.path=GuestbookEntry"
		},
		service = AopService.class
)
public class GuestbookEntryServiceImpl extends GuestbookEntryServiceBaseImpl {

	@Override
	public GuestbookEntry addGuestbookEntry(
			long userId, long groupId, long guestbookId,
			String name, String email, String message,
			ServiceContext serviceContext)
			throws PortalException {

		return guestbookEntryLocalService.addGuestbookEntry(
				userId, guestbookId, name, email, message, serviceContext);
	}


	public GuestbookEntry updateGuestbookEntry(
			long userId, long guestbookId, long entryId,
			String name, String email, String message,
			ServiceContext serviceContext)
			throws PortalException {

		return guestbookEntryLocalService.updateGuestbookEntry(
				userId, guestbookId, entryId, name, email, message, serviceContext);
	}

	public GuestbookEntry deleteGuestbookEntry(long entryId)
			throws PortalException {

		return guestbookEntryLocalService.deleteGuestbookEntry(entryId);
	}

	public GuestbookEntry getGuestbookEntry(long entryId)
			throws PortalException {

		return guestbookEntryLocalService.getGuestbookEntry(entryId);
	}
}
