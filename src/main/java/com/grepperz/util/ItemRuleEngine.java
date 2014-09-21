package com.grepperz.util;


import com.grepperz.model.DbInitializer;


import java.util.HashSet;

import java.util.List;
import java.util.Set;

/**
 * Created by mayank.gupta on 20/09/14.
 */
public class ItemRuleEngine {
    public static List<DbInitializer.CategoryNodes> listMen = DbInitializer.categoryToCategoryRelationship.get(DbInitializer.CategoryNodes.MEN);
    public static List<DbInitializer.CategoryNodes> listWomen = DbInitializer.categoryToCategoryRelationship.get(DbInitializer.CategoryNodes.WOMEN);
    public static List<DbInitializer.CategoryNodes> listGift = DbInitializer.categoryToCategoryRelationship.get(DbInitializer.CategoryNodes.GIFT);
    public static boolean menNode;
    public static boolean womenNode;
    public static boolean gift;

    public static Set<String> contextGenerator(String itemTitle, String itemDescription) {
        Set<String> categorySet = new HashSet<String>();

        if(itemTitle.toUpperCase().contains("COTTON") ||itemTitle.toUpperCase().contains("LINEN") ||itemDescription.toUpperCase().contains("COTTON") || itemDescription.toUpperCase().contains("LINEN"))
            categorySet.add(DbInitializer.CategoryNodes.SUMMER.toString());
        else if(itemTitle.toUpperCase().contains("WOOL") || itemTitle.toUpperCase().contains("TWEED") ||itemDescription.toUpperCase().contains("WOOL") || itemDescription.toUpperCase().contains("TWEED"))
            categorySet.add(DbInitializer.CategoryNodes.WINTER.toString());

        // processing the title to find category relationships
        for (DbInitializer.CategoryNodes node : DbInitializer.CategoryNodes.values()) {
            if (itemTitle.toUpperCase().contains(node.toString())) {
                categorySet.add(node.toString());
            }
            //processing the description to find category relationships
            if (itemDescription.toUpperCase().contains(node.toString())){
                categorySet.add(node.toString());
            }
        }
        for(String s : categorySet){
            for(DbInitializer.CategoryNodes node : listMen){
                if(s.equals(node.toString()))
                	menNode=true;
                    
            }
            for(DbInitializer.CategoryNodes node : listWomen){
                if(s.equals(node.toString()))
                  womenNode=true;
                	
            }

            for(DbInitializer.CategoryNodes node : listGift){
                if(s.equals(node.toString()))
                	gift=true;
                    
            }
        }  
            if(menNode)
            	categorySet.add(DbInitializer.CategoryNodes.MEN.toString());
            if(womenNode)
            	categorySet.add(DbInitializer.CategoryNodes.WOMEN.toString());
            if(gift)
            	categorySet.add(DbInitializer.CategoryNodes.GIFT.toString());

            return categorySet;
    }

}
