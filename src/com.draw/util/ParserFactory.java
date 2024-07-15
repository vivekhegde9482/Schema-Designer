package com.draw.util;

import com.draw.parser.XMLParser;
import com.draw.parser.Parser;

public class ParserFactory {

    public static int MICKEY_PARSER =1;

    public static Parser getParser(int parser){
        switch (parser){
            default -> {
                return new XMLParser();
            }
        }
    }


}
