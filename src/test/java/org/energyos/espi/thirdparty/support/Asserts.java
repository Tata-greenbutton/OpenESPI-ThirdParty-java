package org.energyos.espi.thirdparty.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.XpathEngine;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Asserts {
    public static void assertXpathValue(String expectedValue, String xpathExpression, String inXMLString) throws SAXException, IOException, XpathException {
        Document document = XMLUnit.buildControlDocument(inXMLString);
        assertXpathValue(expectedValue, xpathExpression, document);
    }

    public static void assertXpathValue(String expectedValue, String xpathExpression, Document inDocument) throws XpathException {
        XpathEngine simpleXpathEngine = XMLUnit.newXpathEngine();
        assertEquals(expectedValue, simpleXpathEngine.evaluate(xpathExpression, inDocument).trim());
    }

    public static void assertXpathValueStartsWith(String expectedPrefix, String xpathExpression, String inXMLString) throws IOException, SAXException, XpathException {
        Document xmlDocument = XMLUnit.buildControlDocument(inXMLString);
        XpathEngine simpleXpathEngine = XMLUnit.newXpathEngine();
        String updated = simpleXpathEngine.evaluate(xpathExpression, xmlDocument).trim();
        assertTrue(updated.startsWith(expectedPrefix));
    }
}
