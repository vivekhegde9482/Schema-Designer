package com.draw.elements;

import com.draw.constant.ElementFiles;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Page {

    private Document document;
    private String outputFile;
    private List<Table>  tables = new ArrayList<>();

    private int currentX=0;
    private int currentY = 0;
    private int tableCount = 0;

    private int tableMaxHeight =0;
    public Page(String fileName) throws ParserConfigurationException, IOException, SAXException {
        this.outputFile = fileName;
        createDoc();
    }

    private Document getDocument(String fileName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
         return docBuilder.parse(fileName);
    }

    private void createDoc() throws IOException, ParserConfigurationException, SAXException {
        File file = new File(this.outputFile);
        if(!file.exists()){
            file.createNewFile();
        }
        this.document = getDocument(ElementFiles.ROOT);
    }

    public Table getTable(String name){
        for (Table table: tables) {
            if (table.getName().equals(name)){
                return table;
            }
        }
        return null;
    }

    public void addTable(Table table) throws ParserConfigurationException, IOException, SAXException {
        tables.add(table);
        addTableToDoc(table);
        tableCount++;
    }

    private void addTableToDoc(Table table) throws ParserConfigurationException, IOException, SAXException {
        Document tableDoc = getDocument(ElementFiles.TABLE);

        Element mxCel = (Element) tableDoc.getElementsByTagName("mxCell").item(0);
        mxCel.setAttribute("id",table.getId());
        mxCel.setAttribute("value",table.getName());

        Element mxGeo = (Element) tableDoc.getElementsByTagName("mxGeometry").item(0);
        mxGeo.setAttribute("width", String.valueOf(table.getWidth()));
        mxGeo.setAttribute("height", String.valueOf(table.getHeight()));
        mxGeo.setAttribute("x", String.valueOf(currentX));
        mxGeo.setAttribute("y", String.valueOf(currentY));

        tableMaxHeight = Math.max(tableMaxHeight,table.getHeight());

        currentX = currentX + table.getWidth() + 50;
        if(tableCount >3){
            currentY = currentY + tableMaxHeight + 50;
            currentX =0;
            tableMaxHeight =0;
            tableCount =0;
        }


        Node rootNode = document.getElementsByTagName("root").item(0);

        Node geoNode = document.importNode(mxGeo,false);
        Node cellNode = document.importNode(mxCel,false);
        cellNode.appendChild(geoNode);
        rootNode.appendChild(cellNode);
        for (Row row : table.getRows()) {
            addRow(row);
        }

        for(ForeignKey key:table.getForeignKeys()){
            addFK(key);
        }

    }

    private void addFK(ForeignKey fk) throws ParserConfigurationException, IOException, SAXException {
        Document rowDoc = getDocument(ElementFiles.ARROW);
        Element mxCel = (Element) rowDoc.getElementsByTagName("mxCell").item(0);
        mxCel.setAttribute("id",fk.getId());
        mxCel.setAttribute("source",fk.getSource());
        mxCel.setAttribute("target",fk.getTarget());

        Node rootNode = document.getElementsByTagName("root").item(0);

        Node cellNode = document.importNode(mxCel,true);
        rootNode.appendChild(cellNode);
    }

    private void addRow(Row row) throws ParserConfigurationException, IOException, SAXException {
        Document rowDoc = getDocument(ElementFiles.ROW);
        Element mxCel = (Element) rowDoc.getElementsByTagName("mxCell").item(0);
        mxCel.setAttribute("id",row.getId());
        mxCel.setAttribute("parent",row.getParent());

        Element mxGeo = (Element) rowDoc.getElementsByTagName("mxGeometry").item(0);
        mxGeo.setAttribute("width", String.valueOf(row.getWidth()));
        mxGeo.setAttribute("height", String.valueOf(row.getHeight()));
        mxGeo.setAttribute("y", String.valueOf(row.getY()));

        Node rootNode = document.getElementsByTagName("root").item(0);

        Node cellNode = document.importNode(mxCel,true);
        rootNode.appendChild(cellNode);

        for (Column column:row.getColumns()){
            addColumn(column);
        }
    }

    private void addColumn(Column column) throws ParserConfigurationException, IOException, SAXException {
        Document rowDoc = getDocument(ElementFiles.COLUMN);

        Element mxCel = (Element) rowDoc.getElementsByTagName("mxCell").item(0);
        mxCel.setAttribute("id",column.getId());
        mxCel.setAttribute("parent",column.getParent());
        mxCel.setAttribute("value",column.getValue());

        Element mxGeo = (Element) rowDoc.getElementsByTagName("mxGeometry").item(0);
        mxGeo.setAttribute("width", String.valueOf(column.getWidth()));
        mxGeo.setAttribute("height", String.valueOf(column.getHeight()));
        mxGeo.setAttribute("x", String.valueOf(column.getX()));

        Element mxRec = (Element) rowDoc.getElementsByTagName("mxRectangle").item(0);
        mxRec.setAttribute("width", String.valueOf(column.getWidth()));
        mxRec.setAttribute("height", String.valueOf(column.getHeight()));

        Node rootNode = document.getElementsByTagName("root").item(0);

        Node cellNode = document.importNode(mxCel,true);

        rootNode.appendChild(cellNode);
    }

    public void generate() throws TransformerException {
        writeXml(this.document,this.outputFile);
    }

    public void  writeXml(Document doc,
                                 String fileName)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");// No I18N
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(source, result);

    }

}
