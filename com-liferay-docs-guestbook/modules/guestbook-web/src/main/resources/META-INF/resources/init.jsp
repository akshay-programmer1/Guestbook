<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>


<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>
<%@ taglib uri="http://liferay.com/tld/expando" prefix="liferay-expando" %>
<%@ taglib uri="http://liferay.com/tld/react" prefix="react" %>
<%@ taglib uri="http://liferay.com/tld/site-navigation" prefix="liferay-site-navigation" %>
<%@ taglib uri="http://liferay.com/tld/text-localizer" prefix="liferay-text-localizer" %>
<%@ taglib uri="http://liferay.com/tld/user" prefix="liferay-user" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>


<%@ page import="com.liferay.docs.guestbook.internal.security.GuestbookPermission" %>


<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.model.PersistedModel" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.docs.guestbook.model.Guestbook" %>
<%@ page import="com.liferay.docs.guestbook.service.GuestbookEntryLocalServiceUtil" %>
<%@ page import="com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil" %>
<%@ page import="com.liferay.docs.guestbook.model.GuestbookEntry" %>


<%@ page import="com.liferay.docs.guestbook.constants.dao.search.GuestbookSearchContainerFactory" %>
<%@ page import="com.liferay.docs.guestbook.constants.dao.search.EntrySearchContainerFactory" %>
<%@ page import="com.liferay.docs.guestbook.internal.security.GuestbookPermission" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.docs.guestbook.constants.display.context.GuestBookDisplayContext" %>
<%@ page import="com.liferay.docs.guestbook.constants.display.context.EntryDisplayContext" %>
<%@ page import="com.liferay.docs.guestbook.service.*" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-frontend:defineObjects />

<liferay-ui:success key="entryAdded" message="entry-added" />
<liferay-ui:success key="entryDeleted" message="entry-deleted" />