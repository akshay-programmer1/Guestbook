package com.liferay.docs.guestbook.internal.security;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.docs.guestbook.service.GuestbookEntryLocalServiceUtil;
import com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

public class GuestbookPermission {
    public static void check(
            PermissionChecker permissionChecker, long entryId,
            String actionId)
            throws PortalException, SystemException {

        if (!contains(permissionChecker, entryId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static void check(
            PermissionChecker permissionChecker, Guestbook entry,
            String actionId)
            throws PortalException, SystemException {

        if (!contains(permissionChecker, entry, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long entryId,
            String actionId)
            throws PortalException, SystemException {

      //  GuestbookEntry entry = GuestbookEntryLocalServiceUtil.fetchGuestbookEntry(entryId);
        Guestbook guestbook = GuestbookLocalServiceUtil.fetchGuestbook(entryId);
        System.out.println("GuestbookPermission.contains: entryId=" + entryId + ", entry=" + guestbook);

        return contains(permissionChecker, guestbook, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, Guestbook entry,
            String actionId)
            throws PortalException, SystemException {

        return permissionChecker.hasPermission(
                entry.getGroupId(), Guestbook.class.getName(),
                entry.getGuestbookId(), actionId);
    }
}
