/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.docs.guestbook.service.impl;

import com.liferay.contacts.model.Entry;
import com.liferay.docs.guestbook.exception.GuestbookNameException;
import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.docs.guestbook.service.GuestbookEntryLocalService;
import com.liferay.docs.guestbook.service.base.GuestbookLocalServiceBaseImpl;
import com.liferay.petra.function.transform.TransformUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.searcher.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liferay
 */
@Component(
	property = "model.class.name=com.liferay.docs.guestbook.model.Guestbook",
	service = AopService.class
)
public class GuestbookLocalServiceImpl extends GuestbookLocalServiceBaseImpl {

	@Reference
	private Searcher _searcher;

	@Reference
	private SearchRequestBuilderFactory _searchRequestBuilderFactory;


//	public static BaseModelSearchResult<GuestbookEntry> searchEntries(
//            long companyId, String keywords, int start, int end, long guestbookId)
//			throws PortalException {
//
//		DynamicQuery dynamicQuery = dynamicQuery();
//		dynamicQuery.add(RestrictionsFactoryUtil.eq("guestbookId", guestbookId));
//
//		if (Validator.isNotNull(keywords)) {
//			dynamicQuery.add(
//					RestrictionsFactoryUtil.or(
//							RestrictionsFactoryUtil.ilike("name", "%" + keywords + "%"),
//							RestrictionsFactoryUtil.ilike("message", "%" + keywords + "%")
//					)
//			);
//		}
//
//		long total = dynamicQueryCount (dynamicQuery);
//		List<GuestbookEntry> results = dynamicQuery(dynamicQuery, start, end);
//
//		// Correct way to set results and total
//		BaseModelSearchResult<GuestbookEntry> searchResult =
//				new BaseModelSearchResult<>(results, total);
//
//		return searchResult;
//	}

	public BaseModelSearchResult<GuestbookEntry> searchEntries(
			long companyId, String keywords, int start, int end, long guestbookId)
			throws PortalException {

		DynamicQuery dynamicQuery = dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("guestbookId", guestbookId));

		if (Validator.isNotNull(keywords)) {
			dynamicQuery.add(
					RestrictionsFactoryUtil.or(
							RestrictionsFactoryUtil.ilike("name", "%" + keywords + "%"),
							RestrictionsFactoryUtil.ilike("message", "%" + keywords + "%")
					)
			);
		}

		long total = dynamicQueryCount(dynamicQuery);
		List<GuestbookEntry> results = dynamicQuery(dynamicQuery, start, end);

		// Correct way to set results and total
		BaseModelSearchResult<GuestbookEntry> searchResult = new BaseModelSearchResult<>(results, total);

		return searchResult;
	}



	@Indexable(type = IndexableType.REINDEX)
	public Guestbook addGuestbook(String name, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		validate(name);

		long guestbookId = counterLocalService.increment();

		Guestbook guestbook = guestbookPersistence.create(guestbookId);
		guestbook.setUuid(serviceContext.getUuid());
		guestbook.setUserId(userId);
		guestbook.setGroupId(groupId);
		guestbook.setCompanyId(user.getCompanyId());
		guestbook.setUserName(user.getFullName());
		guestbook.setCreateDate(serviceContext.getCreateDate(now));
		guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbook.setName(name);
		guestbook.setExpandoBridgeAttributes(serviceContext);

		guestbookPersistence.update(guestbook);
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				Guestbook.class.getName(), guestbookId, false, true, true);
		return guestbook;

	}


	public List<Guestbook> getGuestbooks(long groupId) {
		return guestbookPersistence.findByGroupId(groupId);
	}

	public List<Guestbook> getGuestbooks(long groupId, int start, int end) {
		return guestbookPersistence.findByGroupId(groupId, start, end);
	}

	public List<Guestbook> getGuestbooks(long groupId, int start, int end, OrderByComparator<Guestbook> obc) {
		return guestbookPersistence.findByGroupId(groupId, start, end, obc);
	}

	public int getGuestbooksCount(long groupId) {
		return guestbookPersistence.countByGroupId(groupId);
	}

