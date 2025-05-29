package com.liferay.docs.guestbook.search;

import com.liferay.contacts.model.Entry;
import com.liferay.contacts.service.EntryLocalService;
//import com.liferay.docs.guestbook.demo.search.spi.model.index.contributor.EntryModelIndexerWriterContributor;
import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.docs.guestbook.service.GuestbookEntryLocalService;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchConfigurator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ModelSearchConfigurator.class)
public class EntryModelSearchConfigurator implements ModelSearchConfigurator<GuestbookEntry> {


    @Override
    public String getClassName() {
        return GuestbookEntry.class.getName();
    }

    @Override
    public String[] getDefaultSelectedFieldNames() {
        return new String[] {
                Field.COMPANY_ID, Field.SCOPE_GROUP_ID, Field.NAME,
                Field.UID, "guestbookId"
        };
    }

    @Override
    public ModelIndexerWriterContributor<GuestbookEntry>
    getModelIndexerWriterContributor() {

        return guestbookEntryModelIndexerWriterContributor;
    }

    @Override
    public boolean isSearchResultPermissionFilterSuppressed() {
        return true;
    }

    @Activate
    protected void activate() {
        guestbookEntryModelIndexerWriterContributor =
                new GuestbookEntryModelIndexerWriterContributor(
                        guestbookEntryLocalService,
                        _dynamicQueryBatchIndexingActionableFactory);
    }

    @Reference
    private GuestbookEntryLocalService guestbookEntryLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory
            _dynamicQueryBatchIndexingActionableFactory;

    private GuestbookEntryModelIndexerWriterContributor
            guestbookEntryModelIndexerWriterContributor;
}
