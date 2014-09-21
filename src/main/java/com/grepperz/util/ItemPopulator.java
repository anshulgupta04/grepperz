package com.grepperz.util;

import java.util.Map;
import java.util.Set;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.index.IndexManager;

import com.grepperz.model.DbInitializer;
import com.grepperz.model.Relationships;

/**
 * Created by mayank.gupta on 20/09/14.
 */
public class ItemPopulator {
    private Label label = DynamicLabel.label("ITEM");
    
    private final String TITLE = "title";
    private final String DESCRIPTION = "description";

	public void createNode(Map<String, String> attributes) {
		Node itemNode;
		GraphDatabaseService graphDb = DbInitializer.getDbInstance();
		Set<String> categorySet = ItemRuleEngine.contextGenerator(
				attributes.get(TITLE), attributes.get(DESCRIPTION));
		// Database operations go here
		try (Transaction tx = graphDb.beginTx()) {
			IndexManager index = DbInitializer.getDbInstance().index();
		    Index<Node> name = index.forNodes("name");
			itemNode = graphDb.createNode(label);
			for (String key : attributes.keySet()) {
				itemNode.setProperty(key, attributes.get(key));
			}
			for (String s : categorySet) {
				IndexHits<Node> hit = name.get("name", s);
				for(Node n : hit){
					itemNode.createRelationshipTo(n,Relationships.BELONGS_TO);
				}

				if (s.equals(DbInitializer.CategoryNodes.LINGERIE.toString())) {
					for (DbInitializer.PersonRelationsNodes node : DbInitializer.categoryToPersonRelationship
							.get(DbInitializer.CategoryNodes.LINGERIE))
						hit = name.get("name", node.toString());
					for(Node n : hit){
						itemNode.createRelationshipTo(n,Relationships.BELONGS_TO);
					}
				}
				if (s.equals(DbInitializer.CategoryNodes.SUMMER.toString())) {
					for (DbInitializer.LocationNodes node : DbInitializer.categoryToLocationRelationship
							.get(DbInitializer.CategoryNodes.SUMMER))
						hit = name.get("name", node.toString());
					for(Node n : hit){
						itemNode.createRelationshipTo(n,Relationships.BELONGS_TO);
					}
				}

				if (s.equals(DbInitializer.CategoryNodes.WINTER.toString())) {
					for (DbInitializer.LocationNodes node : DbInitializer.categoryToLocationRelationship
							.get(DbInitializer.CategoryNodes.WINTER))
						hit = name.get("name", node.toString());
					for(Node n : hit){
						itemNode.createRelationshipTo(n,Relationships.BELONGS_TO);
					}
				}
			}
			tx.success();
		}
	}
}
