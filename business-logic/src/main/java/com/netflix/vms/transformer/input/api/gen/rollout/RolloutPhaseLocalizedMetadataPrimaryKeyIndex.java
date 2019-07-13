package com.netflix.vms.transformer.input.api.gen.rollout;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.index.AbstractHollowUniqueKeyIndex;
import com.netflix.hollow.api.consumer.index.HollowUniqueKeyIndex;
import com.netflix.hollow.core.schema.HollowObjectSchema;

/**
 * @deprecated see {@link com.netflix.hollow.api.consumer.index.UniqueKeyIndex} which can be built as follows:
 * <pre>{@code
 *     UniqueKeyIndex<RolloutPhaseLocalizedMetadata, K> uki = UniqueKeyIndex.from(consumer, RolloutPhaseLocalizedMetadata.class)
 *         .usingBean(k);
 *     RolloutPhaseLocalizedMetadata m = uki.findMatch(k);
 * }</pre>
 * where {@code K} is a class declaring key field paths members, annotated with
 * {@link com.netflix.hollow.api.consumer.index.FieldPath}, and {@code k} is an instance of
 * {@code K} that is the key to find the unique {@code RolloutPhaseLocalizedMetadata} object.
 */
@Deprecated
@SuppressWarnings("all")
public class RolloutPhaseLocalizedMetadataPrimaryKeyIndex extends AbstractHollowUniqueKeyIndex<RolloutAPI, RolloutPhaseLocalizedMetadata> implements HollowUniqueKeyIndex<RolloutPhaseLocalizedMetadata> {

    public RolloutPhaseLocalizedMetadataPrimaryKeyIndex(HollowConsumer consumer) {
        this(consumer, true);
    }

    public RolloutPhaseLocalizedMetadataPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefresh) {
        this(consumer, isListenToDataRefresh, ((HollowObjectSchema)consumer.getStateEngine().getNonNullSchema("RolloutPhaseLocalizedMetadata")).getPrimaryKey().getFieldPaths());
    }

    public RolloutPhaseLocalizedMetadataPrimaryKeyIndex(HollowConsumer consumer, String... fieldPaths) {
        this(consumer, true, fieldPaths);
    }

    public RolloutPhaseLocalizedMetadataPrimaryKeyIndex(HollowConsumer consumer, boolean isListenToDataRefresh, String... fieldPaths) {
        super(consumer, "RolloutPhaseLocalizedMetadata", isListenToDataRefresh, fieldPaths);
    }

    @Override
    public RolloutPhaseLocalizedMetadata findMatch(Object... keys) {
        int ordinal = idx.getMatchingOrdinal(keys);
        if(ordinal == -1)
            return null;
        return api.getRolloutPhaseLocalizedMetadata(ordinal);
    }

}