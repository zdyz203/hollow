package com.netflix.vms.transformer.input.api.gen.packageDealCountry;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.index.AbstractHollowUniqueKeyIndex;
import com.netflix.hollow.api.consumer.index.HollowUniqueKeyIndex;
import com.netflix.hollow.core.schema.HollowObjectSchema;

/**
 * @deprecated see {@link com.netflix.hollow.api.consumer.index.UniqueKeyIndex} which can be built as follows:
 * <pre>{@code
 *     UniqueKeyIndex<PackageMovieDealCountryGroup, K> uki = UniqueKeyIndex.from(consumer, PackageMovieDealCountryGroup.class)
 *         .usingBean(k);
 *     PackageMovieDealCountryGroup m = uki.findMatch(k);
 * }</pre>
 * where {@code K} is a class declaring key field paths members, annotated with
 * {@link com.netflix.hollow.api.consumer.index.FieldPath}, and {@code k} is an instance of
 * {@code K} that is the key to find the unique {@code PackageMovieDealCountryGroup} object.
 */
@Deprecated
@SuppressWarnings("all")
public class PackageMovieDealCountryGroupPrimaryKeyIndex extends AbstractHollowUniqueKeyIndex<PackageDealCountryAPI, PackageMovieDealCountryGroup> implements HollowUniqueKeyIndex<PackageMovieDealCountryGroup> {

    public PackageMovieDealCountryGroupPrimaryKeyIndex(HollowConsumer consumer) {
        this(consumer, true);
    }

    public PackageMovieDealCountryGroupPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefresh) {
        this(consumer, isListenToDataRefresh, ((HollowObjectSchema)consumer.getStateEngine().getNonNullSchema("PackageMovieDealCountryGroup")).getPrimaryKey().getFieldPaths());
    }

    public PackageMovieDealCountryGroupPrimaryKeyIndex(HollowConsumer consumer, String... fieldPaths) {
        this(consumer, true, fieldPaths);
    }

    public PackageMovieDealCountryGroupPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefresh, String... fieldPaths) {
        super(consumer, "PackageMovieDealCountryGroup", isListenToDataRefresh, fieldPaths);
    }

    @Override
    public PackageMovieDealCountryGroup findMatch(Object... keys) {
        int ordinal = idx.getMatchingOrdinal(keys);
        if(ordinal == -1)
            return null;
        return api.getPackageMovieDealCountryGroup(ordinal);
    }

}