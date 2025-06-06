package com.liferay.docs.guestbook.search;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.GuestbookLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;



@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.docs.guestbook.model.Guestbook",
        service = ModelIndexerWriterContributor.class
)
public class GuestbookModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<Guestbook> {


    public GuestbookModelIndexerWriterContributor(
            GuestbookLocalService guestbookLocalService,
            DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory) {

        this.guestbookLocalService = guestbookLocalService;
        this.dynamicQueryBatchIndexingActionableFactory = dynamicQueryBatchIndexingActionableFactory;
    }

    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod((Guestbook guestbook) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(guestbook);
            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
                guestbookLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Guestbook guestbook) {
        return guestbook.getCompanyId();
    }

    @Override
    public void modelIndexed(Guestbook guestbook) {
        guestbookEntryBatchReindexer.reindex(
                guestbook.getGuestbookId(), guestbook.getCompanyId());
    }


    @Reference
    protected GuestbookEntryBatchReindexer guestbookEntryBatchReindexer;

    private final GuestbookLocalService guestbookLocalService;
    private final DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

}


//@Component(
//        immediate = true,
//        property = "indexer.class.name=com.liferay.docs.guestbook.model.Guestbook",
//        service = ModelIndexerWriterContributor.class
//)
//public class GuestbookModelIndexerWriterContributor
//        implements ModelIndexerWriterContributor<Guestbook> {
//
//    public GuestbookModelIndexerWriterContributor(
//            GuestbookLocalService guestbookLocalService,
//            DynamicQueryBatchIndexingActionableFactory
//                    dynamicQueryBatchIndexingActionableFactory) {
//
//        this.guestbookLocalService = guestbookLocalService;
//        _dynamicQueryBatchIndexingActionableFactory =
//                dynamicQueryBatchIndexingActionableFactory;
//    }
//
//    @Override
//    public void customize(
//            BatchIndexingActionable batchIndexingActionable,
//            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
//
//        batchIndexingActionable.setPerformActionMethod((Guestbook guestbook) -> {
//            Document document = modelIndexerWriterDocumentHelper.getDocument(
//                    guestbook);
//
//            batchIndexingActionable.addDocuments(document);
//        });
//    }
//
//    @Override
//    public BatchIndexingActionable getBatchIndexingActionable() {
//        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
//                guestbookLocalService.getIndexableActionableDynamicQuery());
//    }
//
//    @Override
//    public long getCompanyId(Guestbook guestbook) {
//        return guestbook.getCompanyId();
//    }
//
//    @Override
//    public void modelIndexed(Guestbook guestbook) {
//        guestbookEntryBatchReindexer.reindex(
//                guestbook.getGuestbookId(), guestbook.getCompanyId());
//    }
//
//    @Reference
//    protected DynamicQueryBatchIndexingActionableFactory
//            dynamicQueryBatchIndexingActionableFactory;
//
//    @Reference
//    protected GuestbookEntryBatchReindexer guestbookEntryBatchReindexer;
//
//    @Reference
//    protected GuestbookLocalService guestbookLocalService;
//   // private final GuestbookLocalService guestbookLocalService;
//    private final DynamicQueryBatchIndexingActionableFactory
//            _dynamicQueryBatchIndexingActionableFactory;
//
//}
