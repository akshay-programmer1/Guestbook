package com.liferay.docs.guestbook.constants.dao.search;
import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.docs.guestbook.service.GuestbookEntryLocalServiceUtil;

public class EntrySearchContainerFactory {

    public static SearchContainer<GuestbookEntry> create(
                                                          LiferayPortletRequest liferayPortletRequest,
                                                          LiferayPortletResponse liferayPortletResponse, long guestbookId)
            throws PortalException {

        SearchContainer<GuestbookEntry> searchContainer = new SearchContainer<>( // Corrected type
                liferayPortletRequest,
                PortletURLUtil.getCurrent(
                        liferayPortletRequest, liferayPortletResponse),
                null, "no-entries-found");

        String keywords = ParamUtil.getString(
                liferayPortletRequest, "keywords");

        BaseModelSearchResult<GuestbookEntry> entries = GuestbookEntryLocalServiceUtil.searchEntries( // Corrected call
                CompanyThreadLocal.getCompanyId(), keywords,
                searchContainer.getStart(),
                searchContainer.getDelta(), guestbookId);

        searchContainer.setResultsAndTotal(entries);

        return searchContainer;
    }

    public static void main(String[] args) {
    }


}
