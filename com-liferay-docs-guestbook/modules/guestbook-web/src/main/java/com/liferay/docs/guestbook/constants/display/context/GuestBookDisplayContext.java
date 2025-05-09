//package com.liferay.docs.guestbook.constants.display.context;
//
//import com.liferay.docs.guestbook.model.Guestbook;
//import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
//import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
//import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
//import com.liferay.petra.string.StringPool;
//import com.liferay.portal.kernel.dao.search.SearchContainer;
//import com.liferay.portal.kernel.language.LanguageUtil;
//import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
//import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
//import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class GuestBookDisplayContext
//        extends SearchContainerManagementToolbarDisplayContext {
//
//    private ThemeDisplay _themeDisplay;
//
//    public GuestBookDisplayContext(
//            HttpServletRequest httpServletRequest,
//            LiferayPortletRequest liferayPortletRequest,
//            LiferayPortletResponse liferayPortletResponse,
//            SearchContainer<Guestbook> searchContainer, ThemeDisplay themeDisplay) {
//
//        super(
//                httpServletRequest, liferayPortletRequest, liferayPortletResponse,
//                searchContainer);
//        this._themeDisplay = themeDisplay;
//    }
//
//    @Override
//    public CreationMenu getCreationMenu() {
//        return CreationMenuBuilder.addPrimaryDropdownItem(
//                dropdownItem -> {
//                    dropdownItem.setHref(
//                            liferayPortletResponse.createRenderURL(),
//                            "mvcRenderCommandName", "/guestbook/add", "backURL",
//                            currentURLObj.toString());
//                    dropdownItem.setLabel(
//                            LanguageUtil.get(httpServletRequest, "add-guestbook"));
//                }
//        ).build();
//    }
//
//    @Override
//    public String getClearResultsURL() {
//        return PortletURLBuilder.create(
//                getPortletURL()
//        ).setKeywords(
//                StringPool.BLANK
//        ).buildString();
//    }
//
//    @Override
//    public String getSearchActionURL() {
//        return getPortletURL().toString();
//    }
//
//    @Override
//    public String getSearchFormName() {
//        return "searchFm";
//    }
//}





package com.liferay.docs.guestbook.constants.display.context;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;


import javax.servlet.http.HttpServletRequest;

public class GuestBookDisplayContext
        extends SearchContainerManagementToolbarDisplayContext {

    private ThemeDisplay _themeDisplay;

    public GuestBookDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer<Guestbook> searchContainer, ThemeDisplay themeDisplay) {

        super(
                httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                searchContainer);
        this._themeDisplay = themeDisplay;
    }

    @Override
    public CreationMenu getCreationMenu() {
        return CreationMenuBuilder.addPrimaryDropdownItem(
                dropdownItem -> {
                    dropdownItem.setHref(
                            liferayPortletResponse.createRenderURL(),
                            "mvcRenderCommandName", "/guestbook/add", "backURL",
                            currentURLObj.toString());
                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "add-guestbook"));
                }
        ).build();
    }

    @Override
    public String getClearResultsURL() {
        return PortletURLBuilder.create(
                getPortletURL()
        ).setKeywords(
                StringPool.BLANK
        ).buildString();
    }
}