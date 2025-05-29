package com.liferay.docs.guestbook.constants.dao.search;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.GuestbookLocalService;
import com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil;
import com.liferay.docs.guestbook.service.base.GuestbookLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import javax.servlet.http.HttpServletRequest;

public class GuestbookSearchContainerFactory {

    public static SearchContainer<Guestbook> create(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse)
            throws PortalException {

        SearchContainer<Guestbook> searchContainer = new SearchContainer<>(liferayPortletRequest,
                PortletURLUtil.getCurrent(
                        liferayPortletRequest, liferayPortletResponse),
                null, "no-entries-found");

        System.out.println("-----------------------------------------------------------------------");
        String keywords = ParamUtil.getString(
                liferayPortletRequest, "keywords");


        BaseModelSearchResult<Guestbook> guestbooks = GuestbookLocalServiceUtil.searchGuestbookEntries(
                CompanyThreadLocal.getCompanyId(), keywords,
                searchContainer.getStart(),
                searchContainer.getDelta());


        System.out.println(guestbooks.getBaseModels().size());

        System.out.println("-----------------------------Total------------------------------------------");



        for(Guestbook g : guestbooks.getBaseModels()){
            System.out.print("----------------------------------------------------------------------------------------------" +
                    "-----------------");
            System.out.println(g.getName());
        }


        searchContainer.setResultsAndTotal(guestbooks);


        return searchContainer;
    }
}









//package com.liferay.docs.guestbook.constants.dao.search;
//
//
//import com.liferay.docs.guestbook.model.Guestbook;
//import com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil;
//import com.liferay.portal.kernel.dao.search.SearchContainer;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
//import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
//import com.liferay.portal.kernel.portlet.PortletURLUtil;
//import com.liferay.portal.kernel.search.BaseModelSearchResult;
//import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.contacts.service.EntryLocalServiceUtil;
//
//
//public class GuestbookSearchContainerFactory {
//
//    public static SearchContainer<Guestbook> create(
//            LiferayPortletRequest liferayPortletRequest,
//            LiferayPortletResponse liferayPortletResponse)
//            throws PortalException {
//
//        SearchContainer<Guestbook> searchContainer = new SearchContainer<>(liferayPortletRequest,
//                PortletURLUtil.getCurrent(
//                        liferayPortletRequest, liferayPortletResponse),
//                null, "no-entries-found");
//
//        String keywords = ParamUtil.getString(
//                liferayPortletRequest, "keywords");
//
//
//        BaseModelSearchResult<Guestbook> guestbooks =  GuestbookLocalServiceUtil.searchGuestbookEntries(
//                CompanyThreadLocal.getCompanyId(), keywords,
//                searchContainer.getStart(),
//                searchContainer.getDelta());
//
//        searchContainer.setResultsAndTotal(guestbooks);
//
//        return searchContainer;
//    }
//}