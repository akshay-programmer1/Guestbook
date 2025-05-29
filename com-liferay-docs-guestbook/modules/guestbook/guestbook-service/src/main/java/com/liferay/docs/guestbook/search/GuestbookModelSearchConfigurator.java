package com.liferay.docs.guestbook.search;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.GuestbookLocalService;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.registrar.ModelSearchConfigurator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(service = ModelSearchConfigurator.class)
public class GuestbookModelSearchConfigurator
        implements ModelSearchConfigurator<Guestbook> {

    @Override
    public String getClassName() {
        return Guestbook.class.getName();
    }

    @Override
    public String[] getDefaultSelectedFieldNames() {
        return new String[] {
                Field.COMPANY_ID, Field.SCOPE_GROUP_ID, Field.NAME,
                Field.UID
        };
    }

    @Override
    public ModelIndexerWriterContributor<Guestbook>
    getModelIndexerWriterContributor() {

        return _modelIndexWriterContributor;
    }

    @Override
    public boolean isSearchResultPermissionFilterSuppressed() {
        return true;
    }

    @Activate
    protected void activate() {
        _modelIndexWriterContributor =
                new GuestbookModelIndexerWriterContributor(
                        guestbookLocalService,
                        _dynamicQueryBatchIndexingActionableFactory);
    }

    @Reference
    private GuestbookLocalService guestbookLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory
            _dynamicQueryBatchIndexingActionableFactory;

    private ModelIndexerWriterContributor<Guestbook>
            _modelIndexWriterContributor;

}