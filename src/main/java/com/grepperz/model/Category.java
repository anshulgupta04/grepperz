package com.grepperz.model;


import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.tooling.GlobalGraphOperations;

import java.util.HashMap;

/**
 * Created by mayank.gupta on 20/09/14.
 */
public class Category extends BaseNode {

    @Override
    public Label getLabel() {
        return DynamicLabel.label("CATEGORY");
    }
}
