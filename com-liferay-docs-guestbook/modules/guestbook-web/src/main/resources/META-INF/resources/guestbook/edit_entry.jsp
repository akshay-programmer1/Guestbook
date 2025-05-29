<%@ include file="../init.jsp" %>

<%
long entryId = ParamUtil.getLong(renderRequest, "entryId");
GuestbookEntry entry = null;

if (entryId > 0) {
    try {
        entry = GuestbookEntryLocalServiceUtil.getGuestbookEntry(entryId);
    } catch (Exception e) {
        entry = null;
    }
}

long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/guestbook/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addEntry" var="editEntryURL" />

<aui:form action="<%= editEntryURL %>" name="<portlet:namespace />fm">
    <aui:model-context bean="<%= entry %>" model="<%= GuestbookEntry.class %>" />

    <aui:fieldset>
        <aui:input name="name" />
        <aui:input name="email" />
        <aui:input name="message" />
        <aui:input name="entryId" type="hidden" value="<%= entry != null ? entry.getEntryId() : 0 %>" />
        <aui:input name="guestbookId" type="hidden" value="<%= guestbookId %>" />
    </aui:fieldset>



    <aui:button-row>

        <aui:button type="submit" value="Save" />

        <aui:button type="cancel" value="Cancel" onClick="location.href='<%= viewURL.toString() %>'" />
    </aui:button-row>
</aui:form>
