package com.draw;

import com.draw.elements.*;
import com.draw.parser.Parser;
import com.draw.ui.GUI;
import com.draw.util.ParserFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class Drawer {

    public static void main(String a[]) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        GUIProperties properties = new GUIProperties();
        GUI.invokeNewGUI(properties);
    }

    public File drawDocument(GUIProperties properties) throws Exception {
        Page page = new Page("output.xml");
        Parser parser = ParserFactory.getParser(ParserFactory.MICKEY_PARSER);
        for(File file:properties.getSelectedFiles()){
            parser.addTablesToPage(file.getAbsolutePath(), page);
        }
        page.generate();
        return new File("output.xml");
    }




}
