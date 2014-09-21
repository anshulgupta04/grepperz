package com.grepperz.model;

import org.neo4j.graphdb.RelationshipType;

/**
 * Created by mayank.gupta on 20/09/14.
 */
public enum Relationships implements RelationshipType {
    BELONGS_TO,
    ALIGNS_TO,
    PURCHASED;
    }
