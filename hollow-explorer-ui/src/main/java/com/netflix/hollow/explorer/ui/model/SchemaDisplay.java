package com.netflix.hollow.explorer.ui.model;

import com.netflix.hollow.core.schema.HollowMapSchema;
import com.netflix.hollow.core.schema.HollowCollectionSchema;
import com.netflix.hollow.core.schema.HollowObjectSchema;
import java.util.ArrayList;
import java.util.List;
import com.netflix.hollow.core.schema.HollowSchema;

public class SchemaDisplay {
    
    private final HollowSchema schema;
    private final List<SchemaDisplayField> displayFields;
    
    private boolean isExpanded;
    
    public SchemaDisplay(HollowSchema schema) {
        this.schema = schema;
        this.displayFields = createDisplayFields();
        this.isExpanded = false;
    }
    
    private List<SchemaDisplayField> createDisplayFields() {
        List<SchemaDisplayField> displayFields = new ArrayList<SchemaDisplayField>();
        
        switch(schema.getSchemaType()) {
        case OBJECT:
            HollowObjectSchema objSchema = (HollowObjectSchema)schema;
            
            for(int i=0;i<objSchema.numFields();i++)
                displayFields.add(new SchemaDisplayField(objSchema, i));

            return displayFields;
            
        case LIST:
        case SET:
            HollowCollectionSchema collSchema = (HollowCollectionSchema)schema;
            
            displayFields.add(new SchemaDisplayField(collSchema));
            
            return displayFields;
            
        case MAP:
            HollowMapSchema mapSchema = (HollowMapSchema)schema;
            
            displayFields.add(new SchemaDisplayField(mapSchema, 0));
            displayFields.add(new SchemaDisplayField(mapSchema, 1));
            
            return displayFields;
        }
        
        throw new IllegalArgumentException();
    }
    
    public String getTypeName() {
        return schema.getName();
    }
    
    public HollowSchema getSchema() {
        return schema;
    }
    
    public List<SchemaDisplayField> getFields() {
        return displayFields;
    }
    
    public void setExpanded(boolean isExpanded) {
        this.isExpanded = isExpanded;
    }
    
    public boolean isExpanded() {
        return isExpanded;
    }
    
}
