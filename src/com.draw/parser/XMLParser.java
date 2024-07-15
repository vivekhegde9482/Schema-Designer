package com.draw.parser;

import com.draw.elements.*;
import com.draw.util.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser implements Parser{

@Override
    public void addTablesToPage(String sourceFile, Page page) throws Exception {

        Document document = XMLUtils.getDocument(sourceFile);
        NodeList list = document.getElementsByTagName("table");
        if (list.getLength()<=0){
            throw new RuntimeException("no tables found in file :"+sourceFile);
        }
        for (int i=0;i<list.getLength();i++) {
            Node node = list.item(i);
            Table table = new Table(((Element)node).getAttribute("name"));
            NodeList columns = ((Element) node).getElementsByTagName("column");
            for (int j=0;j<columns.getLength();j++){
                Element columnEl = (Element) columns.item(j);
                Column column = new Column(columnEl.getAttribute("name"));
                Row row = new Row(columnEl.getAttribute("name"));
                row.addColumn(column);
                table.addRow(row);
            }

            NodeList foreignKeys = ((Element) node).getElementsByTagName("foreign-key");
            for (int j=0;j<foreignKeys.getLength();j++){
                Element fEl = (Element) foreignKeys.item(j);
                String referenceTable = fEl.getAttribute("reference-table-name");
                Table refTable = page.getTable(referenceTable);
                if (refTable == null){
                    continue;
                }

                String localCM = fEl.getElementsByTagName("fk-local-column").item(0).getTextContent();
                String foreignCM = fEl.getElementsByTagName("fk-reference-column").item(0).getTextContent();

                String sourceID = table.getRowIDOfColumn(localCM);
                if (sourceID == null){
                    throw new RuntimeException("Local column not found");
                }

                String targetID = refTable.getRowIDOfColumn(foreignCM);
                if (targetID == null){
                    throw new RuntimeException("Local column not found");
                }
                ForeignKey fk = new ForeignKey();
                fk.setSource(sourceID);
                fk.setTarget(targetID);
                table.addForeignKey(fk);
            }
            page.addTable(table);
        }
    }

}
