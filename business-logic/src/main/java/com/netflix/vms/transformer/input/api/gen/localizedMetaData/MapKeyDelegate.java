package com.netflix.vms.transformer.input.api.gen.localizedMetaData;

import com.netflix.hollow.api.objects.delegate.HollowObjectDelegate;


@SuppressWarnings("all")
public interface MapKeyDelegate extends HollowObjectDelegate {

    public String getValue(int ordinal);

    public boolean isValueEqual(int ordinal, String testValue);

    public MapKeyTypeAPI getTypeAPI();

}