
<%@include file="../init.jsp"%>

<%
   SearchContainer<Guestbook> guestbookSearchContainer = GuestbookSearchContainerFactory.create(liferayPortletRequest, liferayPortletResponse);

%>

<clay:management-toolbar
	managementToolbarDisplayContext="<%= new GuestBookDisplayContext(request, liferayPortletRequest, liferayPortletResponse, guestbookSearchContainer, themeDisplay) %>"
/>



<liferay-ui:search-container
			searchContainer="<%=guestbookSearchContainer %>"
		>
                <liferay-ui:search-container-row
                    className="com.liferay.docs.guestbook.model.Guestbook"
                    keyProperty="guestbookId"
                    modelVar="guestbook"
                >

				<liferay-ui:search-container-column-text property="name" />
				<liferay-ui:search-container-column-jsp

        align="right"
					path="/guestbook_action.jsp"
				/>
			</liferay-ui:search-container-row>

		 <liferay-ui:search-iterator />
		</liferay-ui:search-container>








