package com.liferay.docs.guestbook.search;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.GuestbookLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.docs.guestbook.model.Guestbook",
        service = ModelDocumentContributor.class
)
public class GuestbookModelDocumentContributor
        implements ModelDocumentContributor<Guestbook> {

@Override
    public void contribute(Document document, Guestbook guestbook) {
        try {
            document.addDate(Field.MODIFIED_DATE, guestbook.getModifiedDate());

            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(
                    guestbook.getGroupId());

            String localizedTitle = LocalizationUtil.getLocalizedName(
                    Field.TITLE, defaultLocale.toString());

            document.addText(localizedTitle, guestbook.getName());
            document.addNumber(Field.SCOPE_GROUP_ID, guestbook.getGroupId());
        } catch (PortalException pe) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                        "Unable to index guestbook " + guestbook.getGuestbookId(), pe);
            }
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(
            GuestbookModelDocumentContributor.class);

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected GuestbookEntryBatchReindexer guestbookEntryBatchReindexer;

    @Reference
    protected GuestbookLocalService guestbookLocalService;

   // private final GuestbookLocalService guestbookLocalService;
//    private final DynamicQueryBatchIndexingActionableFactory
//            _dynamicQueryBatchIndexingActionableFactory;

}