//	@Override
//	public Guestbook addGuestbook(long groupId, long guestbookId, ServiceContext serviceContext) {
//		return null;
//	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new GuestbookNameException();
		}
	}

	@Indexable(type = IndexableType.REINDEX)
	public Guestbook updateGuestbook(long userId, long guestbookId,
									 String name, ServiceContext serviceContext) throws PortalException,
			SystemException {

		Date now = new Date();

		validate(name);

		Guestbook guestbook = getGuestbook(guestbookId);

		User user = userLocalService.getUser(userId);

		guestbook.setUserId(userId);
		guestbook.setUserName(user.getFullName());
		guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbook.setName(name);
		guestbook.setExpandoBridgeAttributes(serviceContext);

		guestbookPersistence.update(guestbook);

		resourceLocalService.updateResources(serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(),
				Guestbook.class.getName(), guestbookId,
				serviceContext.getModelPermissions());
		return guestbook;
	}

	/**
	 * @param companyId
	 * @param keywords
	 * @param start
	 * @param delta
	 * @return
	 */
	@Override
	public BaseModelSearchResult<Guestbook> searchGuestbookEntries(
			Long companyId, String keywords, int start, int delta) {

		try {
			SearchContext searchContext = new SearchContext();

			searchContext.setCompanyId(companyId);
			searchContext.setKeywords(keywords);
			searchContext.setStart(start);
			searchContext.setEnd(start + delta);

			Indexer<Guestbook> indexer = IndexerRegistryUtil.getIndexer(Guestbook.class);

			Hits hits = indexer.search(searchContext);

			List<Guestbook> guestbooks = new ArrayList<>();
			for (Document document : hits.getDocs()) {
				long guestbookId = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));
				Guestbook guestbook = fetchGuestbook(guestbookId);

				if (guestbook != null) {
					guestbooks.add(guestbook);
				}
			}

			return new BaseModelSearchResult<>(guestbooks, hits.getLength());

		} catch (SearchException e) {
			throw new SystemException("Unable to perform search on guestbooks", e);
		}
	}




	@Reference
	private GuestbookEntryLocalService guestbookEntryLocalService;
	@Indexable(type = IndexableType.DELETE)

	public Guestbook deleteGuestbook(long guestbookId,
									 ServiceContext serviceContext) throws PortalException,
			SystemException {

		Guestbook guestbook = getGuestbook(guestbookId);

		List<GuestbookEntry> entries = _guestbookEntryLocalService.getGuestbookEntries(
				serviceContext.getScopeGroupId(), guestbookId);

		for (GuestbookEntry entry : entries) {
			_guestbookEntryLocalService.deleteGuestbookEntry(entry.getEntryId());
		}

		guestbook = deleteGuestbook(guestbook);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				Guestbook.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				guestbookId);

		return guestbook;
	}


	@Reference
	private GuestbookEntryLocalService _guestbookEntryLocalService;


	@Override
	public BaseModelSearchResult<Guestbook> searchGuestbookEntries(
			long companyId, String keywords,
			int cur, int delta) {

		SearchResponse searchResponse = _searcher.search(
				_getSearchRequest(
						companyId, keywords, cur, delta));
		SearchHits searchHits = searchResponse.getSearchHits();

		List<Guestbook> accountEntries = TransformUtil.transform(
				searchHits.getSearchHits(),
				searchHit -> {
					com.liferay.portal.search.document.Document document =  searchHit.getDocument();

					long accountEntryId = document.getLong(Field.ENTRY_CLASS_PK);

					Guestbook guestbook = fetchGuestbook(accountEntryId);

					if (guestbook == null) {
						Indexer<Guestbook> indexer =
								IndexerRegistryUtil.getIndexer(Guestbook.class);

						indexer.delete(
								document.getLong(Field.COMPANY_ID),
								document.getString(Field.UID));
					}
					return guestbook;
				});

		return new BaseModelSearchResult<>(
				accountEntries, searchResponse.getTotalHits());
	}


	private SearchRequest _getSearchRequest(
			long companyId, String keywords,
			int cur, int delta) {

		SearchRequestBuilder searchRequestBuilder =
				_searchRequestBuilderFactory.builder();

		searchRequestBuilder.entryClassNames(
				Guestbook.class.getName()
		).emptySearchEnabled(
				true
		).highlightEnabled(
				false
		).withSearchContext(
				searchContext -> _populateSearchContext(
						searchContext, companyId, keywords)
		);

		searchRequestBuilder.from(cur);
		searchRequestBuilder.size(delta);

		return searchRequestBuilder.build();
	}

	private void _populateSearchContext(
			SearchContext searchContext, long companyId, String keywords) {

		searchContext.setCompanyId(companyId);

		if (Validator.isNotNull(keywords)) {
			searchContext.setKeywords(keywords);
		}
	}
}