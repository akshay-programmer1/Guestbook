package com.liferay.docs.guestbook.constants.display.context;

import com.liferay.contacts.model.Entry;
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

public class EntryDisplayContext   extends SearchContainerManagementToolbarDisplayContext {

    private ThemeDisplay _themeDisplay;
    private long guestbookId;

    public EntryDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer<Entry> searchContainer, ThemeDisplay themeDisplay , long guestbookId) {

        super(
                httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                searchContainer);
        this._themeDisplay = themeDisplay;
        this.guestbookId = guestbookId;
    }

    @Override
    public CreationMenu getCreationMenu() {
        return CreationMenuBuilder.addPrimaryDropdownItem(
                dropdownItem -> {
                    dropdownItem.setHref(
                            liferayPortletResponse.createRenderURL(),
                            "mvcRenderCommandName", "/entry/addEntry", "backURL",
                            currentURLObj.toString() , "guestbookId", this.guestbookId , "currentURL", currentURLObj.toString());
                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "add-entry"));
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