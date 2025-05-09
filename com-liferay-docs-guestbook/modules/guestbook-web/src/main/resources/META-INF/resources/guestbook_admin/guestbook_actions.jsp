<%@include file="../init.jsp"%>

<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");

    ResultRow row = (ResultRow) request
                    .getAttribute("SEARCH_CONTAINER_RESULT_ROW");
    Guestbook guestbook = (Guestbook) row.getObject();
%>

<liferay-ui:icon-menu>
    <portlet:renderURL var="editURL">
        <portlet:param name="guestbookId"
            value="<%=String.valueOf(guestbook.getGuestbookId()) %>" />
        <portlet:param name="mvcPath"
            value="/guestbook_admin/edit_guestbook.jsp" />
    </portlet:renderURL>


<c:if test="<%= GuestbookPermission.contains(permissionChecker,43114, \"Guestbook_DELETE_OK\") %>">

        <liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />

</c:if>



    <portlet:actionURL name="deleteGuestbook" var="deleteURL">
            <portlet:param name="guestbookId"
                value="<%= String.valueOf(guestbook.getGuestbookId()) %>" />

    </portlet:actionURL>
<c:if test="<%= GuestbookPermission.contains(permissionChecker,43114, \"Guestbook_DELETE_OK\") %>">

       <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</c:if>
</liferay-ui:icon-menu>