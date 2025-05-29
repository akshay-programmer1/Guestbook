<%@ include file="../init.jsp" %>

<portlet:actionURL name="addGuestbook" var="addGuestbookURL" />

<aui:form action="<%= addGuestbookURL %>" method="post" name="fm">
<%= "DEBUG: Button section reached addGuestbook" %>

    <aui:fieldset>
        <aui:input name="name" label="Guestbook Name" />
        <aui:input name="description" label="Description" />
    </aui:fieldset>

    <aui:button-row>


    <c:if test="<%= GuestbookPermission.contains(permissionChecker,43114, \"Guestbook_ADD_OK\") %>">

        <aui:button type="submit" value="Save" />

        </c:if>
        <aui:button type="cancel" value="Cancel" onClick="location.href='<%= themeDisplay.getURLCurrent() %>'" />
    </aui:button-row>
</aui:form>
