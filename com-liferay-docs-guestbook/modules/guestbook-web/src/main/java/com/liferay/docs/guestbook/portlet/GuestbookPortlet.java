	package com.liferay.docs.guestbook.portlet;

	import com.liferay.docs.guestbook.constants.GuestbookPortletKeys;

	import com.liferay.docs.guestbook.service.GuestbookEntryLocalService;
	import com.liferay.docs.guestbook.service.GuestbookLocalService;
	import com.liferay.portal.kernel.dao.orm.DynamicQuery;
	import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
	import com.liferay.portal.kernel.exception.PortalException;
	import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
	import com.liferay.docs.guestbook.model.Guestbook;
	import com.liferay.docs.guestbook.model.GuestbookEntry;

	import com.liferay.docs.guestbook.service.GuestbookEntryLocalServiceUtil;
	import com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil;

	import com.liferay.portal.kernel.service.ServiceContext;
	import com.liferay.portal.kernel.service.ServiceContextFactory;
	import com.liferay.portal.kernel.servlet.SessionErrors;
	import com.liferay.portal.kernel.servlet.SessionMessages;
	import com.liferay.portal.kernel.util.ParamUtil;

	import java.io.IOException;
	import java.util.List;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import javax.portlet.*;


	import com.liferay.portal.kernel.util.PortalUtil;
	import org.osgi.service.component.annotations.Component;
	import org.osgi.service.component.annotations.Reference;

	import com.liferay.portal.kernel.dao.orm.DynamicQuery;
	import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
	import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
	/**
	 * @author ADMIN
	 */
	@Component(
		property = {
			"com.liferay.portlet.display-category=category.social",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Guestbook",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/guestbook/view.jsp",
			"javax.portlet.name=" + GuestbookPortletKeys.GUESTBOOK,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
	public class GuestbookPortlet extends MVCPortlet {
		@Reference
		private GuestbookEntryLocalService _guestbookEntryLocalService;

		@Reference
		private GuestbookLocalService _guestbookLocalService;

		public void addGuestbook(ActionRequest request, ActionResponse response)
				throws IOException, PortletException {

			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(
						Guestbook.class.getName(), request);

			//ong groupId = 20117;
			//ong userId = 20123;
				String name = ParamUtil.getString(request, "name");
				long groupId = serviceContext.getScopeGroupId();
				long userId = serviceContext.getUserId();
				Guestbook guestbook = _guestbookLocalService.addGuestbook(name,serviceContext);
System.out.println("Group Id  in add guest is"+groupId);
System.out.println("UserId is in add guest is"+userId);
				System.out.println("=================================================================================================================================================================");
				// Optionally, you can redirect or set render parameters
				response.setRenderParameter("mvcPath", "/guestbook/view.jsp");
				SessionMessages.add(request, "entryAdded");
			} catch (Exception e) {
				System.out.println(e);
				SessionErrors.add(request, e.getClass().getName());
				throw new PortletException(e);

			}
		}





			@Override
			public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {

			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(
						Guestbook.class.getName(), renderRequest);

				long groupId = 20117;//serviceContext.getScopeGroupId();
				long guestbookId = 43114;//ParamUtil.getLong(renderRequest, "guestbookId");

				List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(groupId);
				List<GuestbookEntry> guestbookEntries =
						GuestbookEntryLocalServiceUtil.getGuestbookEntries(groupId, guestbookId);

				renderRequest.setAttribute("guestbookId", guestbookId);
				renderRequest.setAttribute("guestbooks", guestbooks);
				renderRequest.setAttribute("guestbookEntries", guestbookEntries);


				System.out.println("Guestbook ID: " + guestbookId);
				System.out.println("Total Guestbooks: " + guestbooks.size());

			} catch (Exception e) {
				throw new PortletException(e);
			}

			super.doView(renderRequest, renderResponse);
		}







		public void addEntry(ActionRequest request, ActionResponse response)
				throws PortalException {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					GuestbookEntry.class.getName(), request);

			String userName = ParamUtil.getString(request, "name");
			String email = ParamUtil.getString(request, "email");
			String message = ParamUtil.getString(request, "message");
			long guestbookId = ParamUtil.getLong(request, "guestbookId");
			long entryId = ParamUtil.getLong(request, "entryId");

			if (entryId > 0) {

				try {

					_guestbookEntryLocalService.updateGuestbookEntry(
							serviceContext.getUserId(), guestbookId, entryId, userName,
							email, message, serviceContext);

					response.setRenderParameter(
							"guestbookId", Long.toString(guestbookId));

				}
				catch (Exception e) {
					System.out.println(e);

					PortalUtil.copyRequestParameters(request, response);

					response.setRenderParameter(
							"mvcPath", "/guestbook/edit_entry.jsp");
				}

			}
			else {

				try {
					System.out.println("Guestbook ID:entered:------------------------------ " + guestbookId);
					_guestbookEntryLocalService.addGuestbookEntry(
							serviceContext.getUserId(), guestbookId, userName, email,
							message, serviceContext);

					response.setRenderParameter(
							"guestbookId", Long.toString(guestbookId));

				}
				catch (Exception e) {
					System.out.println(e);

					PortalUtil.copyRequestParameters(request, response);

					response.setRenderParameter(
							"mvcPath", "/guestbook/edit_entry.jsp");
				}
			}
		}








		public void deleteEntry(ActionRequest request, ActionResponse response) throws PortalException {
			long entryId = ParamUtil.getLong(request, "entryId");
			long guestbookId = ParamUtil.getLong(request, "guestbookId");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					GuestbookEntry.class.getName(), request);

			try {

				response.setRenderParameter(
						"guestbookId", Long.toString(guestbookId));

				_guestbookEntryLocalService.deleteGuestbookEntry(entryId);
			}

			catch (Exception e) {
				Logger.getLogger(GuestbookPortlet.class.getName()).log(
						Level.SEVERE, null, e);
			}
		}








		@Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {

			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(
						Guestbook.class.getName(), renderRequest);

				long groupId = serviceContext.getScopeGroupId();

				long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");

				List<Guestbook> guestbooks = _guestbookLocalService.getGuestbooks(
						groupId);

//				if (guestbooks.isEmpty()) {
//					Guestbook guestbook = _guestbookLocalService.addGuestbook(
//							serviceContext.getUserId(), "Main", serviceContext);
//
//					guestbookId = guestbook.getGuestbookId();
//				}

				if (guestbookId == 0) {
					guestbookId = guestbooks.get(0).getGuestbookId();
				}

				renderRequest.setAttribute("guestbookId", guestbookId);
			}
			catch (Exception e) {
				throw new PortletException(e);
			}

			super.render(renderRequest, renderResponse);
		}

	}