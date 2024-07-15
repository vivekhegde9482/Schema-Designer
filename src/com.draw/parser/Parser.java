package com.draw.parser;

import com.draw.elements.Page;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface Parser {
    public  void addTablesToPage(String source, Page page) throws Exception;
}
