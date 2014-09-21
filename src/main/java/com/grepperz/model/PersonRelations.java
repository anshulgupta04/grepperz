package com.grepperz.model;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

/**
 * Created by mayank.gupta on 20/09/14.
 */
public class PersonRelations extends BaseNode {
    @Override
    public Label getLabel() {
        return DynamicLabel.label("PERSON_RELATIONS");
    }
}
