package com.liferay.docs.guestbook.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.docs.guestbook.constants.GuestbookPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=300",
                "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
        },
        service = PanelApp.class
)
public class GuestbookAdminPanelApp extends BasePanelApp {

        private Portlet _portlet;

        @Override
        public String getPortletId() {
                return GuestbookPortletKeys.GUESTBOOK;
        }

        @Override
        public Portlet getPortlet() {
                return _portlet;
        }

        @Reference(
                target = "(javax.portlet.name=" + GuestbookPortletKeys.GUESTBOOK + ")",
                unbind = "-"
        )
        public void setPortlet(Portlet portlet) {
                _portlet = portlet;
        }







//                @Override
//                public String getPortletId() {
//                        return GuestbookPortletKeys.GUESTBOOK_ADMIN;
//                }
//
//                @Override
//                @Reference(
//                        target = "(javax.portlet.name=" + GuestbookPortletKeys.GUESTBOOK_ADMIN + ")",
//                        unbind = "-"
//                )
//                public void setPortlet(Portlet portlet) {
//                        super.setPortlet(portlet);
//                }


}
