package com.netflix.vms.transformer.data.gen.showSeasonEpisode;

import com.netflix.hollow.api.testdata.HollowTestRecord;
import com.netflix.hollow.core.schema.HollowListSchema;
import com.netflix.hollow.core.schema.HollowSchema;
import com.netflix.hollow.core.write.HollowListWriteRecord;
import com.netflix.hollow.core.write.HollowWriteRecord;
import com.netflix.hollow.core.write.HollowWriteStateEngine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeasonListTestData extends HollowTestRecord {

    private static final HollowListSchema SCHEMA = new HollowListSchema("SeasonList", "Season");

    private final List<SeasonTestData> elements = new ArrayList<>();

    public SeasonListTestData(SeasonTestData... elements) {
        this.elements.addAll(Arrays.asList(elements));
    }

    public static SeasonListTestData SeasonList(SeasonTestData... elements) {
        return new SeasonListTestData(elements);
    }

    @Override public HollowSchema getSchema() { return SCHEMA; }

    public HollowWriteRecord toWriteRecord(HollowWriteStateEngine writeEngine) {
        HollowListWriteRecord rec = new HollowListWriteRecord();
        for(SeasonTestData e : elements) {
            rec.addElement(e.addTo(writeEngine));
        }
        return rec;
    }

}